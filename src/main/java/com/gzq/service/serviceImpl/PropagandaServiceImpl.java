package com.gzq.service.serviceImpl;

import com.gzq.dao.IndexPropagandaMapper;
import com.gzq.dao.ShortSloganMapper;
import com.gzq.entity.IndexPropaganda;
import com.gzq.entity.ShortSlogan;
import com.gzq.service.PropagandaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-25 12:48
 */
@Service
public class PropagandaServiceImpl implements PropagandaService {
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
    public boolean deleteShortSlogan(Long id) {
        boolean flag =false;
        int i=shortSloganMapper.deleteByPrimaryKey(id);
        if(i>0){
            flag=true;
        }
        return flag;
    }
}
