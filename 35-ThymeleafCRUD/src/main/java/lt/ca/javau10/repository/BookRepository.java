package lt.ca.javau10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ca.javau10.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
