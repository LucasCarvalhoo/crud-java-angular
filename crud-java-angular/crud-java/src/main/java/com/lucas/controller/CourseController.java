package com.lucas.controller;

import com.lucas.model.Course;
import com.lucas.repository.CourseRepository;
import lombok.AllArgsConstructor;

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
    public void create(@RequestBody Course course){
        courseRepository.save(course);
    }
}
