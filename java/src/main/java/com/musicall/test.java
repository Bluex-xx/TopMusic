package com.musicall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/test")
public class test {
    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }
}
