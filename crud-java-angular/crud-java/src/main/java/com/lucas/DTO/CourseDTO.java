package com.lucas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

// classe java que não tem um construtor vazio, nem metodos setters
// a unica forma de ter dados é pelo construtor e as informações são imutaveis
public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Size(min = 5, max = 100)  String name,
        @NotNull @Size(max = 10)  @Pattern(regexp = "Back-end|Front-end") String category,
        List<LessonDTO> lessons) {


}
