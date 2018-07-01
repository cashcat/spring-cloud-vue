package cloud.simple.crawler.biz;

import cloud.simple.crawler.base.BaseServiceImpl;
import cloud.simple.crawler.dao.TeamCrawlerDao;
import cloud.simple.crawler.model.TeamCrawler;
import cloud.simple.crawler.util.BeanToMapUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import us.codecraft.webmagic.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeamCrawlerService extends BaseServiceImpl<TeamCrawler> {
	@Autowired
	private TeamCrawlerDao dao;
	
	@Override
	public Mapper<TeamCrawler> getMapper() {
		return dao;
	}

	public PageInfo<TeamCrawler> getDataList(TeamCrawler record) {
		if (record == null)
		{
			record = new TeamCrawler();
		}
		return super.selectPage(record.getPage(), record.getRows(), record);
	}
}
