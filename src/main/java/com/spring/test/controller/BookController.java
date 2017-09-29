package com.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.test.model.Book;
import com.spring.test.service.BookService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class BookController 
{
	 private static final Logger log = LoggerFactory.getLogger(BookController.class);
	 
	@Autowired
	protected BookService service;

	@RequestMapping(value = {"/*", "/books"})
	public String getBooks(Model model) {
		List<Book> books = service.getBooks();
		model.addAttribute("books",books);
		log.info("Available {} books !! after LogConfig", books.size());
		return "books";

	}

	@RequestMapping(value = "create-book")
	public String createBookGet(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		log.info("Book is created: {}", book);
		return "create-book";
	}

	@RequestMapping(value = "create-book", method = RequestMethod.POST)
	public String createBookPost(@ModelAttribute("book") Book book) {
		service.createBook(book);
		return "redirect:books";
	}
}