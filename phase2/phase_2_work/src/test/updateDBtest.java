import entities.User;
import mapper.UserMapper;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils1;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class updateDBtest {
    @Test
    void contextLoads() {
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
        SqlSession sqlSession = MybatisUtils1.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserByUsername("12"));
        sqlSession.close();

    }
    //增改需要提交事物
//	@Test
//	public void addUser(){
//		SqlSession sqlSession = MybatisUtils.getSqlSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		int res = userMapper.addUser(new User(4, "hh", "djdjij1"));
//		if (res > 0) {
//			System.out.println("Success!");
//		}
//		//提交事务
//		sqlSession.commit();
//		sqlSession.close();
//
//	}
//    @Test
//    public void updateUser() {
//        UpdateDB updateDB = new UpdateDB();
//        assert Objects.equals(updateDB.updateUser("hz2002",
//                        "ds",
//                        new Date(),
//                        "dsd",
//                        "ds",
//                        "ds"),
//                "Success!");
//    }
//
//    @Test
//    public void deleteUser() {
//        UpdateDB updateDB = new UpdateDB();
//        assert Objects.equals(updateDB.deleteUser("jz2002"), "Success!");
//    }
}
