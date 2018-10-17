package pl.techstyle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;
import pl.techstyle.Repository.BookRepository;
import pl.techstyle.model.Author;
import pl.techstyle.model.Book;

@Service
public class BookService {

	@Autowired
	BookRepository repoSitory;
	
	public void add(Book book) {
		repoSitory.save(book);
	}
	
	public List<Book> getAll(){
		return repoSitory.findAll();
	}
	public Book findById(int id) {
		return repoSitory.getOne(id);
	}
	
	public List<Author> getAllAuthors(int  id){
		return repoSitory.getAllAuthors(id);
	}
}
