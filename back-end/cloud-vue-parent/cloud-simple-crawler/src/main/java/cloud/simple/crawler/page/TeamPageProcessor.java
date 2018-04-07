package cloud.simple.crawler.page;

import cloud.simple.crawler.contants.Status;
import cloud.simple.crawler.contants.Web;
import cloud.simple.crawler.model.TeamCrawler;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

public class TeamPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Override
    public void process(Page page) {
        List<TeamCrawler> teams = new ArrayList();
        Html h = page.getHtml();
       //<div class="TEAM_URL active" gtid="a614ae1c-597a-431d-8134-de681cdabca3">队伍3</div>
        List<Selectable>  selectables = h.$(".Team").nodes();
        for(Selectable selectable :selectables){
            String uuid = selectable.$("div","gtid").get();
            String name = selectable.xpath("//div/html()").toString();
            TeamCrawler team = new TeamCrawler();
            team.setStatus(Status.SAVING);
            team.setUuid(uuid);
            team.setName(name);
            teams.add(team);
        }
        page.putField("teams",teams);
    }

    @Override
    public Site getSite() {
        // wixin brower
        site.addHeader("User-Agent",Web.USER_AGENT);
        return this.site;
    }
    public static void main(String[] args) {
        Spider s =Spider.create(new TeamPageProcessor());
        s.addUrl(Web.TEAM_URL);
        s.run();
    }
}
