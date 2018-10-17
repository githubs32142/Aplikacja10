package pl.techstyle.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.techstyle.model.*;

import pl.techstyle.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("Select b.authors From Book b where b.id=?1")
	List<Author> getAllAuthors(int idBook);

}
