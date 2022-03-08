package com.musicall.dao;

import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UMusicDAO {
    void insert(UMusic uMusic);//插入到歌单中
    UMusic findsame(UMusic uMusic);//查询是否在歌单中
    List<Music> playlist(UMusic uMusic);
    UMusic findsame2(UMusic uMusic);//查询是否在播放列表中
    void update(UMusic uMusic);//插入到播放列表中
    void insert2(UMusic uMusic);//首个插入
    void update2(UMusic uMusic);//更新为1
}
