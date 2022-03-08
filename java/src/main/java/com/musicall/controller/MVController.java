package com.musicall.controller;

import com.musicall.entity.MAM;
import com.musicall.entity.MV;
import com.musicall.entity.Music;
import com.musicall.service.serviceimpl.MVServiceImpl;
import com.musicall.service.serviceimpl.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/mv")
public class MVController {
    @Autowired
    private MVServiceImpl mvService;

    @Autowired
    private MusicServiceImpl musicService;

    @PostMapping("/findall")
    @ResponseBody
    public MAM findall(){
        List<Music> musicList= musicService.findrandom();
        List<MV> mvList=mvService.findall();
        MAM mam=new MAM(musicList,mvList);
        System.out.println("首页");
        return mam;
    }
}
