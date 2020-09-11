package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.State;
import com.emysilva.fleet.management.application.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    public void addState(State state) {
        stateRepository.save(state);
    }

    public State getState(int id) {
        return stateRepository.findById(id).orElseThrow(() -> new NoSuchDataException("state with id: " + id + "not found"));
    }

    public void deleteState(int id) {
        State stateToDelete = stateRepository.findById(id).orElseThrow(() -> new NoSuchDataException("state with id: " + id + "not found"));
        stateRepository.delete(stateToDelete);
    }
}
