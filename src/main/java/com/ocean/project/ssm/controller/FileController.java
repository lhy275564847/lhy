package com.ocean.project.ssm.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件处理控制层
 *
 * @author haiyang.li on 2017/10/19
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/preview")
    public void preview(HttpServletResponse response) {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            File file = new File("D:\\我的图片\\psb.jpg");
            inputStream = new BufferedInputStream(new FileInputStream(file));
            outputStream = new BufferedOutputStream(response.getOutputStream());
            int len;
            byte[] buffer = new byte[1024*1024];
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @RequestMapping("/upload")
    public ResponseEntity upload(MultipartFile uploadFile) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try{
            inputStream = new BufferedInputStream(uploadFile.getInputStream());
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\1.jpg")));
            int len;
            byte[] buffer = new byte[1024*1024];
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,len);
            }
            outputStream.flush();
            resultMap.put("success",true);
            resultMap.put("message","上传成功");
        }catch (Exception e){
            resultMap.put("success",false);
            resultMap.put("message","服务器异常,请稍后再试!");
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(resultMap, headers, HttpStatus.OK);
    }
}