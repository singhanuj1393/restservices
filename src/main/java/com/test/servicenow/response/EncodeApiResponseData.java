package com.test.servicenow.response;

import org.springframework.stereotype.Component;

@Component
public class EncodeApiResponseData {

    private String fileName;
    private String filepath;
    private Long fileSize;

    public EncodeApiResponseData() {
    }

    public EncodeApiResponseData(String fileName, String filepath, Long fileSize) {
        this.fileName = fileName;
        this.filepath = filepath;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
