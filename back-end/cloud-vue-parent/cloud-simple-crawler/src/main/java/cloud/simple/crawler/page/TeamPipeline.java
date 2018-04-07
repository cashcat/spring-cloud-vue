package cloud.simple.crawler.page;

import cloud.simple.crawler.biz.TeamCrawlerService;
import cloud.simple.crawler.model.TeamCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
@Component
public class TeamPipeline implements Pipeline {
    @Autowired
    private TeamCrawlerService service;
    // ResultItems保存了抽取结果，它是一个Map结构，
    // 在page.putField(key,value)中保存的数据，可以通过ResultItems.get(key)获取
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<TeamCrawler> teams  = resultItems.get("teams");
        for(TeamCrawler team : teams){
            TeamCrawler model  =service.selectByPrimaryKey(team.getUuid());
            if(model==null){
                service.save(team);
            }
        }
    }
}
