package com.gzq.dao;

import com.gzq.entity.IndexIamge;

public interface IndexIamgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexIamge record);

    int insertSelective(IndexIamge record);

    IndexIamge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexIamge record);

    int updateByPrimaryKey(IndexIamge record);
}