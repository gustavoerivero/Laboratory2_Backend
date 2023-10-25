package com.dynamite.pensumsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId", unique = true, nullable = false)
    private int fileId;

    @JsonProperty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @JsonProperty
    @Column(name = "url")
    private String url;


    public File(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public File() {
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
