package design.patterns.proxy;

import design.patterns.media_library.ThirdPartyYoutubeLib;
import design.patterns.media_library.ThirdPartyYoutubeLibImpl;
import design.patterns.media_library.Video;

import java.util.HashMap;

public class YoutubeCacheProxy implements ThirdPartyYoutubeLib {

    private ThirdPartyYoutubeLib youtubeService;

    private HashMap<String, Video> cachePopular = new HashMap<>();

    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YoutubeCacheProxy() {
        this.youtubeService = new ThirdPartyYoutubeLibImpl();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
