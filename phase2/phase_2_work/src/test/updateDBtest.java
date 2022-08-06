import entities.User;
import mapper.UpdateDB;
import mapper.UserMapper;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils1;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class updateDBtest {
    @Test
    public void contextLoads() {
    }
    @Test
    public void test() {
        //step 1, get an instance of sqlsession
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        //step 2, execute sql code
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class); // we do this to get the Usermapper
        List<User> users = userMapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        // close sqlsession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        UpdateDB updateDB = new UpdateDB();
        assert Objects.equals(updateDB.getUserById("hz2002").getUsername(),
                "hz2002");

    }
    //增改需要提交事物
	@Test
	public void addUser(){
        UpdateDB updateDB = new UpdateDB(); //TODO this is for you harry!!!
        String result = updateDB.addUser("hz2002", "harryIloveU");
        assert Objects.equals(result, "Success!");
        updateDB.deleteUser("hz2002");
	}

    @Test
    public void updateUser() {
        UpdateDB updateDB = new UpdateDB();
        assert Objects.equals(updateDB.updateUser("hz2002", "ds"),
                "Success!"); //TODO create methods to update other changes to database
    }

    @Test
    public void deleteUser() {
        UpdateDB updateDB = new UpdateDB();
        assert Objects.equals(updateDB.deleteUser("jz2002"), "Success!");
    }
}
