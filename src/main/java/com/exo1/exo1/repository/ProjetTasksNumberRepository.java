package com.exo1.exo1.repository;

import com.exo1.exo1.entity.ProjetTasksNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetTasksNumberRepository extends JpaRepository<ProjetTasksNumber, Long> {

}
