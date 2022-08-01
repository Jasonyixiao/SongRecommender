package driver;

import entities.Notification;
import entities.Song;
import entities.User;
import usecases.IGateWay;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * This Class is responsible for the data saving/reading task for the program.
 */
public class GateWay implements IGateWay {
    private final String userFile = "./user";
    private final String songFile = "./song";
    private final String notificationFile = "./notification";

    public GateWay(){
    }

    /**
     * This method will save the serializable object o to path.
     * @param o is the object being saved.
     * @param path is the path we are saving to.
     * @throws IOException  if error saving to file
     */
    public void save(Serializable o, String path) throws IOException {

        OutputStream file = new FileOutputStream(path);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(o); //allUsers
        output.close();
    }

    /**
     * This method will read the users into the program.
     * @return the deserialized map of all users.
     * @throws ClassNotFoundException if error reading from file.
     */
    @Override
    public HashMap<String, User> readUser() throws ClassNotFoundException {

        try {
            InputStream file = new FileInputStream(userFile);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            HashMap<String, User> result = (HashMap<String, User>) input.readObject();
            input.close();
            return result;
        } catch (IOException ex) {
            return new HashMap<>();      //IOException happens because the file at the path may be damaged, or it can not
                                         //be read at the moment, returning a new Hash
        }
    }

    /**
     * This method will read the songs into the program.
     * @return a deserialized Map of all Songs.
     * @throws ClassNotFoundException if error reading from file.
     */
    @Override
    public HashMap<String, Song> readSong() throws ClassNotFoundException {
        try {
            InputStream file = new FileInputStream(songFile);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            HashMap<String, Song> result = (HashMap<String, Song>) input.readObject();
            input.close();
            return result;
        } catch (IOException ex) {
            return new HashMap<>();
        }
    }

    /**
     * This method will read the notifications into the program.
     *
     * @return a deserialized Map of all notifications.
     * @throws ClassNotFoundException if error reading from file.
     */
    @Override
    public HashMap<String, List<Notification>> readNotification() throws ClassNotFoundException {
        try {
            InputStream file = new FileInputStream(songFile);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            HashMap<String, List<Notification>> result = (HashMap<String, List<Notification>>) input.readObject();
            input.close();
            return result;
        } catch (IOException ex) {
            return new HashMap<>();
        }
    }

    /**
     * Getter for songFile.
     * @return the path of storing the song data.
     */
    public String getSongFile() {
        return songFile;
    }

    /**
     * Getter for userFile.
     * @return the path of storing the user data.
     */
    public String getUserFile() {
        return userFile;
    }

    /**
     * Getter for notificationFile
     * @return the path of storing the notification data.
     */
    @Override
    public String getNotificationFile() {
        return notificationFile;
    }


}
