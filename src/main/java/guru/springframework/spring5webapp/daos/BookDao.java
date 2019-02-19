package guru.springframework.spring5webapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.spring5webapp.model.Book;

public interface BookDao extends JpaRepository<Book, Long> {

}
