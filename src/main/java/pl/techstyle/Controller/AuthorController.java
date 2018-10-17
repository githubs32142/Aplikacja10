package pl.techstyle.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.techstyle.Service.AuthorService;
import pl.techstyle.Service.BookService;
import pl.techstyle.model.Author;
import pl.techstyle.model.Book;

@Controller
@RequestMapping(value="/author")
public class AuthorController {

	@Autowired
	AuthorService serviceAuthor;
	
	@Autowired
	BookService serviceBook;
	
	@GetMapping(value="/all")
	public ModelAndView getAllIndex() {
		ModelAndView m = new ModelAndView();
		m.addObject("authors",serviceAuthor.getAll());
		m.setViewName("allAuthor");
		return m;
	}
	
	@GetMapping(value="/add")
	public ModelAndView addAuthors() {
		ModelAndView m = new ModelAndView();
		m.addObject("author",new Author());
		m.setViewName("addAuthor");
		return m;
	}
	
	@PostMapping(value="/add")
	public ModelAndView addAuthor(@Valid Author author, BindingResult br) {
		ModelAndView m = new ModelAndView();
		serviceAuthor.add(author);
		m.addObject("author",new Author());
		m.setViewName("addAuthor");
		return m;
	}
	
	@GetMapping(value="/adds")
	public ModelAndView addAuthoToBook(@RequestParam(value="id", required=true) int id) {
		ModelAndView m = new ModelAndView();
		m.addObject("id",id);
		m.addObject("authors",serviceAuthor.getAll());
		m.setViewName("addBooks");
		return m;
	}
	
	@GetMapping(value="/relationAdd")
	public ModelAndView addParametr(@RequestParam(value="idBook", required=true) int idBook,
			@RequestParam(value="idAuthor", required=true) int idAuthor) {
		ModelAndView m = new ModelAndView();
		Author a=serviceAuthor.findById(idAuthor);
		Book b = serviceBook.findById(idBook);
		a.getBooks().add(b);
		serviceAuthor.save(a);
		m.addObject("id",idBook);
		m.addObject("authors",serviceAuthor.getAll());
		m.setViewName("addBooks");
		return m;
	}
	
	@GetMapping(value="/getBookAuthor")
	public ModelAndView getAllAuthorsBook(@RequestParam(value="id", required=false) int id) {
		ModelAndView m = new ModelAndView();
		m.addObject("authors",serviceAuthor.getAll());
		m.setViewName("allAuthor");
		return m;
	}
	
	
}
