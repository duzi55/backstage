package com.gzq.myUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-05-22 10:50
 */
public class UploadFile {
    public static String UploadFile(MultipartHttpServletRequest multiReq,String filePath) throws IOException {
        System.out.println("___________"+ multiReq.getFile("file"));
        MultipartFile multipartFile= multiReq.getFile("file");
        String filename=multipartFile.getOriginalFilename();
       // System.out.println("文件名字："+filename);
        File file=new File(filePath+filename);
       // System.out.println(file.getPath());
        multipartFile.transferTo(file);
        return file.getPath();
    }
}
