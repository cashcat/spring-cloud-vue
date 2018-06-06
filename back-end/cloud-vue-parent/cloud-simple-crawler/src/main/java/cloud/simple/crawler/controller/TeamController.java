package cloud.simple.crawler.controller;

import cloud.simple.crawler.biz.ImageCrawlerService;
import cloud.simple.crawler.biz.TeamCrawlerService;
import cloud.simple.crawler.model.TeamCrawler;
import cloud.simple.crawler.page.TeamPipeline;
import cloud.simple.crawler.util.FastJsonUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单控制层
 * @author leo.aqing
 */
@RestController
@RequestMapping("/team")
@Api(value = "SysAdminMenusController", description="系统菜单接口")
public class TeamController extends CommonController{
	@Autowired
	private TeamCrawlerService service;
	@Autowired
	private ImageCrawlerService imageCrawlerService;
	@Autowired
	private TeamPipeline teamPipeline;
	
	/**
	 * 列表查詢
	 */
	@ApiOperation(value = "列表", httpMethod="GET")
	@RequestMapping(value = "/query", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String query(@RequestBody(required=false) TeamCrawler record,HttpServletRequest request) {
		PageInfo<TeamCrawler> userPage = service.getDataList(record);
		return FastJsonUtils.resultSuccess(200, "成功", userPage);
	}
}
