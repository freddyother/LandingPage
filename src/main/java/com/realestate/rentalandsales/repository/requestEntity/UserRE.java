package com.realestate.rentalandsales.repository.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRE {

    private String email;

    private String password;

    private String fullName;

    private String dob;

    private String gender;

    private String phone;
}
