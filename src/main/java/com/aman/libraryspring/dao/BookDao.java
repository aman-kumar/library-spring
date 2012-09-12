package com.aman.libraryspring.dao;

import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.aman.libraryspring.domain.Book;

public class BookDao {

    private JdbcTemplate jdbcTemplate;

    public BookDao() {
        Driver driver = new jdbcDriver();
        DataSource dataSource = new SimpleDriverDataSource(driver,
                "jdbc:hsqldb:mem:aname; user=SA");
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void createBook(Book book) {
        jdbcTemplate.update(
                "INSERT into Book values(?,?,?,?,?,?)",
                new Object[] { new String(book.getBookId()),
                        new String(book.getName()),
                        new String(book.getAuthor()),
                        new String(book.getPublisher()),
                        new String(book.getDescription()),
                        new Integer(book.getCopies()) });
        System.out.println("Successfully inserted the book in the database");

    }

    public List<Book> listBook() {
        return jdbcTemplate
                .query("SELECT bookId,name,author,publication,description,noOfCopies from Book",
                        new BookMapper());
    }

    private static final class BookMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            // TODO Auto-generated method stub
            Book book = new Book();
            book.setBookId(resultSet.getString("bookId"));
            book.setAuthor(resultSet.getString("author"));
            book.setName(resultSet.getString("name"));
            book.setDescription(resultSet.getString("description"));
            book.setPublisher(resultSet.getString("publication"));
            book.setCopies(resultSet.getInt("noOfCopies"));
            return book;
        }

    }

    public List<Book> searchBook(Book book) {

        return jdbcTemplate
                .query("SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author=? and name=?",
                        new Object[] { new String(book.getAuthor()),
                                new String(book.getName()) }, new BookMapper());
    }
}
