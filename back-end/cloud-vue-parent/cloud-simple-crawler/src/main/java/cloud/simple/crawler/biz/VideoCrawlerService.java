package cloud.simple.crawler.biz;

import cloud.simple.crawler.base.BaseServiceImpl;
import cloud.simple.crawler.dao.VideoCrawlerDao;
import cloud.simple.crawler.model.VideoCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class VideoCrawlerService extends BaseServiceImpl<VideoCrawler> {
	
	@Autowired
	private VideoCrawlerDao dao;
	
	@Override
	public Mapper<VideoCrawler> getMapper() {
		return dao;
	}

}
