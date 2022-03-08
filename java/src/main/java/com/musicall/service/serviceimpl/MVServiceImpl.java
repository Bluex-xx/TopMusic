package com.musicall.service.serviceimpl;

import com.musicall.dao.MVDAO;
import com.musicall.entity.MV;
import com.musicall.entity.Music;
import com.musicall.service.MVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MVServiceImpl implements MVService {
    @Autowired
    private MVDAO mvdao;
    @Override
    public List<MV> findall() {
        return mvdao.findall();
    }
}
