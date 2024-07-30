package com.realestate.rentalandsales.repository;

import com.realestate.rentalandsales.dto.UserDTO;
import com.realestate.rentalandsales.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String s);

    Optional<User> findUserById(String id);

}
