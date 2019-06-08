package com.gzq.service.serviceImpl;

import com.gzq.dao.IndexPropagandaMapper;
import com.gzq.dao.ShortSloganMapper;
import com.gzq.entity.IndexPropaganda;
import com.gzq.entity.ShortSlogan;
import com.gzq.myUtils.UploadFile;
import com.gzq.service.PropagandaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-25 12:48
 */
@Service
public class PropagandaServiceImpl implements PropagandaService {
    @Value("${fileUpLoadPath}")
    String filePath;
    @Resource
    IndexPropagandaMapper indexPropagandaMapper;
    @Resource
    ShortSloganMapper shortSloganMapper;
    @Override
    public List<IndexPropaganda> findAll() {
        return indexPropagandaMapper.findAll();
    }

    @Override
    public boolean updatePropaganda(IndexPropaganda indexPropaganda) {
        boolean flag= false;
        int i=indexPropagandaMapper.updatePropaganda(indexPropaganda);
        if(i>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public List<ShortSlogan> findAllByStatus(Integer status) {
        return shortSloganMapper.findAllByStatus(status);
    }

    @Override
    public boolean updateShortSloganByid(ShortSlogan shortSlogan) {
        boolean flag =false;
        int i=shortSloganMapper.updateByPrimaryKey(shortSlogan);
        if(i>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean savaShortSlogan(ShortSlogan shortSlogan) {
        boolean flag =false;
        int i=shortSloganMapper.savaShortSlogan(shortSlogan);
        if(i>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean savaShortSlogan1(MultipartHttpServletRequest mul, String title1, String title2, String href, Integer status) {
        boolean flag=false;
        ShortSlogan shortSlogan=new ShortSlogan();
        String src="";
        try {
         src=UploadFile.UploadFile(mul,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        shortSlogan.setFirstTitle(title1);
        shortSlogan.setSecondTitle(title2);
        shortSlogan.setHref(href);
        shortSlogan.setSrc(src);
        shortSlogan.setStatus(status);
        int i=shortSloganMapper.savaShortSlogan1(shortSlogan);
        if(i>0){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean deleteShortSlogan(Long id) {
        boolean flag =false;
        String  src= shortSloganMapper.selectByPrimaryKey(id).getSrc();
        boolean rs= UploadFile.deleteImage(src);

        int i=shortSloganMapper.deleteByPrimaryKey(id);
        if(i>0&&rs){
            flag=true;
        }
        return flag;
    }

}
