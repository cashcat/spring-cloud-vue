package cloud.simple.crawler.page;

import cloud.simple.crawler.biz.ImageCrawlerService;
import cloud.simple.crawler.biz.TeamCrawlerService;
import cloud.simple.crawler.contants.Status;
import cloud.simple.crawler.contants.Web;
import cloud.simple.crawler.model.ImageCrawler;
import cloud.simple.crawler.model.TeamCrawler;
import cloud.simple.crawler.model.TeamData;
import cloud.simple.crawler.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.Json;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;


@Component
public class ImagePipeline implements Pipeline {
    @Autowired
    private TeamCrawlerService teamService;
    @Autowired
    private ImageCrawlerService imageService;
    // ResultItems保存了抽取结果，它是一个Map结构，
    // 在page.putField(key,value)中保存的数据，可以通过ResultItems.get(key)获取
    @Override
    public void process(ResultItems resultItems, Task task) {
        Json json = resultItems.get("data");
        String groupUuid = resultItems.get("groupUuid");
        TeamCrawler team =  teamService.selectByPrimaryKey(groupUuid);
        boolean enable = false;
        TeamData data = JacksonUtil.createObjectByJackson(json.get(), TeamData.class);
        List<ImageCrawler> images = data.getImages();
        if(images==null){
            return;
        }
        String status = Status.OK;
        for(ImageCrawler image:images){
            String path = image.getPath();
            if(path==null||path==""){
                return;
            }
            String uuid = path.substring(path.lastIndexOf("/")+1,path.indexOf("."));
            image.setGroupUuid(groupUuid);
            image.setUuid(uuid);
            int result = downloadPicture(Web.IMAGE_URL+path,Web.SAVE_PATH+team.getName()+team.getUuid(),image.getName());
            if(result==1){
                enable = true;
                //保存图片成功后 写入数据库
                ImageCrawler model = imageService.selectByPrimaryKey(image.getUuid());
                if(model==null){
                    imageService.insert(image);
                }
            }else{
                status = Status.SAVING;
            }
        }
        if(!enable){
            team.setFailCount(team.getFailCount()+1);
            teamService.updateByPrimaryKey(team);
        }else if(Status.OK.equalsIgnoreCase(status)){
            team.setStatus(status);
            teamService.updateByPrimaryKey(team);
        }
    }

    /**
     * 下载图片
     * @param urlStr 图片地址
     * @param path 保存路径
     * @param name 图片名称
     * @return 1成功
     */
    private int downloadPicture(String urlStr ,String path,String name) {
        int result = -1;
        try{
            URL url = new URL(urlStr);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String imageName = name + ".jpg";
            File file=new File(path);    //设置下载路径
            if(!file.isDirectory()){
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path+"\\"+ imageName.trim()));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            dataInputStream.close();
            fileOutputStream.close();
            result = 1;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return result;
    }
}
