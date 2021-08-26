package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class AdMedia {
    @Id
    @GeneratedValue
    private Long id;
    private Long videoId;
    private Long timestamp;
    private String Title;
    private String link;
    private String mediaURL;

}