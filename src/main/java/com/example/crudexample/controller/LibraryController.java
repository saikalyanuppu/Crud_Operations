package com.example.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudexample.entity.Library;
import com.example.crudexample.exception.BookNotFoundException;
import com.example.crudexample.response.ApiResponse;
import com.example.crudexample.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	public LibraryService libraryservice;
	
	@GetMapping("/books")
	public ApiResponse getAllBooks() {
		List<Library> book = libraryservice.getAllBooks();
		return new ApiResponse("success", "All Books found Successfully ", book);
	}
	
	@GetMapping("/books/{Bookid}")
	public ApiResponse getBook(@PathVariable("Bookid")  int Bookid) {
		Library book = libraryservice.getBookById(Bookid);
		if(book==null) {
		throw new BookNotFoundException("Book not found with Id" + Bookid);
	}
		return new ApiResponse("success", "Book details Found successfully", book);
   }
	
	@PostMapping("/book")
	public ApiResponse saveOrUpdate(@RequestBody Library library) {
		 libraryservice.saveOrUpdate(library);
		 return new ApiResponse("Success", "Book Saved Successfully", library);
	}
	
	@PutMapping("/book/{Bookid}")
	public ApiResponse UpdateBook(@PathVariable("Bookid") int Bookid, @RequestBody Library library) {
		Library exBook = libraryservice.getBookById(Bookid);
		if(exBook==null) {
			throw new BookNotFoundException("Book Not found with Id" + Bookid);
		}
			
		exBook.setBookname(library.getBookname());
		exBook.setAuthor(library.getAuthor());
		exBook.setPrice(library.getPrice());
		
		libraryservice.saveOrUpdate(exBook);
		return new ApiResponse("Success", "Book updated successfully", exBook);
	}
	
	@DeleteMapping("/books/{Bookid}")
	public ApiResponse deleteBook(@PathVariable("Bookid") int Bookid) {
		libraryservice.delete(Bookid);
		return new ApiResponse("Success", "Book deleted Successfully", libraryservice);
	}
}
