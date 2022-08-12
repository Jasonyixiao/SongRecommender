package entities;

import java.io.Serializable;

/**
 * This class represents a Notification in the program.
 */

// Note we possibly can separate out recommend and message as two separate classes that extends Notification
public class Notification implements Serializable {
    private final String content; // for now it is an url of a song, we use this for recommending a song to a user.

    private final String message;

    private String songName;

    private boolean isNew;

    private final String sender; // username of the sender

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
        this.songName = "";
    }
    /**
     * Getter for songName
     * @return return the song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Setter for songName
     * @param songName is the name of the song
     */

    public void setSongName(String songName) {
        this.songName = songName;
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
