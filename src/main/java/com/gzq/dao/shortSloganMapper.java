package com.gzq.dao;

import com.gzq.entity.ShortSlogan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShortSloganMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShortSlogan record);

    int insertSelective(ShortSlogan record);

    ShortSlogan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShortSlogan record);

    int updateByPrimaryKey(ShortSlogan record);

    List<ShortSlogan> findAllByStatus(Integer status);

    int savaShortSlogan(ShortSlogan shortSlogan);
    int savaShortSlogan1(ShortSlogan shortSlogan);
 }