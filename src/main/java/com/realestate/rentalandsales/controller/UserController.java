package com.realestate.rentalandsales.controller;

import com.realestate.rentalandsales.dto.GenericResponseDTO;
import com.realestate.rentalandsales.dto.GenericResponseListDTO;
import com.realestate.rentalandsales.dto.UserDTO;
import com.realestate.rentalandsales.entity.User;
import com.realestate.rentalandsales.repository.requestEntity.UpdateUserRE;
import com.realestate.rentalandsales.repository.requestEntity.UserRE;
import com.realestate.rentalandsales.service.UserService;
import com.realestate.rentalandsales.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRE userRE) {
        if (!Utils.validateEmailFormat(userRE.getEmail()))
            return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "Valid email is required", ""));
        try{

            Optional<User> newUser = userService.createUser(userRE);

            return ResponseEntity.status(HttpStatus.CREATED).body( new GenericResponseDTO<>(true,"Success", newUser.get()));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>(false, e.getMessage(),""));
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {

        try {
            List<UserDTO> usersDTO = userService.getAllUsers();

            return ResponseEntity.ok(new GenericResponseListDTO<>(true,"Success", usersDTO));

        }catch (Exception e){

            return ResponseEntity.ok(new GenericResponseDTO<>(true, e.getMessage(), ""));
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable (value = "id") String id){

        Optional<UserDTO> userDTO = userService.getUserById(id);

        if (userDTO.isPresent()){

            return ResponseEntity.ok(new GenericResponseDTO<>(true,"Success",userDTO.get()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>(false, "Error",""));

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail (@PathVariable (value = "email") String email){

        Optional<UserDTO> userDTO = userService.getUserByEmail(email);

        if (userDTO.isPresent()){

            return ResponseEntity.ok(new GenericResponseDTO<>(true,"Success",userDTO.get()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponseDTO<>(false, "Error",""));

    }

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateMyProfile (@RequestBody UserRE userRE, @PathVariable (value = "email") String email) throws Exception{

        UserDTO updateUserDTO =  userService.updateUser(email, userRE);

        try {

            //Optional<User> persistentUser = userService.updateCurrentUser(updateUserRE, id);

        }catch (Exception e){

        }

        return (ResponseEntity<?>) null;
    }



}
