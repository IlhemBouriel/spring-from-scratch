package com.spring.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.model.Book;
import com.spring.test.repository.BookRepository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookService {
	
	private static final Logger log = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	protected BookRepository repository;
	
	public List<Book> getBooks() {
		return repository.getBooks();
	}
	
	public void createBook(Book book) {
		repository.createBook(book);
	}
}