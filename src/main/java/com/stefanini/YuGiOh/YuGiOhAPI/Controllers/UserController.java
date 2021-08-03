package com.stefanini.YuGiOh.YuGiOhAPI.Controllers;

import com.stefanini.YuGiOh.YuGiOhAPI.DTO.UserDTO;
import com.stefanini.YuGiOh.YuGiOhAPI.Entities.User;
import com.stefanini.YuGiOh.YuGiOhAPI.Services.UserServices;
import com.stefanini.YuGiOh.YuGiOhAPI.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserMapper userMapper = UserMapper.getInstance();

    private UserServices userServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        User usersData = userServices.findById(id);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usersData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.toModel(userDTO);
        try {
            User userSaved = userServices.save(user);
            return new ResponseEntity(userSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            userServices.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        userDTO.setIdUser(id);
        User user = userMapper.toModel(userDTO);
        try {
            User userSaved = userServices.save(user);
            return new ResponseEntity(userSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}