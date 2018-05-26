package reky.server.controller.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import reky.server.dao.UserDao.UserDao;
import reky.server.domain.Result.Result;
import reky.server.domain.User.User;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping("/login")
    @ResponseBody
    public Result in (@RequestParam(value = "userName", required = true)String userName,
                      @RequestParam(value = "password", required = true)String password, HttpServletResponse response){
        try{
            List<User> userList = userDao.selectDynamic(userName, password, null, null);
            if(userList == null || userList.size()==0){
                return Result.fail("用户名或密码错误");
            }
            Cookie roleCookie = new Cookie("role", userList.get(0).getRole());
            roleCookie.setMaxAge(10*60);
            roleCookie.setPath("/");
            response.addCookie(roleCookie);
            return Result.ok();
        } catch (Exception e){
            return Result.fail(e);
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public Result test(){
        String result = "yooo man, what's up?";
        return Result.ok(result);
    }

//    @RequestMapping("/insert")
//    @ResponseBody
//    public Result in (){}
//    private static final Logger logger = LoggerFactory.getLogger(UserRequests.class);

//    @Resource(name = "")
}
