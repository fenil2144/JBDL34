package com.example.startProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.startProject.model.Book;

@RestController
public class BookController {

	private HashMap<Integer, Book> bookHashMap = new HashMap<Integer, Book>();
	
	private static Logger logger = LoggerFactory.getLogger(BookController.class);
	
//	insertBook - PostMethod - RequestBody
//	updateBook - PutMethod - RequestBody
//	GetBookDetails - GetMethod - RequestParam - bookId
//	deleteBook - deleteMethod - RequestParam - bookId
//	getAllBooks - Get - return book list
	
	@PostMapping("/insert_book")
	public String insertBook(@RequestBody Book book) {
		logger.info("Book coming for inserted",book);
		if(bookHashMap.containsKey(book.getId())) {
			logger.error("Book Id Already Present");
			return "Book Id Already Present";
		}
		
		bookHashMap.put(book.getId(), book);
		return "Book Inserted Successfully";
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBookByBookId(@PathVariable("bookId") int bookId) {
		logger.info("bookId received : {}",bookId);
		return bookHashMap.get(bookId);
	}
	
	@GetMapping("/books/all")
	public List<Book> getBooks(){
		return bookHashMap.values()
				.stream()
				.collect(Collectors.toList());
	}
	
	@PutMapping("updateBook")
	public Book updateBook(@RequestBody Book book) {
		bookHashMap.put(book.getId(), book);
		return bookHashMap.get(book.getId()); 
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBookById(@PathVariable("id") int bookId) {
		bookHashMap.remove(bookId);
		return "Book deleted Successfully!";
	}
 
}
