package com.example.crudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudexample.entity.Library;
import com.example.crudexample.repository.LibraryRepository;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllBooks() {
        return (List<Library>) libraryRepository.findAll();
    }

    public Library getBookById(int bookid) {
        Optional<Library> book = libraryRepository.findById(bookid);
        return book.orElse(null);
    }

    public void saveOrUpdate(Library library) {
        libraryRepository.save(library);
    }

    public void delete(int bookid) {
        libraryRepository.deleteById(bookid);
    }
		
	}

