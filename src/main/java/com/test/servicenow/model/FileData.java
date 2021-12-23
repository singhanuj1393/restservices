package com.test.servicenow.model;


public class FileData {

    private String encodedFile;
    private String fileName;

    public FileData(){

    }
    public FileData(String encodedFile, String fileName) {
        this.encodedFile = encodedFile;
        this.fileName = fileName;
    }

    public String getEncodedFile() {
        return encodedFile;
    }

    public void setEncodedFile(String encodedFile) {
        this.encodedFile = encodedFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
