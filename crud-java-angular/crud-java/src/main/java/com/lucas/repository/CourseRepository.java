package com.lucas.repository;

import com.lucas.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // conexão com o banco de dados
public interface CourseRepository extends JpaRepository<Course, Long> {

}
