package cn.bdqn.itripservice.devUser;

import cn.bdqn.itripbeans.pojo.DevUser;

public interface DevUserService {
    public DevUser getDevUserRegister(String devCode, String devPassword);
}
