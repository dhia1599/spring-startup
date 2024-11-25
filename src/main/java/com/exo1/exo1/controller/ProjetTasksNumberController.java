package com.exo1.exo1.controller;

import com.exo1.exo1.entity.ProjetTasksNumber;
import com.exo1.exo1.service.ProjetTasksNumberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projet-tasks-number")
@AllArgsConstructor
public class ProjetTasksNumberController {

    private final ProjetTasksNumberService projetTasksNumberService;

    @GetMapping
    public ResponseEntity<List<ProjetTasksNumber>> getTasksNumber() {
        return ResponseEntity.ok(this.projetTasksNumberService.getProjetTasksNumber());
    }
}
