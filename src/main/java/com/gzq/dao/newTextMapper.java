package com.gzq.dao;

import com.gzq.entity.newText;

public interface newTextMapper {
    int insert(newText record);

    int insertSelective(newText record);
}