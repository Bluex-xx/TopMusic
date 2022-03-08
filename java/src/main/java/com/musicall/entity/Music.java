package com.musicall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private String name;
    private String artist;
    private String url;
    private String style;
    private Integer id;
    private String cover;
    private List<Music> musicList;
}