package mapper;

import entities.User;

import java.util.List;

public interface UserMapper {

    List<User> getAllUser();

    User getUserByUsername(String username);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(String username);
    }
