package com.iamf.Filemanager.services;

import com.iamf.Filemanager.models.FileModel;
import com.iamf.Filemanager.responses.ResponseFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FileService {
    FileModel store(MultipartFile file) throws IOException;
    Optional<FileModel> getFile(UUID id) throws FileNotFoundException;
    List<ResponseFile> getFiles();
}
