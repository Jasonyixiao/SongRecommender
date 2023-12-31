package driver;

import usecases.IGateWay;
import entities.User;

import java.io.*;
import java.util.HashMap;


public class GateWay implements IGateWay {
    private final String file = "./user";

    public GateWay(){
    }


    public void save(Serializable o) throws IOException {

        OutputStream file = new FileOutputStream(this.file);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(o); //allUsers
        output.close();
    }


    public HashMap<String, User> read () throws ClassNotFoundException {

        try {
            InputStream file = new FileInputStream(this.file);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            HashMap<String, User> result = (HashMap<String, User>) input.readObject();
            input.close();
            return result;
        } catch (IOException ex) {
            return new HashMap<>();
        }
    }


}
