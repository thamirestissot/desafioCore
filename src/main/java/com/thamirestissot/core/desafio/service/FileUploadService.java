package com.thamirestissot.core.desafio.service;

import com.google.gson.Gson;
import com.thamirestissot.core.desafio.dataManipulation.HandlerData;
import com.thamirestissot.core.desafio.dataManipulation.LogGenerator;
import com.thamirestissot.core.desafio.model.Report;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    public String newReport(MultipartFile file) {
        LogGenerator.FileUpload(file);
        String content = "";
        try {
            content = new String(file.getBytes(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        HandlerData handlerData = new HandlerData();
        Report report = handlerData.processContent(content);

        Gson gson = new Gson();
        return gson.toJson(report);
    }
}
