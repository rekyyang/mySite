package reky.server.dao.UserDao;

        import reky.server.domain.User.User;
        import org.apache.ibatis.annotations.*;

        import java.util.List;

public interface UserDao {
    public boolean insertUser(@Param("user") User user);
    public boolean deleteUser(@Param("user") User user);
    public List<User> selectAllUser();
    public List<User> selectDynamic(@Param("userName")  String userName,
                                    @Param("password") String password,
                                    @Param("role")     String role,
                                    @Param("id")       String id
    );

    public boolean updateUser(@Param("userName")    String userName,
                              @Param("password")    String password,
                              @Param("role")        String role);
}
