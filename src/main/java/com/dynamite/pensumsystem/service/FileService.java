package com.dynamite.pensumsystem.service;

//import org.omg.IOP.ExceptionDetailMessage;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {

    public void save(String code, MultipartFile file) throws Exception;

    public Resource load(String name) throws Exception;

    //public void save(List<MultipartFile> files) throws Exception;

    public Stream<Path> loadAll() throws Exception;
}
