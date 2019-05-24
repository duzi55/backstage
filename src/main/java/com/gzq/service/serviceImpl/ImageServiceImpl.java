package com.gzq.service.serviceImpl;

import com.gzq.dao.IndexIamgeMapper;
import com.gzq.entity.IndexIamge;
import com.gzq.myUtils.UploadFile;
import com.gzq.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-22 08:13
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Value("${fileUpLoadPath}")
    String filePath;
    @Resource
    IndexIamgeMapper indexIamgeMapper;
    @Override
    public List<IndexIamge> findIndexImage() {
        return indexIamgeMapper.findAll();
    }
    public boolean deleteIndexImgById(Integer id){
        boolean flag = false;
        int i= indexIamgeMapper.deleteIndexImgById(id);
        if(i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean saveIndexImage(HttpServletRequest req, MultipartHttpServletRequest multiReq) {
        IndexIamge indexIamge=new IndexIamge();
        boolean flag =false;
        try {
            String rs=UploadFile.UploadFile(req,multiReq,filePath);
            indexIamge.setSrc(rs);
           int i= indexIamgeMapper.saveImage(indexIamge);
            if(i>0){
                flag=true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结果是："+flag);
        return flag;
    }
}
