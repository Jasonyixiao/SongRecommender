package usecases;

import entities.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public interface IGateWay {
    void save(Serializable o) throws IOException;
    HashMap<String, User>  read() throws ClassNotFoundException;
}
