package com.test.servicenow.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseData {

    private String fileName;
    private long fileSize;
    private String contentType;

    public ResponseData(){

    }
    public ResponseData(String fileName, long fileSize, String contentType) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
