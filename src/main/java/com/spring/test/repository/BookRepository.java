package com.spring.test.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookRepository {

	/*
	 * @Autowired
	 */
	//protected SessionFactory sessionFactory;
	
	public static List<Book> books;
	
	BookRepository()
	{
		this.books = new ArrayList<Book>();
		Book b1 = new Book(1,"title1","author1");
		Book b2 = new Book(2,"title2","author2");
		Book b3 = new Book(3,"title3","author3");
		this.books.add(b1);
		this.books.add(b2);
		this.books.add(b3);
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Book> getBooks()
	{
		return this.books;
	}
	
	
	public void createBook(Book book) {
		//sessionFactory.getCurrentSession().save(book);
		this.books.add(book);
	}
	
	
}