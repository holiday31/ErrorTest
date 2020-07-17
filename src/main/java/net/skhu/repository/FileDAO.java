package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.UploadFile;

public interface FileDAO extends JpaRepository<UploadFile, Integer>{
}

