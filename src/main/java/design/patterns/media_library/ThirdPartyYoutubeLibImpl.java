package design.patterns.media_library;

import java.util.HashMap;

public class ThirdPartyYoutubeLibImpl implements ThirdPartyYoutubeLib {
    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomevideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.println("Connecting to " + server + "...");
        experienceNetworkLatency();
        System.out.println("Connected!\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading populars...");

        experienceNetworkLatency();

        HashMap<String, Video> videos = new HashMap<String, Video>();
        videos.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        videos.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        videos.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        videos.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        videos.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.println("Done!\n");
        return videos;
    }

    private Video getSomevideo(String videoId) {
        System.out.println("Downloading video...");

        experienceNetworkLatency();

        Video video = new Video(videoId, "Some video title");

        System.out.println("Done!\n");
        return video;
    }
}
