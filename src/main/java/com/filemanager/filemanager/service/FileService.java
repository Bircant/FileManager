package com.filemanager.filemanager.service;

import com.filemanager.filemanager.model.File;

import java.util.List;

public interface FileService {
    public File saveFile(File file);
    public List<File> getAllFiles();

}
