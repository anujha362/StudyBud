package com.project.studybud.repositories;

import com.project.studybud.entities.Schedule;
import com.project.studybud.entities.ScheduleID;
import com.project.studybud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleID> {
    List<Schedule> findByStudent(Student student);
}
