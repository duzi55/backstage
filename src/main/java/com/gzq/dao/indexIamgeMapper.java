package com.gzq.dao;

import com.gzq.entity.IndexIamge;

import java.util.List;

public interface IndexIamgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexIamge record);

    int insertSelective(IndexIamge record);

    IndexIamge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexIamge record);

    int updateByPrimaryKey(IndexIamge record);

    List<IndexIamge> findAll();

    int deleteIndexImgById(Integer id);

    int saveImage(IndexIamge indexIamge);
}