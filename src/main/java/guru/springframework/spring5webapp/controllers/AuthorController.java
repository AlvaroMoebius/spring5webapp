package guru.springframework.spring5webapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.daos.AuthorDao;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorDao authorDao;
	
	@RequestMapping("/authors")
	public String getAuthors(Model model){
		model.addAttribute("authors", authorDao.findAll());
		return "authors";
	}
	
	

}
