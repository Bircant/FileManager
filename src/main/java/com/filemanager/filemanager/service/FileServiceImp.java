package com.filemanager.filemanager.service;

import com.filemanager.filemanager.model.File;
import com.filemanager.filemanager.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImp implements FileService{
    @Autowired
    private FileRepository fileRepository;
    @Override
    public File saveFile(File file) {

        return fileRepository.save(file);
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
