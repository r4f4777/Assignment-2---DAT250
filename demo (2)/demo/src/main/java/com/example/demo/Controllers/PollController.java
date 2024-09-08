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
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    // Crear una nueva encuesta
    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
        pollManager.addPoll(poll.getId(), poll);
        return new ResponseEntity<>(poll, HttpStatus.CREATED); // 201 Created
    }

    // Obtener una encuesta por su ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Poll> getPoll(@PathVariable String id) {
        Long pollId = Long.parseLong(id); // Conversión de String a Long
        Poll poll = pollManager.getPoll(pollId);
        if (poll != null) {
            return ResponseEntity.ok(poll);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Actualizar una encuesta existente
    @PutMapping("/{id}")
    public ResponseEntity<Poll> updatePoll(@PathVariable long id, @RequestBody Poll updatedPoll) {
        Poll existingPoll = pollManager.getPoll(id);
        if (existingPoll != null) {
            // Actualiza los campos del poll existente
            existingPoll.setQuestion(updatedPoll.getQuestion());
            existingPoll.setPublishedAt(updatedPoll.getPublishedAt());
            existingPoll.setValidUntil(updatedPoll.getValidUntil());
            pollManager.addPoll(id, existingPoll); // Actualiza la encuesta en PollManager
            return new ResponseEntity<>(existingPoll, HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Eliminar una encuesta por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable long id) {
        Poll poll = pollManager.getPoll(id);
        if (poll != null) {
            pollManager.deletePoll(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Obtener todas las encuestas
    @GetMapping("/pollsList")
    public ResponseEntity<List<Poll>> getAllPolls() {
        List<Poll> polls = pollManager.getAllPolls();
        return new ResponseEntity<>(polls, HttpStatus.OK); // 200 OK
    }
}
