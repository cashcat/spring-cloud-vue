package cloud.simple.crawler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamData {
    private int status;
    @JsonProperty("PicList")
    private List<ImageCrawler> images;
    @JsonProperty("VedioList")
    private List<VideoCrawler> videos;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "TeamData{" +
                "status=" + status +
                ", images=" + images +
                ", videos=" + videos +
                '}';
    }
}
