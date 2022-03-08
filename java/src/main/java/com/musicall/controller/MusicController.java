package com.musicall.controller;

import com.musicall.entity.Music;
import com.musicall.service.serviceimpl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;

    //歌曲分类功能
    @ResponseBody
    @PostMapping("/findall")
    public List<Music> findall(){
        return musicService.findall();
    }
}
