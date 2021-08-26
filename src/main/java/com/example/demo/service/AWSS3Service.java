package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {
    // @Async annotation ensures that the method is executed in a different background thread
    // but not consume the main thread.

    // @Async annotation ensures that the method is executed in a different background thread
    // but not consume the main thread.
    String uploadFile(MultipartFile multipartFile, String location);
}