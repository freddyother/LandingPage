package com.realestate.rentalandsales.repository.requestEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRE {

    private String email;

    private String fullName;

    private String phone;
}
