package com.gzq.dao;

import com.gzq.entity.shortSlogan;

public interface shortSloganMapper {
    int insert(shortSlogan record);

    int insertSelective(shortSlogan record);
}