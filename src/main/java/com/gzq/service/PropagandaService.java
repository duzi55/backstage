package com.gzq.service;

import com.gzq.entity.IndexPropaganda;
import com.gzq.entity.ShortSlogan;

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
    boolean deleteShortSlogan(Long id);
}
