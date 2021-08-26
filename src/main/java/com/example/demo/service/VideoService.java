package com.example.demo.service;

import com.example.demo.model.AdMedia;
import com.example.demo.model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface VideoService {
    Video saveVideo(String title, String description, MultipartFile file);

    List<Video> getAllVideos();

    AdMedia addMedia(Long id, Long timestamp, String title, String link, MultipartFile file);

    List<AdMedia> getAllMedia(Long id);
}
