package com.lucas.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity // estabelece uma relação entre entidade e tabela de mesmo nome no banco de dados
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "nome", length = 100, nullable = false)
    private String name;

    @NotNull
    @Size(max = 10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(name = "categoria", length = 20, nullable = false)
    private String category;
}
