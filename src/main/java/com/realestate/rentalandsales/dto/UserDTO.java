package com.realestate.rentalandsales.dto;

import com.realestate.rentalandsales.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data

public class UserDTO implements Serializable {

    private String id;

    private String fullName;

    private String email;

    private String photoUrl;

    private String dob;

    private String gender;

    private String phone;

    private Boolean isActive;

    private Boolean isLocked;

    private Boolean emailVerified;

    private Boolean phoneVerified;

    private String createdAt;

    private String modifiedAt;

    private LocalDateTime lastLogged;

    private Integer timesLogged;

    public UserDTO (User user) {

        this.id = user.getId();

        if (user.getFullName() != null) this.fullName = user.getFullName();

        if (user.getEmail() != null) this.email = user.getEmail();

        if (user.getPhotoUrl() != null) this.photoUrl = user.getPhotoUrl();

        if (user.getDob() != null) this.dob = user.getDob();

        if (user.getGender() != null) this.gender = user.getGender();

        if (user.getPhone() != null) this.phone = user.getPhone();

        if (user.getCreatedAt() != null) this.createdAt = String.valueOf(user.getCreatedAt());

        if (user.getModifiedAt() != null) this.modifiedAt = String.valueOf(user.getModifiedAt());

        if (user.getTimesLogged() != null) this.timesLogged = user.getTimesLogged();

        this.isActive = user.getIsActive();

        this.isLocked = user.getIsLocked();

        this.emailVerified = user.getEmailVerified();

        this.phoneVerified = user.getPhoneVerified();

    }

}
