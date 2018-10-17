package pl.techstyle.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.techstyle.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
