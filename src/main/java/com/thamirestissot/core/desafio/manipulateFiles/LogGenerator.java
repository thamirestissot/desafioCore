package com.thamirestissot.core.desafio.manipulateFiles;

import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

public class LogGenerator {
    private static final Logger logger = Logger.getLogger(LogGenerator.class.getName());

    public static void FileUpload(MultipartFile file) {
        logger.info("File Uploaded - originalName: '" + file.getOriginalFilename() +"' - " +
                "name: '" + file.getName() +"' - " +
                "size: " + file.getSize() + "bytes");
    }
}
