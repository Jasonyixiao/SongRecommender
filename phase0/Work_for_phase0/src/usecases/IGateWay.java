package usecases;

import entities.user;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public interface IGateWay {
    void save(Serializable o) throws IOException;
    HashMap<String, user>  read() throws ClassNotFoundException;
}
