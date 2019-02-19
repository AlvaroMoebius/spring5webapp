package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.daos.AuthorDao;
import guru.springframework.spring5webapp.daos.BookDao;
import guru.springframework.spring5webapp.daos.PublisherDao;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	//@Autowired
	private AuthorDao authorDao;
	
	//@Autowired
	private BookDao bookDao;
	
	@Autowired
	private PublisherDao publisherDao;
	
	// En teoría, hasta donde sé, ésto hace las veces de @Autowired, por eso está comentado @Autowired arriba.
	// En pruebas.
	public DevBootstrap(AuthorDao authorDao, BookDao bookDao) {
		this.authorDao = authorDao;
		this.bookDao = bookDao;
	}
	
	
	private void initData() {
		
		// Publicadores
		
		Publisher publisher1 = new Publisher("Harper Collins Iberica","Calle de Núñez de Balboa, 56, 28001 Madrid");
		Publisher publisher2 = new Publisher("Gigamesh", "Calle Bailén, 8, 8010 Barcelona");
		publisherDao.save(publisher1);
		publisherDao.save(publisher2);
		
		
		// Alvaro creación de autor y libro
		Author alvaro = new Author("Alvaro", "Gonzalez");
		Book libroAlvaro1 = new Book("La persistencia del ser", "1111", publisher1);
		alvaro.getBooks().add(libroAlvaro1);
		libroAlvaro1.getAuthors().add(alvaro);
		
		// Llamada al DAO apra su guardado
		authorDao.save(alvaro);
		bookDao.save(libroAlvaro1);
		
		
		// Carlos creación de autor y libro
		Author carlos = new Author("Carlos", "Ramirez");
		Book libroCarlos1 = new Book("Dessarollo de interfaces humanas en Python 3.6", "2222", publisher2);
		carlos.getBooks().add(libroCarlos1);
		libroCarlos1.getAuthors().add(carlos);
		
		// Llamada al DAO para su guardado
		authorDao.save(carlos);
		bookDao.save(libroCarlos1);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
		
	}
}
