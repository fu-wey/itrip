package cn.bdqn.itripcontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = ("cn.bdqn.*"))
@MapperScan(basePackages = "cn.bdqn.itripdao.User")
public class ItripControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItripControllerApplication.class, args);
    }

}
