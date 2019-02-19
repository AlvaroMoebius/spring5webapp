package guru.springframework.spring5webapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.spring5webapp.model.Author;

public interface AuthorDao extends JpaRepository<Author, Long> {
	

}
