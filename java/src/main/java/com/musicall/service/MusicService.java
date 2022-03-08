package com.musicall.service;

import com.musicall.entity.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicService {
    List<Music> findrandom();
    List<Music> findall();
}
