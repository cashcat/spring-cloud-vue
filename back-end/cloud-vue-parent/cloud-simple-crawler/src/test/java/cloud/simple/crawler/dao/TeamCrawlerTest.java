package cloud.simple.crawler.dao;


import ch.qos.logback.core.status.StatusBase;
import cloud.simple.crawler.CloundSimpleCrawlerApplication;
import cloud.simple.crawler.biz.ImageCrawlerService;
import cloud.simple.crawler.biz.TeamCrawlerService;
import cloud.simple.crawler.contants.Status;
import cloud.simple.crawler.contants.Web;
import cloud.simple.crawler.model.TeamCrawler;
import cloud.simple.crawler.page.TeamPageProcessor;
import cloud.simple.crawler.page.TeamPipeline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloundSimpleCrawlerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TeamCrawlerTest {
    @Autowired
    private TeamCrawlerService service;
    @Autowired
    private ImageCrawlerService imageCrawlerService;
    @Autowired
    private TeamPipeline teamPipeline;
    @Test
    public void selectTeam() throws Exception {
        TeamCrawler team =  service.selectByPrimaryKey("123");
        System.out.println(team);
    }
    @Test
    public void saveTeam() throws Exception {
        TeamCrawler team  = new TeamCrawler();
        team.setName("test");
        team.setUuid("aasdsa");
        team.setStatus(Status.OK);
        service.save(team);
    }

    /**
     * save all team to db
     * @throws Exception
     */
    @Test
    public void saveAllTeam() throws Exception {
        Spider s =Spider.create(new TeamPageProcessor());
        s.addPipeline(teamPipeline);
        s.addUrl(Web.TEAM_URL);
        s.run();

    }


}
