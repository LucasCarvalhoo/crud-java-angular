package com.lucas.repository;

import com.lucas.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Repository // conexão com o banco de dados
public interface CourseRepository extends JpaRepository<Course, Long> {
    //List<Course> findLimited(int limit);
    @Query("SELECT c FROM Course c")
    Page<Course> courseLimit(Pageable pageable);

    List<Course> findByName(String name);
}
