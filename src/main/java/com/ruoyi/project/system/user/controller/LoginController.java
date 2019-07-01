package com.ruoyi.project.system.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;

import java.util.UUID;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Controller
public class LoginController extends BaseController
{

    @GetMapping("/"+GETWAY+"/logout")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("退出成功");
        return null;
    }

    @CrossOrigin
    @PostMapping("/"+GETWAY+"/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password)
    {
        System.out.println("user"+username+","+password);
        Boolean rememberMe =false;
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
            {
                subject.login(token);
                return AjaxResult.success("登陆成功",null,0);
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "error/unauth";
    }
}
