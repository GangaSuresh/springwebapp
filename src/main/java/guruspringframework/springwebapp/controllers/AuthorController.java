package guruspringframework.springwebapp.controllers;

import guruspringframework.springwebapp.repositories.AuthorRepository;
import guruspringframework.springwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors( Model model){ //this model goes to view
        model.addAttribute("authors",authorRepository.findAll());
       int a=5;
        return "authors/list";
    }
}
