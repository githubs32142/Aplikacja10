package pl.techstyle.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.techstyle.Repository.AuthorRepository;
import pl.techstyle.model.*;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repositoryAuthor;
	
	public List<Author> getAll(){
		return repositoryAuthor.findAll();
	}
	
	public void add(Author a) {
		repositoryAuthor.save(a);
	}
	public Author findById(int id) {
		return repositoryAuthor.getOne(id); 
	}
	public void save(Author a) {
		repositoryAuthor.save(a);
	}
	
}
