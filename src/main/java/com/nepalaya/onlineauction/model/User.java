package com.nepalaya.onlineauction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nepalaya.onlineauction.model.enums.GenderType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class User {
    @Column(length = 150, name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(length = 150, name = "MIDDLENAME")
    private String middleName;

    @Column(length = 150, name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Column(length = 150, name = "ADDRESS", nullable = false)
    private String address;

    @JsonIgnore
    @Column(length = 20, name = "CONTACT_NO", nullable = false)
    private String contactNo;

    @Column(length = 20, name = "User_Type", nullable = false)
    private String usertype;

    @Column(name = "WALLET", nullable = false)
    private Double wallet;

    @JsonIgnore
    @Column(length = 150, name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @JsonIgnore
    @Column(length = 150, name = "PASSWORD", nullable = false)
    private String password;





}
