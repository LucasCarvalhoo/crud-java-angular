package com.lucas.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucas.enums.Category;
import com.lucas.enums.Status;
import com.lucas.enums.converters.CategoryConverter;
import com.lucas.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity // estabelece uma relação entre entidade e tabela de mesmo nome no banco de dados
@Data
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id=?")
@Where(clause = "status = 'Ativo'")
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
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotNull
    @Column(length = 20, nullable = false)
    @Convert(converter = StatusConverter.class)
    //@JsonIgnore // ignora e não devolve o status na resposta, caso não tenha um DTO
    private Status status = Status.ACTIVE;
}
