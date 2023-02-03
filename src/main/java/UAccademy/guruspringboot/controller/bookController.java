package UAccademy.guruspringboot.controller;

import UAccademy.guruspringboot.repository.bookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bookController {

    private final bookRepository bookRep;

    public bookController(bookRepository bookRep) {
        this.bookRep = bookRep;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRep.findAll());

        return "books/bookList";
    }

}
