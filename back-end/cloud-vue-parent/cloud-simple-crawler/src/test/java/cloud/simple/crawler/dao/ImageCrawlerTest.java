package cloud.simple.crawler.dao;


import cloud.simple.crawler.CloundSimpleCrawlerApplication;
import cloud.simple.crawler.biz.ImageCrawlerService;
import cloud.simple.crawler.biz.TeamCrawlerService;
import cloud.simple.crawler.contants.Status;
import cloud.simple.crawler.contants.Web;
import cloud.simple.crawler.model.ImageCrawler;
import cloud.simple.crawler.model.TeamCrawler;
import cloud.simple.crawler.page.ImagePipeline;
import cloud.simple.crawler.page.TeamJsonProcessor;
import cloud.simple.crawler.page.TeamPageProcessor;
import cloud.simple.crawler.page.TeamPipeline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloundSimpleCrawlerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class ImageCrawlerTest {
    @Autowired
    private TeamCrawlerService teamService;
    @Autowired
    private ImageCrawlerService imageService;
    @Autowired
    private TeamPipeline teamPipeline;
    @Autowired
    private ImagePipeline imagePipeline;
    @Test
    public void saveImage() throws Exception {
        ImageCrawler image  = new ImageCrawler();
        image.setName("test");
        image.setGroupUuid("ass");
        image.setUuid("1212");
        imageService.save(image);
    }

    /**
     * save all data to db and disk
     * @throws UnsupportedEncodingException
     */
    @Test
    public void saveAllImages() throws UnsupportedEncodingException {
        List<TeamCrawler> list = teamService.select(null);
        for(TeamCrawler team :list){
            Request request = new Request(Web.TEAMDATA_URL);
            request.setMethod(HttpConstant.Method.POST);
            request.addHeader("User-Agent",Web.USER_AGENT);
            String json = "{\"GTId\":\""+team.getUuid()+"\"}";
            request.setRequestBody(HttpRequestBody.json(json,"utf-8"));
            PageProcessor page = new TeamJsonProcessor();
            Site site = page.getSite();
            site.addHeader("User-Agent",Web.USER_AGENT);
            Spider s =Spider.create(page);
            s.addPipeline(imagePipeline);
            s.addRequest(request);
            s.run();
        }

    }


}
