package com.gzq.dao;

import com.gzq.entity.Team;

public interface TeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
}