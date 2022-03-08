package com.musicall.controller;

import com.musicall.entity.User;
import com.musicall.service.serviceimpl.UserServiceImpl;
import com.musicall.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        //System.out.println(user.getEmail());
        User user1=userService.findbyemail(user.getEmail());
        if(user1==null){
            System.out.println("进入注册");
            userService.register(user);
            return "注册成功";
        }else{
            return "该用户已注册，不能重复注册";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody User user){
        User user1=userService.findbyemail(user.getEmail());
        //System.out.println(user1.getPassword());
        //System.out.println(user.getPassword());
        //System.out.println(user1.getPassword().equals(user.getPassword()));
        Map<String,Object> map=new HashMap<>();
        try{
            if(user1==null){
                map.put("state",false);
                map.put("msg","该用户不存在");
            }else if(!user1.getPassword().equals(user.getPassword())){
                map.put("state",false);
                map.put("msg","密码不正确，请重新输入");
            }else{
                Map<String,String> payload=new HashMap<>();
                payload.put("email",user.getEmail());
                String token= JWTUtils.getToken(payload);
                map.put("state",true);
                map.put("msg","认证成功");
                map.put("user",user1);
                map.put("token",token);
            }
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){
        String status;
        try{
            userService.update(user);
            status="修改成功";
        }catch (Exception e){
            e.printStackTrace();
            status=e.getMessage();
        }
        return status;
    }
}
