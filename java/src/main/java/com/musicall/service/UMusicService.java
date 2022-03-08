package com.musicall.service;

import com.musicall.entity.Music;
import com.musicall.entity.UMusic;

import java.util.List;

public interface UMusicService {
    void insert(UMusic uMusic);
    UMusic findsame(UMusic uMusic);
    UMusic findsame2(UMusic uMusic);
    void update(UMusic uMusic);
    void insert2(UMusic uMusic);
    List<Music> playlist(UMusic uMusic);
    void update2(UMusic uMusic);
}
