package com.lucas.controller;

import com.lucas.model.Course;
import com.lucas.repository.CourseRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // end-point
@RequestMapping("api/courses")
@AllArgsConstructor // injeção de dependencia
public class CourseController {

    private CourseRepository courseRepository;

    @GetMapping
    public @ResponseBody List<Course> list(){
        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        return courseRepository.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED.body(courseRepository.save(course));
    }
}
