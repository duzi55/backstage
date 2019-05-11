package com.gzq.dao;

import com.gzq.entity.team;

public interface teamMapper {
    int insert(team record);

    int insertSelective(team record);
}