package com.musicall.service.serviceimpl;

import com.musicall.dao.DLallDAO;
import com.musicall.entity.DLall;
import com.musicall.entity.Music;
import com.musicall.service.DLallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DLallServiceImpl implements DLallService {
    @Autowired
    private DLallDAO dLallDAO;

    @Override
    public List<Music> findbymid(Integer mid) {
        return dLallDAO.findbymid(mid);
    }

    @Override
    public void insert(DLall dLall) {
        dLallDAO.insert(dLall);
    }

    @Override
    public DLall findsame(DLall dLall) {
        return dLallDAO.findsame(dLall);
    }
}
