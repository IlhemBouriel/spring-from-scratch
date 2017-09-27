package com.spring.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.model.Book;
import com.spring.test.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

	
	@Autowired
	protected BookRepository repository;
	
	public List<Book> getBooks() {
		return repository.getBooks();
	}
	
	public void createBook(Book book) {
		repository.createBook(book);
	}
}