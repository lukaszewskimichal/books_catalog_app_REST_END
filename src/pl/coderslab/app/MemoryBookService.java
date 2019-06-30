package pl.coderslab.app;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788328324800", "Java. Podstawy (wydanie X)", "Cay S. Horstmann", "Helion", "programming"));
        list.add(new Book(2L, "9788328345768", "Java. Efektywne programowanie", "Joshua Bloch", "Helion", "programming"));
        list.add(new Book(3L, "9788328311190", "Java EE 6. Programowanie aplikacji WWW", "Krzysztof Rychlicki-Kicior", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBookById(long id) {
        Book book = null;
        try {
            book = this.list.stream()
                    .filter(x -> x.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new Exception("nie znaleziono książki o wskazanym id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book book) {
        this.list.add(book);
        return book;
    }

    public List<Book> deleteById(long id) {
        List<Book> temp = this.list.stream()
                .filter(x -> x.getId() != id)
                .collect(Collectors.toList());

        this.list = temp;
        return this.list;
    }
}
