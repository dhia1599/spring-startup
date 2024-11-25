package com.exo1.exo1.service;

import com.exo1.exo1.entity.ProjetTasksNumber;
import com.exo1.exo1.repository.ProjetTasksNumberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetTasksNumberService {

    private final ProjetTasksNumberRepository projetTasksNumberRepository;

    public List<ProjetTasksNumber> getProjetTasksNumber() {
        return this.projetTasksNumberRepository.findAll();
    }
}
