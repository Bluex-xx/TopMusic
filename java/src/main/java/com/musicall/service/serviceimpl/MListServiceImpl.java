package com.musicall.service.serviceimpl;

import com.musicall.dao.MListDAO;
import com.musicall.entity.MList;
import com.musicall.entity.Music;
import com.musicall.entity.UMusic;
import com.musicall.service.MListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MListServiceImpl implements MListService {
    @Autowired(required = false)
    private MListDAO mListDAO;

    @Override
    public List<MList> listall(MList mList) {
        return mListDAO.listall(mList);
    }

    @Override
    public void insert(MList mList) {
        mListDAO.insert(mList);
    }

    @Override
    public MList findsame(MList mList) {
        return mListDAO.findsame(mList);
    }

    @Override
    public List<Music> findbymid(MList mList) {
        return mListDAO.findbymid(mList);
    }

    @Override
    public Integer findmid(MList mList) {
        return mListDAO.findmid(mList);
    }

}
