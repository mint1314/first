package com.itheima.microservice.sso.controll;

import com.itheima.microservice.sso.pojo.OptResult;
import com.itheima.microservice.sso.pojo.User;
import com.itheima.microservice.sso.service.SsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/6.
 */
@RestController
@RefreshScope
public class SsoController {

    @Autowired
    private SsoService ssoService;

    /**
     * 登录接口
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @GetMapping(value = "login/{username}/{password}")
    public OptResult queryItemById(@PathVariable("username") String username,@PathVariable("password") String password) {
        User user = ssoService.checkUser(username,password);
        if(user == null || user.getId() == null){
            return new OptResult(1,"登录失败",user);
        }
        return new OptResult(1,"登录成功",user);
    }
}
