package com.musicall.service;

import com.musicall.entity.DLall;
import com.musicall.entity.Music;

import java.util.List;

public interface DLallService {
    List<Music> findbymid(Integer mid);
    void insert(DLall dLall);//插入到歌单中
    DLall findsame(DLall dLall);
}
