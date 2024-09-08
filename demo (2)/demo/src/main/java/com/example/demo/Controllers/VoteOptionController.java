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
@RequestMapping("/voteOptions")
public class VoteOptionController {

    @Autowired
    private PollManager pollManager;

    // Crear una nueva opción de voto
    @PostMapping
    public ResponseEntity<VoteOption> createVoteOption(@RequestBody VoteOption voteOption) {
        pollManager.addVoteOption(voteOption.getId(), voteOption);
        return new ResponseEntity<>(voteOption, HttpStatus.CREATED); // 201 Created
    }

    // Obtener una opción de voto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<VoteOption> getVoteOption(@PathVariable String id) {
        try {
            Long voteOptionId = Long.parseLong(id); // Conversión de String a Long
            VoteOption voteOption = pollManager.getVoteOption(voteOptionId);
            if (voteOption != null) {
                return ResponseEntity.ok(voteOption);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVoteOption(@PathVariable String id, @RequestBody VoteOption updatedVoteOption) {
        try {
            Long voteOptionId = Long.parseLong(id); // Conversión de String a Long
            VoteOption existingVoteOption = pollManager.getVoteOption(voteOptionId);
            if (existingVoteOption != null) {
                existingVoteOption.setOptionText(updatedVoteOption.getOptionText());
                pollManager.addVoteOption(voteOptionId, existingVoteOption); // Actualiza la opción en PollManager
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoteOption(@PathVariable String id) {
        try {
            Long voteOptionId = Long.parseLong(id); // Conversión de String a Long
            pollManager.deleteVoteOption(voteOptionId);
            return ResponseEntity.noContent().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Obtener todas las opciones de voto
    @GetMapping("/list")
    public ResponseEntity<List<VoteOption>> getAllVoteOptions() {
        List<VoteOption> voteOptions = pollManager.getAllVoteOptions();
        return new ResponseEntity<>(voteOptions, HttpStatus.OK); // 200 OK
    }
}
