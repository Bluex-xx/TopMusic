package com.musicall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UMusic {
    private Integer id;
    private Integer uid;
    private Integer orde;
    private Integer status;
}
