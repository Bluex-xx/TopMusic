package com.musicall.dao;

import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MListDAO {
    List<MList> listall(MList mList);
    void insert(MList mList);
    MList findsame(MList mList);
    List<Music> findbymid(MList mList);
    Integer findmid(MList mList);
}
