package com.atossyntel.springboot.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/******
 * NOTICE:
 * 		The init() process found in com.atossyntel.springboot.MainApp.java
 * 		can be found here, for duration of server existence storage will 
 * 		be handled from here
 ******/
@Service
public class FileSystemStorageService implements StorageService {

	// Variables for defining file path relatively based on project location
    private Path rootLocation;
    private StorageProperties props;

    //Constructor with StorageProperties parameter
    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.props = properties;
    }

	/******
	 * function store(MultipartFile file, String modules)
	 * -Saves a given 'file' to path defined by root + module directory
	 *  
	 * 1st parameter: Object containing the submitted file
	 * 2nd parameter: String modules, from front-end, defines 
	 * 		save file directory for the file
	 ******/
    @Override
    public void store(MultipartFile file, String modules) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
            	this.rootLocation = Paths.get(props.getLocation()+modules);
            	Files.createDirectories(rootLocation);
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

	/****** AS OF 18 JUL 2019, SPRINT 2, NOT IN USE
	 * function loadAll()
	 * -Handles the grabbing of ALL files in a given directory
	 * 		
	 ******/
    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

	/****** AS OF 18 JUL 2019, SPRINT 2, NOT IN USE
	 * function load(String filename)
	 * -(?) Isolates location + filename of a given String
	 *  
	 * 1st parameter: String to specify filename
	 ******/
    @Override
    public Path load(String filename,String folder) {
    	this.rootLocation = Paths.get(props.getLocation()+folder);
        return rootLocation.resolve(filename);
    }

	/****** AS OF 18 JUL 2019, SPRINT 2, NOT IN USE
	 * function loadAsResource(String filename)
	 * -(?) Potentially for checking file integrity
	 *  
	 * 1st parameter: String for a given filename
	 ******/
    @Override
    public Resource loadAsResource(String filename,String folder) {
        try {
            Path file = load(filename,folder);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

	/****** AS OF 18 JUL 2019, SPRINT 2, NOT IN USE
	 * function deleteAll()
	 * -Deletes ALL files present in the rootLocation folder
	 * -Note: This doesn't seek any file other than the root
	 ******/
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

	/******
	 * function init()
	 * -Initializer for the storage container, creates root directory
	 * 		(Present in the main.java)
	 ******/
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
    
    @Override
    public Path loadExcel(String filename,String folder) {
    	this.rootLocation = Paths.get(folder);
    	System.out.println(rootLocation.resolve(filename));
        return rootLocation.resolve(filename);
    }
    
    @Override
    public Resource loadExcelAsResource(String filename,String folder) {
        try {
            Path file = loadExcel(filename,folder);
            Resource resource = new UrlResource(file.toUri());
            System.out.println(resource.exists());
            System.out.println(resource.isReadable());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }
}
