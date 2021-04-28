package guruspringframework.springwebapp.bootstrap;

import guruspringframework.springwebapp.domain.Author;
import guruspringframework.springwebapp.domain.Book;
import guruspringframework.springwebapp.domain.Publisher;
import guruspringframework.springwebapp.repositories.AuthorRepository;
import guruspringframework.springwebapp.repositories.BookRepository;
import guruspringframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);



        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher Ganga=new Publisher("Ganga","gachibowli","Hyderabad","Telengana","19765");
        ddd.setPublisher(Ganga);
        Ganga.getBooks().add(ddd);
        publisherRepository.save(Ganga);

        noEJB.setPublisher(Ganga);
        Ganga.getBooks().add(noEJB);
        publisherRepository.save(Ganga);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of books for ganga: " + Ganga.getBooks().size());
    }
}