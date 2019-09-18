package com.itheima.microservice.sso.service;

import com.itheima.microservice.sso.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/12/10.
 */
@Service
public class SsoService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "checkUserFallbackMethod") // 进行容错处理
    public User checkUser(String username,String password) {
        String serviceId = "itcast-microservice-user";
        User user= this.restTemplate.getForObject("http://" + serviceId + "/user/" + username,User.class);
        if(user!=null){
            String pwd = user.getPassword();
            if(pwd.equals(password)){
                return user;
            }
        }
        return null;
    }
    public User checkUserFallbackMethod(String username,String password){ // 请求失败执行的方法
        return new User(null, "获取用户信息出错!", null, null, null,null,null,null,null);
    }
}
