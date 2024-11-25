package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.mapper.ProjetMapper;
import com.exo1.exo1.repository.ProjetRepository;
import com.exo1.exo1.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService {
    private ProjetRepository projetRepository;
    private ProjetMapper projetMapper;
    private TaskRepository taskRepository;

    public List<ProjetDto> findAll() {
        List<Projet> projets = this.projetRepository.findAllWithTasks();
        return this.projetMapper.toDtos(projets);
    }

    public ProjetDto findById(long id) {
        return projetMapper.toDto(projetRepository.findById(id).orElse(null));
    }

    public ProjetDto save(ProjetDto projetDto) {
        Projet projet = projetMapper.toEntity(projetDto);
        projet.getTasks().stream().forEach(t -> t.setProjet(projet));
        return projetMapper.toDto(projetRepository.save(projet));
    }

    public ProjetDto update(Long id, ProjetDto projetDto) {
        Projet existingProjet = projetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projet not found with id " + id));
        projetDto.setId(existingProjet.getId());
        Projet projetUpdated = projetMapper.toEntity(projetDto);
        projetUpdated.getTasks().stream().forEach(t -> {
            if(taskRepository.existsById(t.getId())) {
                t.setProjet(projetUpdated);
            }
        });
        return projetMapper.toDto(projetRepository.save(projetUpdated));
    }

    public void delete(Long id) {
        projetRepository.deleteById(id);
    }
}
