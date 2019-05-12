package com.gzq.dao;

import com.gzq.entity.NewText;

public interface NewTextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewText record);

    int insertSelective(NewText record);

    NewText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewText record);

    int updateByPrimaryKeyWithBLOBs(NewText record);

    int updateByPrimaryKey(NewText record);
}