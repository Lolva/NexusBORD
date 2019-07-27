package com.atossyntel.springboot.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file, String modules);

    Stream<Path> loadAll();

    Path load(String filename, String folder);

    Resource loadAsResource(String filename,String folder);

    void deleteAll();

	Path loadExcel(String filename, String folder);

	Resource loadExcelAsResource(String filename, String folder);

}
