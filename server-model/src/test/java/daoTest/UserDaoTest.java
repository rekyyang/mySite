package daoTest;

import reky.server.domain.User.User;
import reky.server.dao.UserDao.UserDao;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;


public class UserDaoTest {

    @Resource(name = "UserDao")
    private UserDao userDao;

    private ConcurrentHashMap<String, User> user;

    static class main{
        static void main(){

        }
    }
}
