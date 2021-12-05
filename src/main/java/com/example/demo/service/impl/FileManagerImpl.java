package com.example.demo.service.impl;

import com.example.demo.service.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;

@Service
public class FileManagerImpl implements FileManager {
    @Autowired
    private ServletContext servletContext;

    @Override
    public File save(MultipartFile file) {
        File dir = new File(servletContext.getRealPath("/files"));
        if (!dir.exists()) dir.mkdirs();
        try {
            File saveFile= new File(dir,file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public byte[] read(String name) {
        try {
            File file = new File(servletContext.getRealPath("/files/"+name));
            return Files.readAllBytes(file.toPath());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMultiple(MultipartFile[] files) {
        for (MultipartFile file: files){
            this.save(file);
        }
    }
}
