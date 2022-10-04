package com.mmtspl.repository;
import org.springframework.data.repository.CrudRepository;

import com.mmtspl.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
