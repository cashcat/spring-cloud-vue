package cloud.simple.crawler.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import cloud.simple.crawler.base.BaseEntity;
import cloud.simple.crawler.contants.Status;

import java.util.List;

@Table(name = "`TEAM_CRAWLER`")
public class TeamCrawler  extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;
	@Column(name = "`NAME`")
	private String name;
	@Column(name = "`STATUS`")
	private String status;
	@Column(name = "`FAIL_COUNT`")
	private int failCount;
	/**
	 * images
	 */
	@Transient
	private List<ImageCrawler> images;
	/**
	 * videos
	 */
	@Transient
	private List<VideoCrawler> videos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ImageCrawler> getImages() {
		return images;
	}

	public void setImages(List<ImageCrawler> images) {
		this.images = images;
	}

	public List<VideoCrawler> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoCrawler> videos) {
		this.videos = videos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
}