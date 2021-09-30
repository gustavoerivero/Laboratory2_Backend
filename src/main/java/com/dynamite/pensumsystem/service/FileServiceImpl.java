package com.dynamite.pensumsystem.service;

import com.dynamite.pensumsystem.model.File;
import com.dynamite.pensumsystem.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    private final Path rootFolder = Paths.get("uploads");

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void save(String code, MultipartFile file) throws Exception {
        //Aca podemos colocar/cambiar el nombre que tendra el archivo al ser guardado
        Files.copy(file.getInputStream(), this.rootFolder.resolve(code + ".pdf"));
        fileRepository.save(new File(code+".pdf", "http://localhost:8080/file/load/"+code+".pdf"));
    }

    @Override
    public Resource load(String name) throws Exception {
        Path file = rootFolder.resolve(name);
        Resource resource = new UrlResource(file.toUri());
        return resource;
    }

    /*@Override
    public void save(List<MultipartFile> files) throws Exception {
        for (MultipartFile file : files){
            this.save(file);
        }
    }*/

    @Override
    public Stream<Path> loadAll() throws Exception {
        return Files.walk(rootFolder, 1).filter(path -> !path.equals(rootFolder)).map(rootFolder::relativize);
    }
}
