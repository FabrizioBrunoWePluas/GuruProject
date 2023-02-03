package UAccademy.guruspringboot.controller;

import UAccademy.guruspringboot.repository.authorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class authorController {
    private final authorRepository authorRep;

    public authorController(authorRepository authorRep) {
        this.authorRep = authorRep;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRep.findAll());

        return "authors/authorList";
    }
}
