package com.example.demo.controller;

import com.example.demo.model.AdMedia;
import com.example.demo.model.Video;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getResult() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping(path = "/getAllVideos")
    public ResponseEntity<List<Video>> getAllVideos() {
        return new ResponseEntity<>(videoService.getAllVideos(), HttpStatus.OK);
    }

    @PostMapping(
            path = "/saveVideo",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Video> saveTodo(@RequestParam("title") String title,
                                          @RequestParam("description") String description,
                                          @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(videoService.saveVideo(title, description, file), HttpStatus.OK);
    }

    @PostMapping(value = "{id}/media",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AdMedia> addMedia(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("timestamp") Long timestamp,
            @RequestParam("link") String link,
            @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(videoService.addMedia(id,timestamp,title ,link, file), HttpStatus.OK);
    }

//    @GetMapping(path = "/getAll")
//    public List<Hosteler> getHostelers() {
//        return hostelService.getHostelers();
//    }
//
//    @GetMapping(path = "/get/{id}")
//    public Optional<Hosteler> getHostelerById(@PathVariable("id") int id) {
//        return hostelService.getHostelerById(id);
//    }
//    @GetMapping(path = "/getHostler/{hostelerId}")
//    public Optional<Hosteler> getHostelerById(@PathVariable("hostelerId") String hostelerId ) {
//        return hostelService.getHostelerByHostelerId(hostelerId);
//    }
//    @PostMapping(path = "/add")
//    public Hosteler addHosteler(@Valid @RequestBody Hosteler hosteler) throws InvalidEntityException {
//        return hostelService.addHosteler(hosteler);
//    }
//
//    @PutMapping(path = "/update/{id}")
//    public Hosteler saveOrUpdateHosteler(@PathVariable("id") int id, @Valid @RequestBody Hosteler hosteler) throws InvalidEntityException {
//        return hostelService.saveOrUpdateHosteler(id, hosteler);
//    }
//
//    @DeleteMapping(path = "/delete/{id}")
//    public boolean deleteHosteler(@PathVariable int id) {
//        return hostelService.deleteHosteler(id);
//    }
}
