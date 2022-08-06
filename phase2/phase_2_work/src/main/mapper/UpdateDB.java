package mapper;

import entities.User;
import mapper.UserMapper;
import utils.MybatisUtils1;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class UpdateDB {

    public UpdateDB() {
    }

    public String addUser(String username, String password) {
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.addUser(new User(
                username,
                password));
        sqlSession.commit();
        sqlSession.close();
        if (res > 0) {
            return "Success!";
        } else {
            return "failed to create a new user";
        }
        // TODO change the SQL code in UserMapper.xml
        //提交事务
    }

    public User getUserById(String username){
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        // Todo change getUserByUsername to take in username as parameter
        // TODO change the SQL code in UserMapper.xml
        sqlSession.close();
        return user;
    }
    public String updateUser(String username, String password) {
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.updateUser(new User(username,
                password)); // TODO hash the password
        // TODO change the SQL code in UserMapper.xml
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        if (res > 0) {
            return "Success!";
        } else{
            return "Failed to update!";
        }

    }

    public String deleteUser(String username) {
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.deleteUser(username); // TODO change deleteUser to take in String as parameter
        sqlSession.commit();
        // TODO change the SQL code in UserMapper.xml
        // Note if we do not commit, the database will never get updated.
        sqlSession.close();
        if (res > 0) {
            return "Success!";
        } else {
            return "Failure";
        }
    }

    //TODO change the test code in LoginApplicationTests


}
