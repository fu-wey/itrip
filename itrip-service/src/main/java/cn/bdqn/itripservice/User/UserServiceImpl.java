package cn.bdqn.itripservice.User;

import cn.bdqn.itripbeans.pojo.User;
import cn.bdqn.itripcommon.tools.MailServiceImpl;
import cn.bdqn.itripdao.User.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;



    @Override
    public void add(User user) {
        userMapper.insert(user);
        //获取激活码
        String code = user.getActiveCode();
        System.out.println("激活码:"+code);
        //主题
        String receiveMailAccount = "来自罗汉爷网站的激活邮件";
        //上面的激活码发送到用户注册邮箱
        String activateCode = "<a href=\"http://localhost:8080/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        MailServiceImpl.sendEmail (receiveMailAccount,activateCode);
    }
    @Override
    public User getUserByActiveCode(String activeCode) {
        return userMapper.selectUserByActiveCode(activeCode);
    }

    @Override
    public void modify(User user) {
        userMapper.update(user);
    }

    @Override
    public User get(User user) {
        return userMapper.select(user);
    }

}
