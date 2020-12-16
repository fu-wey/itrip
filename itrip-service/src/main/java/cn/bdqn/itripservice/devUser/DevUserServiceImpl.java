package cn.bdqn.itripservice.devUser;

import cn.bdqn.itripbeans.pojo.DevUser;
import cn.bdqn.itripdao.devUser.DevUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;
    @Override
    public DevUser getDevUserRegister(String devCode, String devPassword) {
        return devUserMapper.getDevUserRegister(devCode,devPassword);

    }
}