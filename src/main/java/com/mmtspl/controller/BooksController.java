package com.mmtspl.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmtspl.model.Books;
import com.mmtspl.service.BooksService;
//mark class as Controller
@RestController
public class BooksController 
{
	//autowire the BooksService class
	@Autowired
	BooksService booksService;
	
	//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/books/getAllBooks")
	private List<Books> getAllBooks() 
	{
		return booksService.getAllBooks();
	}
	
	//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/books/getBooksByID/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) 
	{
		return booksService.getBooksById(bookid);
	}
	
	
	///////////////////////////////////////////////////  JPQL  and Native SQL  ///////////////////////////////////////////////////////////
	
	@GetMapping("/books/findBooksByIdJPQL/{bookid}")
	private Books findBooksByIdJPQL(@PathVariable("bookid") int bookid) 
	{
		return booksService.findBooksByIdJPQL(bookid);
	}
	
	@GetMapping("/books/getBooksByIDandAuthorNative/{bookid}/{author}")
	private Books getBooksByIDandAuthorNative(@PathVariable("bookid") int bookid, @PathVariable("author") String author) 
	{
		return booksService.getBooksByIDandAuthorNative(bookid, author);
	}
	
	@GetMapping("/books/findBooksByPrice/{price}")
	private Books findBooksByPrice(@PathVariable("price") int price) 
	{
		return booksService.findBooksByPrice(price);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//creating a delete mapping that deletes a specified book
	@DeleteMapping("/books/deleteBooksByID/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) 
	{
		booksService.delete(bookid);
	}
	//creating post mapping that post the book detail in the database
	@PostMapping("/books/saveBook")
	private int saveBook(@RequestBody Books books) 
	{
		booksService.saveOrUpdate(books);
		return books.getBookid();
	}
	//creating put mapping that updates the book detail 
	@PutMapping("/books/updateBook")
	private Books update(@RequestBody Books books) 
	{
		booksService.saveOrUpdate(books);
		return books;
	}
}
