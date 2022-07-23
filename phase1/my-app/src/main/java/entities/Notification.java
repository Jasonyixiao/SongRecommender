package entities;

/**
 * This class represents a Notification in the program.
 */

// Note we possibly can separate out recommend and message as two separate classes that extends Notification
public class Notification {
    private String content; // for now it is an url of a song

    private String message;

    private boolean isNew;

    private String sender; // username of the sender

    /**
     * Constructor of a notification.
     */
    public Notification() {
        this.content = "";
        this.message = "";
        this.isNew = true;
        this.sender = "";
    }

    /**
     * Getter for content.
     * @return the content in the notification.
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIsRead(boolean isNew) { // users will have the optiont to mark notification as read or unread
        this.isNew = isNew;
    }

    public boolean getIsNew() { // this allow us to check if a notification is read
        return this.isNew;
    }

    public void setSender(String username) {
        this.sender = username;
    }

    public String getSender() {
        return this.sender;
    }

}
