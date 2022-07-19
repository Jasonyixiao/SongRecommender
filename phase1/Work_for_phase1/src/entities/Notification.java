package entities;

public class Notification {
    private String Content; // for now it is an url of a song
    public Notification(String content) {
        this.Content = content;
    }

    public String getContent() {
        return Content;
    }
}
