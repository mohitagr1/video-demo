//package com.example.demo.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//import org.hibernate.annotations.NaturalId;
//import org.springframework.data.jpa.domain.AbstractPersistable;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotNull;
//import java.time.LocalDate;
//
//@Entity
//@Data
//public class Hosteler extends AbstractPersistable<Integer> {
//
//    private String hostelerId;
//    @NotNull(message = "First name cannot not be empty!")
//    private String firstName;
//    @NotNull(message = "First name cannot not be empty!")
//    private String lastName;
//    private String fatherName;
//    private String motherName;//camel case
//    @NotNull(message = "Phone Number cannot not be empty!")
//    private String phoneNumber;
//    private String alternativePhoneNumber;
//    @Email(message = "Email entered is invalid.!!")
//    private String emailId;
//    private String college;
//    private String course;
//    private int floor;
//    private int roomNumber;
//    private int age;
//    private LocalDate dateOfJoining;
//    private LocalDate dateOfBirth;
//    private String addressOfNative;//camel case
//    private String addressOfCorrespondence;//camel case
//    @JsonProperty
//    private boolean haveVehicle;
//}
