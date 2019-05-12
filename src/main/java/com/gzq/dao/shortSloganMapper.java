package com.gzq.dao;

import com.gzq.entity.ShortSlogan;

public interface ShortSloganMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShortSlogan record);

    int insertSelective(ShortSlogan record);

    ShortSlogan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShortSlogan record);

    int updateByPrimaryKey(ShortSlogan record);
}