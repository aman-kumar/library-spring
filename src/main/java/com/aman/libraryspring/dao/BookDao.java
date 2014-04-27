package com.aman.libraryspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.interfaces.BookDAO;

@Repository
public class BookDao implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDao() {
        DataSource dataSource = new ConnectionUtils().getDataSource();
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public int createBook(Book book) {
    	
         
        int i=jdbcTemplate.update(
                "INSERT into Book (name, author, publication, description, noOfCopies) values(?,?,?,?,?)",
                new Object[] {
                        new String(book.getName()),
                        new String(book.getAuthor()),
                        new String(book.getPublisher()),
                        new String(book.getDescription()),
                        new Integer(book.getCopies()) });
        System.out.println("Successfully inserted the book in the database, return of Update in jdbcTemplate is "+i );
return i;
        
        

    }
    public List<Book> findBook(Book book){
        return jdbcTemplate
                .query("SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author=? and name=?",
                        new Object[] { new String(book.getAuthor()),
                                new String(book.getName()) }, new BookMapper());    	
    	
    }
    public List<Book> getEnteredBook(Book book) {
    	 List<Book> bookList=jdbcTemplate
                 .query("SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE name=?",new Object[] {
                         new String(book.getName()) }, new BookMapper());
                         
          return bookList;
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
            book.setBookId(resultSet.getInt("bookId"));
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
    	                .query("SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author=? or name=?",
    	                        new Object[] { new String(book.getAuthor()),
    	                                new String(book.getName()) }, new BookMapper());
    }
}

