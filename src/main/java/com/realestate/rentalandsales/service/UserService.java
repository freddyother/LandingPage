package com.realestate.rentalandsales.service;

import com.realestate.rentalandsales.dto.UserDTO;
import com.realestate.rentalandsales.entity.User;
import com.realestate.rentalandsales.exception.NotValidRequestException;
import com.realestate.rentalandsales.repository.UserRepository;
import com.realestate.rentalandsales.repository.requestEntity.UpdateUserRE;
import com.realestate.rentalandsales.repository.requestEntity.UserRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Optional<User> createUser(UserRE userRE) throws Exception {

        User user = this.createNewUserFromRE(userRE);

        userRepository.save(user);

        UserDTO userDTO = new UserDTO(user);

        return Optional.of(user);
    }

    private User createNewUserFromRE(UserRE userRE) throws Exception {

        User user = new User();

        user.setTimesLogged(1);

        user.setCreatedAt(new Date());

        if (userRE.getFullName() != null) user.setFullName(userRE.getFullName());

        if (userRE.getPassword() != null) user.setPassword(userRE.getPassword());

        if (userRE.getEmail() != null) user.setEmail(userRE.getEmail());

        if (userRE.getPhone() != null) user.setPhone(userRE.getPhone());

        if (userRE.getDob() != null) user.setDob(userRE.getDob());

        if (userRE.getGender() != null) user.setGender(userRE.getGender());

        user.setEmailVerified(false);

        user.setPhoneVerified(false);

        user.setIsLocked(false);

        user.setIsActive(true);

        return user;

    }

    public UserDTO transformFromUserToDTO (User user)  {

        UserDTO userDTO = new UserDTO(user);

        return userDTO;
    }

    public List<UserDTO> getAllUsers() throws Exception{

        List<User> list = userRepository.findAll();

        List<UserDTO> listDto = new ArrayList<>();

        list.forEach(x -> listDto.add(this.transformFromUserToDTO(x)));

        return listDto;

    }


    public Optional<UserDTO> getUserById(String id) {

        Optional<User> userOptional = userRepository.findUserById(id);

        return Optional.of(transformFromUserToDTO(userOptional.get()));

    }

    public Optional<UserDTO> getUserByEmail(String email) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        return Optional.of(transformFromUserToDTO(userOptional.get()));

    }

    public UserDTO updateUser(String email, UserRE userRE) throws Exception{

        Optional<User> user =  userRepository.findByEmail(email);

        if (user.isPresent()){

            User userEntity = user.get();

            this.updateUserData(userEntity,userRE);

            userRepository.save(userEntity);

            return this.transformUserToDTO(user.get());

        }

        throw new Exception("User Not Found");
    }

    private void updateUserData(User user, UserRE userRE) throws Exception{

        if(userRE.getFullName() != null) user.setFullName(userRE.getFullName());

        if(userRE.getPhone() != null) user.setPhone(userRE.getPhone());

        if(userRE.getGender() != null) user.setGender(userRE.getGender());

        if(userRE.getDob() != null) user.setDob(userRE.getDob());

    }

    private UserDTO transformUserToDTO(User user) {

        UserDTO userDTO = new UserDTO(user);

        return userDTO;

    }
}
