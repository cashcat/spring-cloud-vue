package cloud.simple.crawler.model;

import cloud.simple.crawler.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`video_crawler`")
public class VideoCrawler extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;

	@JsonProperty("TaskName")
	@Column(name = "`NAME`")
	private String name;

	@Column(name = "`GROUP_UUID`")
	private String groupUuid;

	@JsonProperty("Suffix")
	@Column(name = "`TYPE`")
	private String type;

	@JsonProperty("Path")
	@Column(name = "`PATH`")
	private String path;
	@Column(name = "`LOCAL_PATH`")
	private String localPath;

}