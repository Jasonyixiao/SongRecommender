package entities;

/**
 * This class represents a Notification in the program.
 */

// Note we possibly can separate out recommend and message as two separate classes that extends Notification
public class Notification {
    private String content; // for now it is an url of a song, we use this for recommending a song to a user.

    private String message;

    private boolean isNew;

    private String sender; // username of the sender

    /**
     * Constructor of a notification, stores content(url of song for now), message, isNew, sender as variables.
     * @param content is the URL of the song(for now)
     * @param message is the message of this notification.
     * @param sender is the username of the sender.
     */
    public Notification(String content, String message, String sender) {
        this.content = content;
        this.message = message;
        this.isNew = true;
        this.sender = sender;
    }

    /**
     * Getter for content.
     * @return the content in the notification.
     */
    public String getContent() {
        return content;
    }




    /**
     * Getter for message.
     * @return the message of this notification.
     */
    public String getMessage() {
        return this.message;
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
     * Getter for sender.
     * @return the username of the sender.
     */
    public String getSender() {
        return this.sender;
    }

}
