package com.example.crudexample.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.crudexample.entity.*;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
