package app.bookstore.socialbookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.bookstore.socialbookstore.domain.Book;
import app.bookstore.socialbookstore.domain.BookAuthor;
import app.bookstore.socialbookstore.mappers.BookAuthorMapper;
import app.bookstore.socialbookstore.mappers.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	BookAuthorMapper bookAuthorMapper;
	
	@Override
	public void saveBook(Book book) {
		bookMapper.save(book);
	}

	@Override
	public List<Book> getByTitle(String title) {
		List<Book> matchedBooks = bookMapper.findByTitle(title);
		
		return matchedBooks;
	}

	@Override
	public List<Book> getByBookAuthor(String author) {
		Optional<BookAuthor> bookAuthor = bookAuthorMapper.findByAuthorName(author);
		
		List<Book> matchedBooks = bookAuthor.get().getBooks();
		
		return matchedBooks;
	}

}