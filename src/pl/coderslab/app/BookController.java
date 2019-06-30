package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788328324800", "Java. Podstawy (wydanie X)", "Cay S. Horstmann", "Helion", "programming");
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return memoryBookService.getList();
    }

    @RequestMapping("/{id}")
    public Book getBook(@PathVariable("id") long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        return memoryBookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable("id") long idToDelete) {
        return memoryBookService.deleteById(idToDelete);

    }

}