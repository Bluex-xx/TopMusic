package com.musicall.controller;

import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import com.musicall.service.serviceimpl.UMusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/umusic")
public class UMusicController {
    @Autowired
    private UMusicServiceImpl uMusicService;

    //返回播放列表
    @PostMapping("/playlist")
    @ResponseBody
    public List<Music> playlist(@RequestBody UMusic uMusic){
        UMusic umusic2=uMusicService.findsame2(uMusic);
        if(umusic2==null){
            uMusic.setStatus(0);
            uMusicService.update(uMusic);
            uMusicService.insert2(uMusic);
        }else {
            uMusic.setStatus(1);
            uMusic.setOrde(umusic2.getOrde());
            uMusicService.update(uMusic);
            uMusicService.update2(uMusic);
        }
        System.out.println("返回播放列表");
        return uMusicService.playlist(uMusic);
    }
}
