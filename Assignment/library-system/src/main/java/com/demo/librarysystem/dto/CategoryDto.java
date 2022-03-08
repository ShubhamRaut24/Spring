package com.demo.librarysystem.dto;

import com.demo.librarysystem.entity.Book;
import lombok.*;

import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
public class CategoryDto {

    private int id;

    private String name;

    private List<Book> books;

    public CategoryDto(String name)
    {
        this.name = name;
    }
}
