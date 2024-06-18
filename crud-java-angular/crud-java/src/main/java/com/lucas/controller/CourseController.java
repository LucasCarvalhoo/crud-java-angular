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

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        //procura pelo id no repositorio
        return courseRepository.findById(id)
                //se achar retorna 200 ok
                .map(record -> ResponseEntity.ok().body(record))
                //se nao achar retorna 404 not found
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course){
        return courseRepository.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED.body(courseRepository.save(course));
    }


}
