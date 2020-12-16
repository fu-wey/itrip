package cn.bdqn.itripcontroller.devUser;

import cn.bdqn.itripbeans.pojo.User;
import cn.bdqn.itripcommon.tools.IDUtils;
import cn.bdqn.itripcommon.tools.MailServiceImpl;
import cn.bdqn.itripservice.User.UserService;
import com.sun.xml.internal.ws.util.JAXWSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
@Resource
    private UserService userService;
@Resource
   private MailServiceImpl mailService;


    @RequestMapping(value = "/mial")
    public String mial(String receiveMailAccount,String activateCode){
        mailService.sendEmail("11111","5555");
        return "dd";
    }
    /**
     *  注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(User user){
        user.setActiveStatus(0);
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        userService.add(user);

        return "success";
    }

    /**
     *  校验激活码
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        User user = userService.getUserByActiveCode(code);
        //如果用户不等于null，把用户状态修改status=1
        if (user !=null){
            user.setActiveStatus(1);
            //把code验证码清空，已经不需要了
            user.setActiveCode("");
            userService.modify(user);

            return "activeSuccess";
        }

        return "login";
    }

    /**
     * 登录
     * @return login
     */
    @RequestMapping(value = "/loginPage")
    public String login(){
        return "login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login")
    public String login(User user, Model model){
        User u = userService.get(user);
        if (u !=null){
            return "welcome";
        }
        return "error";
    }
}
