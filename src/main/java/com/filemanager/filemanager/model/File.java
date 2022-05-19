package com.filemanager.filemanager.model;

import javax.persistence.*;
import java.net.URI;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;                 // Id for files
    private String name;            // Name of the files
    String  path;            // Path of the file
    private String size;            // Size of the file
    private String extension;

    @Lob
    private byte[] data;

    public File() {
    }

    public File(String name, String path, String size, byte[] data) {
        this.name = name;
        this.path = path;
        this.data = data;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
