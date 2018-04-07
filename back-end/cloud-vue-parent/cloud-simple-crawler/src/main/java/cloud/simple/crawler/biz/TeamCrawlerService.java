package cloud.simple.crawler.biz;

import cloud.simple.crawler.base.BaseServiceImpl;
import cloud.simple.crawler.dao.TeamCrawlerDao;
import cloud.simple.crawler.model.TeamCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import us.codecraft.webmagic.Site;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamCrawlerService extends BaseServiceImpl<TeamCrawler> {
	@Autowired
	private TeamCrawlerDao dao;
	
	@Override
	public Mapper<TeamCrawler> getMapper() {
		return dao;
	}



	public static void main(String[] args) {

	}

}
