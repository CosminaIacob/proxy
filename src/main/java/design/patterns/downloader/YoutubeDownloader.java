package design.patterns.downloader;

import design.patterns.media_library.ThirdPartyYoutubeLib;
import design.patterns.media_library.Video;

import java.util.Map;

public class YoutubeDownloader {

    private ThirdPartyYoutubeLib api;

    public YoutubeDownloader(ThirdPartyYoutubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("""
                ---------------------------------------------------------
                Video page (imagine fancy HTML)
                ID: %s
                Title: %s
                Video: %s
                ---------------------------------------------------------
                """.formatted(video.id(), video.title(), video.data()));
    }

    public void renderPopularVideos() {
        Map<String, Video> popularVideos = api.popularVideos();
        System.out.println("""
                --------------------------------------------------
                Most popular video on YouTube (imagine fancy HTML)
                """);
        popularVideos.values().forEach(video ->
                System.out.println("""
                        ID: %s / Title:%s
                        """.formatted(video.id(), video.title())));
        System.out.println("-----------------------------------------------");
    }
}
