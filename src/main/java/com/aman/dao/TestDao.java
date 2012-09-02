package com.aman.dao;

import java.sql.Driver;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.aman.domain.Book;

public class TestDao {

	private JdbcTemplate jdbcTemplate;

	public TestDao() {
		Driver driver = new jdbcDriver();
		DataSource dataSource = new SimpleDriverDataSource(driver,
				"jdbc:hsqldb:librarymanagementsystem6; user=SA");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// create the book
	// list the book
	public void createBook(Book book) {
		jdbcTemplate.update(
				"insert into Book values(?,?,?,?,?,?)",
				new Object[] { new String(book.getbookId()),
						new String(book.getName()),
						new String(book.getAuthor()),
						new String(book.getPublisher()),
						new String(book.getDescription()),
						new Integer(book.getCopies()) });
	}
	
	
}
