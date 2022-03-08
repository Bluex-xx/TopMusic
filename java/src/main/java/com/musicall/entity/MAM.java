package com.musicall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MAM {
    private List<Music> musicList;
    private List<MV> mvList;
}
