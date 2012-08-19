package com.aman.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;

public class BookDao {
	List<Book> searchBookList = new ArrayList<Book>();
	private JdbcTemplate jdbcTemplate;

	public BookDao() {
		Driver driver = new jdbcDriver();
		DataSource dataSource = new SimpleDriverDataSource(driver,
				"jdbc:hsqldb:librarymanagementsystem19; user=SA");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// now the thing to do is to insert the book into the database
	public void createBook(Book book) {
		jdbcTemplate.update(
				"INSERT into Book values(?,?,?,?,?,?)",
				new Object[] { new String(book.getbookId()),
						new String(book.getName()),
						new String(book.getAuthor()),
						new String(book.getPublisher()),
						new String(book.getDescription()),
						new Integer(book.getCopies()) });
System.out.println("Successfully inserted the book to the database");
	}
/*
	public void createBook(Book book) {
		Connection con = ConnectionUtils.getConnection();

		try {

			PreparedStatement statement = populateCreateBookStatement(book, con);

			int result = statement.executeUpdate();
			if (result == 1) {
				System.out.println("Query is sucessfully executed");
			} else {
				System.out.println("Query is not sucessfully executed");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				throw new IllegalStateException(ex1);
			}

		}

	}

	private PreparedStatement populateCreateBookStatement(Book book,
			Connection con) throws SQLException {
		String query = "INSERT into Book values(?,?,?,?,?,?)";

		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, book.getbookId());
		statement.setString(2, book.getName());
		statement.setString(3, book.getAuthor());
		statement.setString(4, book.getPublisher());
		statement.setString(5, book.getDescription());
		statement.setInt(6, book.getCopies());
		return statement;
	}
*/
	// now have create the method that returns the list of Books
	public List<Book> listBook() {
		// return
		// jdbcTemplate.queryForList("select bookId,name,author,publication,description,noOfCopies from Book",new
		// BookMapper());
		return jdbcTemplate
				.query(
						"select bookId,name,author,publication,description,noOfCopies from Book",
						 new BookMapper());
	}

	private static final class BookMapper implements RowMapper<Book> {

		public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {

			Book book = new Book();
			book.setbookId(resultSet.getString("bookId"));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("author"));
			book.setDescription(resultSet.getString("publication"));
			book.setPublisher(resultSet.getString("description"));
			book.setCopies(resultSet.getInt("noOfCopies"));
			return book;
		}

	}
/* --> ListBook using the Jdbc
	public List<Book> listBook() {
		Connection con = ConnectionUtils.getConnection();

		List<Book> bookList = new ArrayList<Book>();
		try {

			String query = "SELECT bookId,name,author,publication,description,noOfCopies from Book";// bookTitle,author,genre,book_description,publisher,noOfCopies
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				while (resultSet.next()) {
					Book book = new Book();
					book.setbookId(resultSet.getString("bookId"));
					book.setName(resultSet.getString("name"));
					book.setAuthor(resultSet.getString("author"));
					// book.setGenre(resultSet.getString("genre"));
					book.setPublisher(resultSet.getString("publication"));
					book.setDescription(resultSet.getString("description"));
					book.setCopies(resultSet.getInt("noOfCopies"));

					bookList.add(book);

				}

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (SQLException ex2) {
				throw new IllegalStateException(ex2);
			}
		}
		return bookList;
	}
	*/
	// now will write the spring code for SearchBook
	/*
	public void searchBook(Book book) {
		List<Book> bookList = new ArrayList<Book>();

		Connection con = ConnectionUtils.getConnection();
		try {

			String query = "SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author =? and name=?";// where
																																// bookTitle="
			// + title + " and author= " + author ;
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, book.getAuthor());
			statement.setString(2, book.getName());
			ResultSet resultSet = statement.executeQuery();
			boolean bookPresenceStatus = true;

			while (resultSet.next()) {
				bookPresenceStatus = false;
				Book book1 = new Book();
				book1.setbookId(resultSet.getString("bookId"));
				book1.setName(resultSet.getString("name"));
				book1.setAuthor(resultSet.getString("author"));
				// book1.setGenre(resultSet.getString("genre"));
				book1.setDescription(resultSet.getString("description"));
				book1.setPublisher(resultSet.getString("publication"));
				book1.setCopies(resultSet.getInt("noOfCopies"));
				bookList.add(book1);
			}
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				throw new IllegalStateException(ex1);

			}

		}
		searchBookList = bookList;
	}

	public List<Book> listSearchedBook() {
		return searchBookList;
	}
*/
	public List<Book> searchBook(Book book){
		return jdbcTemplate.query("SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author =? and name=?", new Object[]{new String(book.getAuthor()),new String(book.getName())},new BookMapper());
	}
}
