package com.test.servicenow.controller;

import com.test.servicenow.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private ResponseData responseData;

    @GetMapping("/getMessage")
    public String getMessage(){

        return "hello World";
    }

    // api to consume file
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        responseData.setFileName(file.getOriginalFilename());
        responseData.setFileSize(file.getSize());
        responseData.setContentType(file.getContentType());
        ResponseEntity response = ResponseEntity.ok().body(responseData);
        return response;
    }


}
