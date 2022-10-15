package com.mmtspl.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mmtspl.model.Books;


public interface BooksRepository extends CrudRepository<Books, Integer>
{
    ///////////////////////////////////////////////////  JPQL  and Native SQL  ///////////////////////////////////////////////////////////
	@Query("SELECT s FROM Books s where bookid=:bookid") 
	Books findBooksByIdJPQL(int bookid);
	
	@Query(value = "SELECT * FROM Books WHERE bookid = :bookid and author= :author", nativeQuery = true) 
	Books findBooksByBookIdAndAuthorNative(@Param("bookid") int bookid, @Param("author") String author);

	 public Books findBooksByPrice(int price);
}
