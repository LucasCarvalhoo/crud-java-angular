package com.lucas.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity // estabelece uma relação entre entidade e tabela de mesmo nome no banco de dados
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String name;

    @Column(name = "categoria", length = 20, nullable = false)
    private String category;
}
