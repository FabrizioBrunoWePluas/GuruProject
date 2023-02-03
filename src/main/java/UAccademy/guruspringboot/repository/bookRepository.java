package UAccademy.guruspringboot.repository;

import UAccademy.guruspringboot.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<Book,Long> {
}
