package com.filemanager.filemanager.controller;

import com.filemanager.filemanager.model.File;
import com.filemanager.filemanager.repository.FileRepository;
import com.filemanager.filemanager.service.FileService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
public class FileController {
    @Autowired
    private FileService  fileService;
    @PostMapping("/add")
    public String add(@RequestBody File file){
        fileService.saveFile(file);
        return "New file is added";
    }

    @GetMapping("/getAll")
    public List<File> getAllFilesData() {
        System.out.println("heyyyyyyyyyyyyyy1");
        return fileService.getAllFiles();
    }

    @PostMapping("/upload")
    public String uploadNewFile(@NotNull @RequestParam("file") MultipartFile multipartFile) throws IOException {
        String location = ServletUriComponentsBuilder.fromCurrentRequest().build().getPath();
        File fileEntity = new File(multipartFile.getOriginalFilename(),
                location,
                String.valueOf(multipartFile.getSize()),

                multipartFile.getBytes());

        fileService.saveFile(fileEntity);


       //  return ResponseEntity.created(location).build();
        return "File uploaded";
    }
}
