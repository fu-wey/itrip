package cn.bdqn.itripdao.User;

import cn.bdqn.itripbeans.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface  UserMapper {
    /**
     * 注册
     *
     * @param user
     */
     void insert(User user) ;

    /**
     *  根据激活码查询用户
     * @param activeCode
     * @return
     */
    User selectUserByActiveCode(String activeCode);

    /**
     *  更新用户
     * @param user
     */
    void update(User user);

    /**
     *  查询用户
     * @param user
     * @return
     */
    User select(User user);
}
