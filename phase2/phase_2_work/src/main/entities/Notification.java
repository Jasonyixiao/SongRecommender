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
     * Constructor of a notification, stores content(url of song for now), message, isNew, sender as variables.
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

    /**
     * Setter of content.
     * @param content is the content we are setting.
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Getter for message.
     * @return the message of this notification.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Setter for message
     * @param message is the message we are setting.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Setter for isNew.
     * @param isNew is true for read message, false for unread.
     */
    public void setIsRead(boolean isNew) { // users will have the optiont to mark notification as read or unread
        this.isNew = isNew;
    }

    /**
     * Getter for isNew.
     * @return true is this notification is unread(new), false if is read(old).
     */
    public boolean getIsNew() { // this allow us to check if a notification is read
        return this.isNew;
    }

    /**
     * Setter for sender.
     * @param username is the username of the sender.
     */
    public void setSender(String username) {
        this.sender = username;
    }

    /**
     * Getter for sender.
     * @return the username of the sender.
     */
    public String getSender() {
        return this.sender;
    }

}
