package com.gzq.service;

import com.gzq.entity.IndexPropaganda;
import com.gzq.entity.ShortSlogan;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-25 12:45
 */
public interface PropagandaService {
    List<IndexPropaganda> findAll();
    boolean updatePropaganda(IndexPropaganda indexPropaganda);
    List<ShortSlogan> findAllByStatus(Integer status);
    boolean updateShortSloganByid(ShortSlogan shortSlogan);
    boolean savaShortSlogan(ShortSlogan shortSlogan);
    boolean savaShortSlogan1( MultipartHttpServletRequest mul,String title1,String title2,String href,Integer status);
    boolean deleteShortSlogan(Long id);
}
