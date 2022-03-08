package com.demo.librarysystem.dto;

import com.demo.librarysystem.entity.Category;
import lombok.*;

@Data
@NoArgsConstructor
public class BookDto {

    private int id;

    private String name;

    private String author;

    private int quantity;

    private Category category;

    public BookDto(String name, String author, int quantity, Category category) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
    }
}
