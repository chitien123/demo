package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileManager {
    public File save(MultipartFile file);

    public byte[] read (String name);

    public void saveMultiple(MultipartFile[] files);
}
