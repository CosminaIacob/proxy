package design.patterns.media_library;

public record Video(String id, String title, String data) {

    Video(String id, String title) {
        this(id, title, "Random video.");
    }
}
