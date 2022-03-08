package com.musicall.dao;

import com.musicall.entity.DLall;
import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DLallDAO {
    List<Music> findbymid(Integer mid);
    void insert(DLall dLall);//插入到歌单中
    DLall findsame(DLall dLall);
}
