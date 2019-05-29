package com.gzq.dao;

import com.gzq.entity.IndexPropaganda;

import java.util.List;

public interface IndexPropagandaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexPropaganda record);

    int insertSelective(IndexPropaganda record);

    IndexPropaganda selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexPropaganda record);

    int updatePropaganda(IndexPropaganda record);
    List<IndexPropaganda> findAll();
}