package com.lucas.crud_spring.v1.Course;

import com.lucas.enums.Category;
import com.lucas.enums.Status;
import com.lucas.model.Course;
import com.lucas.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void courseLimit(){

        courseRepository.deleteAll();

        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setName("Course " + i);
            course.setCategory(Category.FRONT_END);
            course.setStatus(Status.ACTIVE);
            courseRepository.save(course);
        }

        Pageable pageable = PageRequest.of(0, 5);

        Page<Course> page = courseRepository.courseLimit(pageable);

        assertEquals(5, page.getNumberOfElements());
    }
}
