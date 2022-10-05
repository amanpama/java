package com.aman.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aman.book.models.Book;
import com.aman.book.repos.BookRepository;

@Service
public class BookService {
	 // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    
    
    // READ ALL
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // CREATE
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //  READ ONE
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

//	public List<Book> whatever(String something){
//		return bookRepository.findByDescriptionContaining(something);
//	}
}



