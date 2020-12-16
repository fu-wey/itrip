package cn.bdqn.itripdao.devUser;

import cn.bdqn.itripbeans.pojo.DevUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DevUserMapper {
public DevUser getDevUserRegister(@Param("devCode") String devCode, @Param("devPassword") String devPassword);
}
