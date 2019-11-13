package com.thamirestissot.core.desafio.controller;

import com.thamirestissot.core.desafio.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading.");
        }
        return new ResponseEntity<>(fileUploadService.newReport(file), HttpStatus.OK);
    }


}