package com.musicall.service.serviceimpl;

import com.musicall.dao.MusicDAO;
import com.musicall.entity.Music;
import com.musicall.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired(required = false)
    private MusicDAO musicDAO;

    @Override
    public List<Music> findrandom() {
        return musicDAO.findrandom();
    }

    @Override
    public List<Music> findall() {
        return musicDAO.findall();
    }
}
