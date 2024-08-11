package com.api.biblioteca.service;

import com.api.biblioteca.dto.books.BookDto;
import com.api.biblioteca.entity.BookPostEntity;
import com.api.biblioteca.repository.BooksPostRepository;
import com.api.biblioteca.service.books.BookServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceMapTest {

    @Mock
    private BooksPostRepository bookRepository;

    @InjectMocks
    private BookServiceMap bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookById() {
        BookPostEntity bookEntity = new BookPostEntity();
        bookEntity.setId(1L);
        bookEntity.setTitle("Test Book");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(bookEntity));

        BookDto bookDto = bookService.getBookById(1L).orElse(null);
        assertEquals("Test Book", bookDto.getTitle());
    }
}
