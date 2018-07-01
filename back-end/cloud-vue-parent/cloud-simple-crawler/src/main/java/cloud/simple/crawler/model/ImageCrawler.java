package cloud.simple.crawler.model;

import cloud.simple.crawler.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "`IMAGE_CRAWLER`")
public class ImageCrawler extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;

	@JsonProperty("TaskName")
	@Column(name = "`NAME`")
	private String name;

	@Column(name = "`GROUP_UUID`")
	private String groupUuid;
	@Column(name = "`TYPE`")
	private String type;
	@JsonProperty("Path")
	@Column(name = "`PATH`")
	private String path;
	@Column(name = "`LOCAL_PATH`")
	private String localPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupUuid() {
		return groupUuid;
	}

	public void setGroupUuid(String groupUuid) {
		this.groupUuid = groupUuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ImageCrawler{" +
				"name='" + name + '\'' +
				", groupUuid='" + groupUuid + '\'' +
				", type='" + type + '\'' +
				", path='" + path + '\'' +
				", localPath='" + localPath + '\'' +
				'}';
	}
}