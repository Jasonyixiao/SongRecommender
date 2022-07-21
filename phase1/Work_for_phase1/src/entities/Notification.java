package entities;

/**
 * This class represents a Notification in the program.
 */
public class Notification {
    private String Content; // for now it is an url of a song

    /**
     * Constructor of a notification, stores the content as a variable.
     * @param content
     */
    public Notification(String content) {
        this.Content = content;
    }

    /**
     * Getter for content.
     * @return the content in the notification.
     */
    public String getContent() {
        return Content;
    }
}
