package com.lucas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LessonDTO (
        Long id,
        String name,
        String youtubeUrl
                            ){

}
