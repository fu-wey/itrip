package cn.bdqn.itripcontroller.devUser;

import cn.bdqn.itripbeans.pojo.DevUser;
import cn.bdqn.itripservice.devUser.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Dev")
public class DevUserController {
    @Resource
    private DevUserService devUserService;

    @RequestMapping(value="/login")
    public String login(){
        return "devlogin";
    }
    @RequestMapping(value="/dologin",method= RequestMethod.POST)
    public String doLogin(@RequestParam String devCode, @RequestParam String devPassword, HttpServletRequest request, HttpSession session){
        //调用service方法，进行用户匹配
        DevUser user = null;
        try {
            user = devUserService.getDevUserRegister(devCode,devPassword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(null != user){//登录成功
            //放入session
            session.setAttribute("user", user);
            //页面跳转（main.jsp）
            return "redirect:/dev/flatform/main";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "devlogin";
        }
    }
}
