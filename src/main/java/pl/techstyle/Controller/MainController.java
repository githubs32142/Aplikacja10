package pl.techstyle.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping(value="/")
	public ModelAndView getIndex() {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}
}
