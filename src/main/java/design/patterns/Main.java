package design.patterns;

import design.patterns.downloader.YoutubeDownloader;
import design.patterns.media_library.ThirdPartyYoutubeLibImpl;
import design.patterns.proxy.YoutubeCacheProxy;

public class Main {
    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeLibImpl());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.println("Time saved by caching proxy: " + (naive + smart) + "ms");
    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        //User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");

        // User might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}