package UAccademy.guruspringboot.bootstrap;

import UAccademy.guruspringboot.entity.Author;
import UAccademy.guruspringboot.entity.Book;
import UAccademy.guruspringboot.entity.Publisher;
import UAccademy.guruspringboot.repository.authorRepository;
import UAccademy.guruspringboot.repository.bookRepository;
import UAccademy.guruspringboot.repository.publisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {

    private final  authorRepository AuthorRepository;
    private final  bookRepository BookRepository;
    private final publisherRepository PublisherRepository;

    public bootstrapData(authorRepository authorRepository, bookRepository bookRepository, publisherRepository publisherRepository) {
        AuthorRepository = authorRepository;
        BookRepository = bookRepository;
        PublisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domanin Driven Designe", "123456");
        Publisher Mondandori = new Publisher();
        Mondandori.setName("Mondadori");
        Mondandori.setCity("Milano");
        Mondandori.setState("Italia");

        PublisherRepository.save(Mondandori);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(Mondandori);
        Mondandori.getBooks().add(ddd);

        AuthorRepository.save(eric);
        BookRepository.save(ddd);
        PublisherRepository.save(Mondandori);


        Author rod = new Author("Rod", "Martin");
        Book rrr = new Book("Road Roar Rammarro", "654321");
        rod.getBooks().add(rrr);
        rrr.getAuthors().add(rod);
        rrr.setPublisher(Mondandori);
        Mondandori.getBooks().add(rrr);

        AuthorRepository.save(rod);
        BookRepository.save(rrr);
        PublisherRepository.save(Mondandori);


        System.out.println("Strated in Bootstrap");
        System.out.println("Number of Books:" + BookRepository.count());
        System.out.println("Number of Publisher:" + PublisherRepository.count());
        System.out.println("Publisher number of books:" + Mondandori.getBooks().size());
    }
}
