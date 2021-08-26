package com.example.demo.dao;

import com.example.demo.model.AdMedia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdMediaRepository extends CrudRepository<AdMedia, Long> {
    Optional<AdMedia> findById(Long id);

    List<AdMedia> findAllByVideoId(Long videoId);
}