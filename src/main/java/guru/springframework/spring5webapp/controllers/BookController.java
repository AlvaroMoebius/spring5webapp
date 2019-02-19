package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.daos.BookDao;

@Controller
public class BookController {

		private BookDao bookDao;
		
		public BookController(BookDao bookDao) {
			this.bookDao = bookDao;
		}
		
		@RequestMapping
		public String getBooks(Model model) {
			model.addAttribute("books", bookDao.findAll());
			return "books";
		}
		
}
