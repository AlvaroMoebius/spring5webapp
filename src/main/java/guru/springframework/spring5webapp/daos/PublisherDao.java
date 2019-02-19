package guru.springframework.spring5webapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.spring5webapp.model.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Long> {

}
