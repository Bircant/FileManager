package com.filemanager.filemanager.controller;

import com.filemanager.filemanager.model.File;
import com.filemanager.filemanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService  fileService;

    @PostMapping("/add")
    public String add(@RequestBody File file) {
        fileService.saveFile(file);
        return "New file is added";
    }

    @GetMapping("/getAll")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }
}
