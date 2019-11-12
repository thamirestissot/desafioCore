package com.thamirestissot.core.desafio.controller;

import com.google.gson.Gson;
import com.thamirestissot.core.desafio.model.Report;
import com.thamirestissot.core.desafio.dataManipulation.HandlerData;
import com.thamirestissot.core.desafio.dataManipulation.LogGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading.");
        }
        LogGenerator.FileUpload(file);
        String content = "";
        try {
            content = new String(file.getBytes(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        HandlerData handlerData = new HandlerData();
        Gson gson = new Gson();

        Report report = handlerData.processContent(content);

        return new ResponseEntity<String>(gson.toJson(report), HttpStatus.OK);
    }


}