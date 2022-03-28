package model;

public class YoutubeLink {
    private String videoURL;

    public YoutubeLink(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
