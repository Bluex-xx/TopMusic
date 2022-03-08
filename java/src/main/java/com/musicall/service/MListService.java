package com.musicall.service;

import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MListService {
    List<MList> listall(MList mList);
    void insert(MList mList);
    MList findsame(MList mList);
    List<Music> findbymid(MList mList);
    Integer findmid(MList mList);
}

