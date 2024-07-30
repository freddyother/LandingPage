package com.realestate.rentalandsales.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Transactional
@Table(name= "main_user", uniqueConstraints = {
        @UniqueConstraint(name= "user_email_unique", columnNames = "email")
},
        indexes = @Index(name = "i_user_email", columnList = "email"))

public class User extends JpaEntity implements Serializable {

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Column(name = "full_Name", length = 75)
    private String fullName;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column
    private String dob;

    @Column
    private String gender;

    private String phone;

    @Column(name="active")
    private Boolean isActive;

    @Column(name="locked")
    private Boolean isLocked;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "phone_verified")
    private Boolean phoneVerified;

    @Column(name="last_logged")
    private LocalDateTime lastLogged;

    @Column(name="times_logged")
    private Integer timesLogged;

}
