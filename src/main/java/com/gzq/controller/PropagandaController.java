package com.gzq.controller;

import com.gzq.entity.IndexPropaganda;
import com.gzq.entity.ShortSlogan;
import com.gzq.myUtils.UploadFile;
import com.gzq.service.PropagandaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-25 13:16
 */
@RestController
@RequestMapping("/propaganda")
public class PropagandaController {
    @Value("${fileUpLoadPath}")
    String file;
    @Resource
    PropagandaService propagandaService;
    @RequestMapping("indexpropaganda")
    public List<IndexPropaganda> findAll(){
        return propagandaService.findAll();
    }
    @RequestMapping("updatePropaganda")
    public boolean updatePropaganda(IndexPropaganda indexPropaganda){
//        System.out.println(indexPropaganda);
        return propagandaService.updatePropaganda(indexPropaganda);
    }
    @RequestMapping("findallbystatus/{status}")
    public List<ShortSlogan> findAllById(@PathVariable("status") Integer status){
        return  propagandaService.findAllByStatus(status);
    }
    @RequestMapping("updateshortslogan")
    public boolean updateByPrimaryKey(ShortSlogan shortSlogan){
//        System.out.println(shortSlogan);
      return   propagandaService.updateShortSloganByid(shortSlogan);
    }
    @RequestMapping("savashortslogan")
    public boolean savaShortSlogan(ShortSlogan shortSlogan){
//        System.out.println(shortSlogan);
        return propagandaService.savaShortSlogan(shortSlogan);
    }
    @RequestMapping("deleteshortslogan")
    public boolean deleteShortSlogan(@PathParam("id") Long id){
//        System.out.println("id是多少"+id);
        return propagandaService.deleteShortSlogan(id);
    }
    @RequestMapping("uploadsloganimage")
    public boolean upLoadTest(@PathParam("file")MultipartHttpServletRequest mul,@PathParam("title1")String title1,@PathParam("title2")String title2,@PathParam("href")String href,@PathParam("status")Integer status){
        return propagandaService.savaShortSlogan1(mul,title1,title2,href,status);
    }
}
