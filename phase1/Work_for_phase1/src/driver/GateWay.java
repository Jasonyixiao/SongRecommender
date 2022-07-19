package driver;

import entities.Song;
import usecases.IGateWay;
import entities.User;

import java.io.*;
import java.util.HashMap;


public class GateWay implements IGateWay {
    private final String userFile = "./user";
    private final String songFile = "./song";

    public GateWay(){
    }


    public void save(Serializable o, String path) throws IOException {

        OutputStream file = new FileOutputStream(path);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(o); //allUsers
        output.close();
    }


    public HashMap<String, User> read_user () throws ClassNotFoundException {

        try {
            InputStream file = new FileInputStream(userFile);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            HashMap<String, User> result = (HashMap<String, User>) input.readObject();
            input.close();
            return result;
        } catch (IOException ex) {
            return new HashMap<>();
        }
    }

    @Override
    public HashMap<String, Song> read_song() throws ClassNotFoundException {
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


    public String getSongFile() {
        return songFile;
    }

    public String getUserFile() {
        return userFile;
    }
}
