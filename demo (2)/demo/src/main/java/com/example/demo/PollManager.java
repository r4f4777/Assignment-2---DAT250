package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.time.Instant;

import com.example.demo.Poll;
import com.example.demo.User;
import com.example.demo.Vote;
import com.example.demo.VoteOption;
import com.example.demo.PollManager;

import org.springframework.stereotype.Component;

@Component
public class PollManager {

    // Colecciones para gestionar Users y Polls
    private Map<String, User> users = new HashMap<>();
    private Map<Long, Poll> polls = new HashMap<>();
    private Map<Long, Vote> votes = new HashMap<>();
    private Map<Long, VoteOption> voteOptions = new HashMap<>();


    // Métodos para gestionar usuarios

    // Agregar un usuario
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    // Obtener un usuario por su username
    public User getUser(String username) {
        return users.get(username);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    // Actualizar un usuario existente
    public void updateUser(String username, User updatedUser) {
        if (users.containsKey(username)) {
            users.put(username, updatedUser);
        }
    }

    // Eliminar un usuario por su username
    public void deleteUser(String username) {
        users.remove(username);
    }



    // Métodos para gestionar encuestas (Polls)

    // Agregar una encuesta
    public void addPoll(Long id, Poll poll) {
        polls.put(id, poll);
    }

    // Obtener una encuesta por su id
    public Poll getPoll(Long id) {
        return polls.get(id);
    }

    // Obtener todas las encuestas
    public List<Poll> getAllPolls() {
        return polls.values().stream().collect(Collectors.toList());
    }

    // Actualizar una encuesta existente
    public void updatePoll(Long id, Poll updatedPoll) {
        if (polls.containsKey(id)) {
            polls.put(id, updatedPoll);
        }
    }

    // Eliminar una encuesta por su id
    public void deletePoll(Long id) {
        polls.remove(id);
    }



    // Métodos para gestionar opciones de voto (VoteOptions)

    // Agregar una opción de voto
    public void addVoteOption(Long id, VoteOption voteOption) {
        voteOptions.put(id, voteOption);
    }

    // Obtener una opción de voto por su id
    public VoteOption getVoteOption(Long id) {
        return voteOptions.get(id);
    }

    // Obtener todas las opciones de voto
    public List<VoteOption> getAllVoteOptions() {
        return voteOptions.values().stream().collect(Collectors.toList());
    }

    // Actualizar una opción de voto existente
    public void updateVoteOption(Long id, VoteOption updatedVoteOption) {
        if (voteOptions.containsKey(id)) {
            voteOptions.put(id, updatedVoteOption);
        }
    }

    // Eliminar una opción de voto por su id
    public void deleteVoteOption(Long id) {
        voteOptions.remove(id);
    }



    // Métodos para gestionar votos (Votes)

    // Agregar un voto
    public void addVote(Long id, Vote vote) {
        votes.put(id, vote);
    }

    // Obtener un voto por su id
    public Vote getVote(Long id) {
        return votes.get(id);
    }

    // Obtener todos los votos
    public List<Vote> getAllVotes() {
        return votes.values().stream().collect(Collectors.toList());
    }

    // Actualizar un voto existente
    public void updateVote(Long id, Vote updatedVote) {
        if (votes.containsKey(id)) {
            votes.put(id, updatedVote);
        }
    }

    // Eliminar un voto por su id
    public void deleteVote(Long id) {
        votes.remove(id);
    }

}
