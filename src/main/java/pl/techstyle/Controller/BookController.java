package pl.techstyle.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.techstyle.Service.BookService;
import pl.techstyle.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping(value="/all")
	public ModelAndView all() {
		ModelAndView m = new ModelAndView();
		m.addObject("books",service.getAll());
		m.setViewName("allBook");
		return m;
	}
	
	@GetMapping(value="/add")
	public ModelAndView addGet() {
		ModelAndView m = new ModelAndView();
		m.addObject("book",new Book());
		m.setViewName("addBook");
		return m;
	}
	@PostMapping(value="/add")
	public ModelAndView addBook(@Valid Book book, BindingResult br) {
		ModelAndView m = new ModelAndView();
		service.add(book);
		m.addObject("book",new Book());
		m.setViewName("addBook");
		return m;
	}
}
