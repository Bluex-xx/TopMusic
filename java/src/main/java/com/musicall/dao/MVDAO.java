package com.musicall.dao;

import com.musicall.entity.MV;
import com.musicall.entity.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MVDAO {
    List<MV> findall();
}
