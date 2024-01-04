package com.iamf.Filemanager.repositories;

import com.iamf.Filemanager.models.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileRepo extends JpaRepository<FileModel, UUID> {
}
