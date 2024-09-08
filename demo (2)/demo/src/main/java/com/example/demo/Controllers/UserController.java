package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

import com.example.demo.Poll;
import com.example.demo.User;
import com.example.demo.Vote;
import com.example.demo.VoteOption;
import com.example.demo.PollManager;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PollManager pollManager;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        pollManager.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED); // 201 Created
    }

    // Obtener un usuario por su username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = pollManager.getUser(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Actualizar un usuario existente
    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
        User existingUser = pollManager.getUser(username);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            pollManager.addUser(existingUser); // Actualiza el usuario en PollManager
            return new ResponseEntity<>(existingUser, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Eliminar un usuario por su username
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        User existingUser = pollManager.getUser(username);
        if (existingUser != null) {
            pollManager.deleteUser(username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Obtener todos los usuarios
    @GetMapping("/usersList")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = pollManager.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK); // 200 OK
    }
}
