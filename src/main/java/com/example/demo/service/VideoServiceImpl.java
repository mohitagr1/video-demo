package com.example.demo.service;

import com.amazonaws.services.s3.model.GetObjectRequest;
import com.example.demo.dao.AdMediaRepository;
import com.example.demo.dao.VideoRepository;
import com.example.demo.model.AdMedia;
import com.example.demo.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private AdMediaRepository adMediaRepository;

    @Autowired
    private AWSS3Service awss3Service;

    @Override
    public Video saveVideo(String title, String description, MultipartFile file) {

        String location = "videos/"+String.valueOf(System.currentTimeMillis())+"_";
        String url = awss3Service.uploadFile(file, location);

        Video.VideoBuilder videoBuilder= Video.builder();
        Video video = videoBuilder
                .description(description)
                .title(title)
                .videoURL(url)
                .build();
        videoRepository.save(video);
        return videoRepository.findById(video.getId()).orElse(null);
    }

    @Override
    public List<Video> getAllVideos() {
        List<Video> videoList = new ArrayList<>();
        videoRepository.findAll().forEach(videoList::add);
        return videoList;
    }

    @Override
    public AdMedia addMedia(Long id, Long timestamp, String title, String link, MultipartFile file) {

        String location = "media/"+String.valueOf(System.currentTimeMillis())+"_";
        String url = awss3Service.uploadFile(file, location);

        AdMedia.AdMediaBuilder adMediaBuilder= AdMedia.builder();
        AdMedia adMedia = adMediaBuilder
                .videoId(id)
                .Title(title)
                .timestamp(timestamp)
                .link(link)
                .mediaURL(url)
                .build();
        adMediaRepository.save(adMedia);
        return adMediaRepository.findById(adMedia.getId()).orElse(null);
    }

    @Override
    public List<AdMedia> getAllMedia(Long videoId) {
        return adMediaRepository.findAllByVideoId(videoId);
    }
//    @Autowired
//    private HostelRepo hostelRepo;
//    @Autowired
//    private LoginController loginController;
//
//    private List<SubError> subErrorList;
//
//    public List<Hosteler> getHostelers() {
//        return hostelRepo.findAll();
//    }
//
//    public Optional<Hosteler> getHostelerById(int id) {
//        Optional<Hosteler> hosteler = hostelRepo.findById(id);
//        if (!hosteler.isPresent()) {
//            throw new RecordNotFoundException("Invalid Hosteler id : " + id);
//        }
//        return hosteler;
//    }
//
//    public Hosteler addHosteler(Hosteler hosteler) throws InvalidEntityException {
//        subErrorList = null;
//        ValidationService.validate(hosteler);
//        System.out.println("validate OK");
//        CheckForDuplicates(hosteler);
//
//        hostelRepo.save(hosteler);
//        System.out.println("Check Passed --> "+hosteler.getHostelerId());
//        String hostelerId = String.valueOf((hosteler.getId()));
//        System.out.println(hostelerId);
//        int length = hostelerId.length();
//        switch (length){
//            case 1: hostelerId = "00"+hostelerId;
//                break;
//            case 2: hostelerId = "0"+hostelerId;
//                break;
//            default:
//        }
//        hosteler.setHostelerId("1"+"MH"+hosteler.getDateOfJoining().getYear()+hostelerId);
//        hostelRepo.save(hosteler);
//        Login login = new Login(hosteler.getId(),hosteler.getHostelerId(),hosteler.getFirstName());
//        System.out.println("login login --->"+login.getHostelerId()+" "+login.getPassword());
//        loginController.addHostelerLogin(login);
//        System.out.println("Check Passed --> "+hosteler.getHostelerId());
//        return hosteler;
//    }
//
//    private void CheckForDuplicates(Hosteler hosteler) throws InvalidEntityException {
//        if (hostelRepo.existsHostelerByEmailId(hosteler.getEmailId())) {
//            addSubError(new ErrorDetails("Email Id already exists !!", "Hosteler", "Email ID", hosteler.getEmailId()));
//        }
//        if (hostelRepo.existsHostelerByPhoneNumber(hosteler.getPhoneNumber())) {
//            addSubError(new ErrorDetails("Phone Number already exists !!", "Hosteler", "Phone Number", hosteler.getPhoneNumber()));
//        }
//        if (subErrorList!=null && !subErrorList.isEmpty()) {
//            throw new InvalidEntityException("DUPLICATION ERROR !!", subErrorList);
//        }
//    }
//
//    private void addSubError(SubError subError) {
//        if (subErrorList == null) {
//            subErrorList = new ArrayList<>();
//        }
//        subErrorList.add(subError);
//    }
//
//    public Hosteler saveOrUpdateHosteler(int id, Hosteler hosteler) throws InvalidEntityException {
//        if (!hostelRepo.existsById(id)) {
//            throw new RecordNotFoundException("Invalid Hosteler id : " + id);
//        }
//        ValidationService.validate(hosteler);
////        hosteler.setId(id);
//        return hostelRepo.save(hosteler);
//    }
//
//    public boolean deleteHosteler(int id) {
//        if (!hostelRepo.existsById(id)) {
//            throw new RecordNotFoundException("Invalid Hostler id :" + id);
//        }
//        hostelRepo.deleteById(id);
//        return true;
//    }
//
//    public Optional<Hosteler> getHostelerByHostelerId(String hostelerId) {
//        Optional<Hosteler> hosteler = hostelRepo.findByHostelerId(hostelerId);
//        if (!hosteler.isPresent()) {
//            throw new RecordNotFoundException("Invalid Hosteler id : " + hostelerId);
//        }
//        return hosteler;
//    }
}
