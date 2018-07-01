package cloud.simple.crawler.biz;

import cloud.simple.crawler.base.BaseServiceImpl;
import cloud.simple.crawler.dao.ImageCrawlerDao;
import cloud.simple.crawler.dao.TeamCrawlerDao;
import cloud.simple.crawler.model.ImageCrawler;
import cloud.simple.crawler.model.TeamCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class ImageCrawlerService extends BaseServiceImpl<ImageCrawler> {
	
	@Autowired
	private ImageCrawlerDao dao;
	
	@Override
	public Mapper<ImageCrawler> getMapper() {
		return dao;
	}



}
