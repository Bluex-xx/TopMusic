package com.musicall.controller;

import com.musicall.entity.DLall;
import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import com.musicall.service.DLallService;
import com.musicall.service.serviceimpl.DLallServiceImpl;
import com.musicall.service.serviceimpl.MListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/dlall")
public class DLallController {
    @Autowired
    private DLallServiceImpl dLallService;

    @Autowired
    private MListServiceImpl mListService;

    //向歌单中插入歌曲
    @PostMapping("/insert")
    @ResponseBody
    public String insert(@RequestBody MList mList,@RequestParam("id") Integer id){
        String status;
        MList mList1=new MList(null,mList.getName(), mList.getUid());
        //System.out.println(mList1);
        Integer mid= mListService.findmid(mList1);
        //System.out.println(mid);
        if(mid==null){
            return "该歌单不存在";
        }else{
            DLall dLall=new DLall(mid,id);
            DLall dLall1 =dLallService.findsame(dLall);
           // System.out.println(dLall);
            if(dLall1!=null){
                status="该歌单中已存在此歌曲";
            }else {
                try{
                    dLallService.insert(dLall);
                    status="已添加到歌单中";
                }catch (Exception e){
                    e.printStackTrace();
                    status=e.getMessage();
                }
            }
        }

        return status;
    }

    //查找某个歌单中的所有歌曲
    @PostMapping("/findbymid")
    @ResponseBody
    public List<Music> findbymid(@RequestParam("mid") Integer mid){
        return dLallService.findbymid(mid);
    }
}
