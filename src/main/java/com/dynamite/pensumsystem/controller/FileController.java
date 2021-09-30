package com.dynamite.pensumsystem.controller;

import com.dynamite.pensumsystem.model.File;
import com.dynamite.pensumsystem.model.Response;
import com.dynamite.pensumsystem.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/{code}")
    public ResponseEntity<Response> uploadFile(@PathVariable String code, @RequestParam("file") MultipartFile files) throws Exception{
            fileService.save(code, files);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("Los archivos fueron cargados correctamente"));
    }

    @GetMapping("/load/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws Exception{
        Resource resource = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping("/load/allfiles")
    public ResponseEntity<List<File>> getAllFiles() throws Exception{
        List<File> files = fileService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
            return new File(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
