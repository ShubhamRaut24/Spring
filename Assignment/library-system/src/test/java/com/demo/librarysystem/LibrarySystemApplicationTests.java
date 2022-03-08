package com.demo.librarysystem;

import com.demo.librarysystem.controller.CategoryController;
import com.demo.librarysystem.dao.BookRepository;
import com.demo.librarysystem.dao.CategoryRepository;
import com.demo.librarysystem.dto.BookDto;
import com.demo.librarysystem.dto.CategoryDto;
import com.demo.librarysystem.entity.Book;
import com.demo.librarysystem.entity.Category;
import com.demo.librarysystem.service.BookService;
import com.demo.librarysystem.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarySystemApplicationTests {

    //------------------------------TESTING BOOK SERVICE

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Mock
    private Model model;

    @Test
    void findAllBooksTest() {
        when(bookRepository.findAll()).thenReturn(
                Stream.of(
                        new Book("Time", "HG.Williams", 35, new Category("Science")),
                        new Book("Stars", "Brian Greene", 24, new Category("Astronomy"))
                ).collect(Collectors.toList()));

        Assertions.assertEquals(2, bookService.findAll().size());

    }

    @Test
    void findByIdBookTest() {
        int id = 1;
        when(bookRepository.findById(id)).thenReturn(
                Optional.of(new Book("DBMS", "John", 45, new Category("Computers")))
        );

        Assertions.assertEquals("DBMS", bookService.findById(id).getName());
    }

    @Test
    void saveBookTest() {
        Book book = new Book("DBMS", "John", 45, new Category("Computers"));
        bookRepository.save(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void deleteBookTest() {
        int id = 1;
        bookRepository.deleteById(id);
        verify(bookRepository, times(1)).deleteById(id);
    }

    //------------------------------TESTING CATEGORY SERVICE


    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;


    @Test
    void findAllCategoriesTest() {
        when(categoryRepository.findAll()).thenReturn(
                Stream.of(
                                new Category("Science"),
                                new Category("Astronomy")
                        )
                        .collect(Collectors.toList()));

        Assertions.assertEquals(2, categoryService.findAll().size());

    }

    @Test
    void findByIdCategoryTest() {
        int id = 1;
        when(categoryRepository.findById(id)).thenReturn(
                Optional.of(new Category("Computers"))
        );

        Assertions.assertEquals("Computers", categoryService.findById(id).getName());
    }

    @Test
    void saveCategoryTest() {
        Category category = new Category("Computers");
        categoryRepository.save(category);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void deleteCategoryTest() {
        int id = 1;
        categoryRepository.deleteById(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }



    //------------------------------TESTING BOOK CONTROLLER

    @Test
    void listAllBooksControllerTest() {
        when(bookService.findAll()).thenReturn(
                Stream.of(
                        new BookDto("Time", "HG.Williams", 35, new Category("Science")),
                        new BookDto("Stars", "Brian Greene", 24, new Category("Astronomy"))
                ).collect(Collectors.toList()));

        Assertions.assertEquals(2, bookRepository.findAll().size());

    }

    @Test
    void saveBookControllerTest() {
        Book book = new Book("DBMS", "John", 45, new Category("Computers"));
        bookService.save(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void deleteBookControllerTest() {
        int id = 1;
        bookService.deleteById(id);
        verify(bookRepository, times(1)).deleteById(id);
    }



    //------------------------------TESTING CATEGORY CONTROLLER


    @Test
    void ListAllCategoriesControllerTest() {
        when(categoryService.findAll()).thenReturn(
                Stream.of(
                                new CategoryDto("Science"),
                                new CategoryDto("Astronomy")
                        )
                        .collect(Collectors.toList()));

        Assertions.assertEquals(2, categoryRepository.findAll().size());

    }

    @Test
    void saveCategoryControllerTest() {
        Category category = new Category("Computers");
        categoryService.save(category);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void deleteCategoryControllerTest() {
        int id = 1;
        categoryService.deleteById(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }



    @Test
    void addCategoryFormTest()
    {
        CategoryController categoryController=new CategoryController();
        String response=categoryController.addCategoryForm(model);
        Assertions.assertEquals("add-category-form",response);
    }






}