package com.project.studybud.repositories;

import com.project.studybud.entities.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
