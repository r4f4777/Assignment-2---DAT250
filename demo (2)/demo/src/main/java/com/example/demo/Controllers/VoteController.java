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
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private PollManager pollManager;

    // Crear un nuevo voto
    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        pollManager.addVote(vote.getId(), vote);
        return new ResponseEntity<>(vote, HttpStatus.CREATED); // 201 Created
    }

    // Obtener un voto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVote(@PathVariable String id) {
        try {
            Long voteId = Long.parseLong(id); // Conversión de String a Long
            Vote vote = pollManager.getVote(voteId);
            if (vote != null) {
                return ResponseEntity.ok(vote);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVote(@PathVariable String id, @RequestBody Vote updatedVote) {
        try {
            Long voteId = Long.parseLong(id); // Conversión de String a Long
            Vote existingVote = pollManager.getVote(voteId);
            if (existingVote != null) {
                existingVote.setUser(updatedVote.getUser());
                existingVote.setVoteOption(updatedVote.getVoteOption());
                pollManager.addVote(voteId, existingVote); // Actualiza el voto en PollManager
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVote(@PathVariable String id) {
        try {
            Long voteId = Long.parseLong(id); // Conversión de String a Long
            pollManager.deleteVote(voteId);
            return ResponseEntity.noContent().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Obtener todos los votos
    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = pollManager.getAllVotes();
        return new ResponseEntity<>(votes, HttpStatus.OK); // 200 OK
    }
}
