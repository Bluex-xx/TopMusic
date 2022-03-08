package com.musicall.controller;

import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import com.musicall.service.serviceimpl.MListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.NotLinkException;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/mlist")
public class MListController {

    @Autowired(required = false)
    private MListServiceImpl mListServiceImpl;

    //获得用户的所有歌单名字及对应的id
    @PostMapping("/listall")
    @ResponseBody
    public List<MList> listall(@RequestBody MList mList){
        System.out.println(mList);
        return mListServiceImpl.listall(mList);
    }

    //创建歌单
    @PostMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody MList mList){
        String status;
        MList mList1=mListServiceImpl.findsame(mList);
        if(mList1!=null){
            status="歌单已存在，不能重复添加";
        }else {
            try{
                mListServiceImpl.insert(mList);
                status="插入成功";
            }catch (Exception e){
                e.printStackTrace();
                status=e.getMessage();
            }
        }
        return status;
    }
}
