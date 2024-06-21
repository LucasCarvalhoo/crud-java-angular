package com.lucas.DTO.mapper;

import com.lucas.DTO.CourseDTO;
import com.lucas.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course){
        return new CourseDTO(course.getId(), course.getName(), course.getCategory());
    }

    public Course toEntity(CourseDTO courseDTO){
        if(courseDTO == null){
            return null;
        }

        Course course = new Course();
        if(courseDTO.id() != null){
            course.setId(courseDTO.id());
        }
        //no dto não tem alteração
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());
        return course;
    }
}
