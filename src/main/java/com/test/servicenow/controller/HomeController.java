package com.test.servicenow.controller;

import com.test.servicenow.model.FileData;
import com.test.servicenow.response.EncodeApiResponseData;
import com.test.servicenow.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private ResponseData responseData;

    @Autowired
    private EncodeApiResponseData encodeApiResponseData;

    @GetMapping("/getMessage")
    public String getMessage(){

        return "hello World";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Welcome in service now";
    }

    @PostMapping("/data")
    public String getString(@RequestBody String name){

        return name.toUpperCase();
    }


    // api to consume file
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        responseData.setFileName(file.getOriginalFilename());
        responseData.setFileSize(file.getSize());
        responseData.setContentType(file.getContentType());
        ResponseEntity response = ResponseEntity.ok().body(responseData);
        return response;


    }

    @PostMapping("/encodedFile")
    public ResponseEntity<?> getEncodedFile(@RequestBody FileData fileData) throws IOException {

        String filePath = "src\\main\\resources\\files\\";
        byte[]  decodeBytes = Base64.getDecoder().decode(fileData.getEncodedFile().getBytes());
        FileOutputStream fos = new FileOutputStream(filePath + fileData.getFileName());
        fos.write(decodeBytes);
        fos.flush();
        fos.close();
        long bytes  = Files.size(Paths.get(filePath + fileData.getFileName()));
        encodeApiResponseData.setFileName(fileData.getFileName());
        encodeApiResponseData.setFilepath(filePath + fileData.getFileName());
        encodeApiResponseData.setFileSize(bytes);
        ResponseEntity response = ResponseEntity.ok().body(encodeApiResponseData);
        return response;
    }



}
