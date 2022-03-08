package com.musicall.service.serviceimpl;

import com.musicall.dao.UMusicDAO;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import com.musicall.service.UMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UMusicServiceImpl implements UMusicService {
    @Autowired
    private UMusicDAO uMusicDAO;

    @Override
    public void insert(UMusic uMusic) {
        uMusicDAO.insert(uMusic);
    }

    @Override
    public UMusic findsame(UMusic uMusic) {
        return uMusicDAO.findsame(uMusic);
    }

    @Override
    public UMusic findsame2(UMusic uMusic) {
        return uMusicDAO.findsame2(uMusic);
    }

    @Override
    public void update(UMusic uMusic) {
        uMusicDAO.update(uMusic);
    }

    @Override
    public void insert2(UMusic uMusic) {
        uMusicDAO.insert2(uMusic);
    }

    @Override
    public List<Music> playlist(UMusic uMusic) {
        return uMusicDAO.playlist(uMusic);
    }

    @Override
    public void update2(UMusic uMusic) {
        uMusicDAO.update2(uMusic);
    }
}
