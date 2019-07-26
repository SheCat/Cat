package com.czxy.score.controller;

import com.czxy.score.domain.User;
import com.czxy.score.service.LogService;
import com.czxy.score.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @PostMapping("/add")
    public ResponseEntity<String> add(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //进行添加 log对象 (add)
        logService.add(user);
        System.out.println("... 执行add方法");
        return new ResponseEntity<>("add..OK",HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //进行添加 log对象 (update)
        logService.update(user);
        System.out.println("... 执行update方法");
        return new ResponseEntity<>("update..OK",HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //进行添加 log对象 (del)
        logService.del(user);
        System.out.println("... 执行del方法");
        return new ResponseEntity<>("del..OK",HttpStatus.OK);
    }

    /**
     * 登录方法
     */
    @GetMapping("/login")
    public ResponseEntity<Void> login(User user, HttpServletRequest request){
        List<User> users = userService.findAll();
        User uu = null;
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword())){
                //登陆成功 把user 添加到uu
                uu=u;
            }
        }
        //判断uu 是否为空 --> 登录是否成功
        if (uu!=null){
            //成功
            //把uu对象信息存入session中
            request.getSession().setAttribute("user",uu);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            //失败
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
