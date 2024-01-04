package com.iamf.Filemanager.controllers;

import com.iamf.Filemanager.models.FileModel;
import com.iamf.Filemanager.responses.ResponseFile;
import com.iamf.Filemanager.responses.ResponseMessage;
import com.iamf.Filemanager.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/fileManager")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Entro");
        if (file.getContentType() == null){
            throw new IOException();
        }
        fileService.store(file);
        return ResponseEntity.status(HttpStatus.OK).body(new  ResponseMessage("File has been upload correctly."));
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) throws FileNotFoundException {
        FileModel fileModel = fileService.getFile(id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, fileModel.getType())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getName() + "\"")
                .body(fileModel.getData());
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getFileList(){
        List<ResponseFile> files = fileService.getFiles();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

}
