package com.lucas.crud_spring;

import com.lucas.enums.Category;
import com.lucas.model.Course;
import com.lucas.model.Lesson;
import com.lucas.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.lucas") // prepara todos os componentes do meu projeto
@EnableJpaRepositories(basePackages = "com.lucas.repository")
@EntityScan(basePackages = "com.lucas.model")
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory(Category.FRONT_END);

//			Lesson l = new Lesson();
//			l.setName("Introdução");
//			l.setYoutubeUrl("watch?v=1");
//			l.setCourse(c);
//			c.getLessons().add(l);
//
//			Lesson l1 = new Lesson();
//			l1.setName("Introdução");
//			l1.setYoutubeUrl("watch?v=2");
//			l1.setCourse(c);
//			c.getLessons().add(l1);

			courseRepository.save(c);
		};
	}

}
