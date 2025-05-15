package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();

            book.setTitle("Great Gatsby");
            book.setAuthor("F. Scott Fitzgerald");
            book.setDescription("Set in the Jazz Age on Long Island, "
                    + "near New York City, the novel depicts first-person narrator "
                    + "Nick Carraway's interactions with Jay Gatsby ...");
            book.setPrice(BigDecimal.valueOf(19.99));
            book.setIsbn("9780333791035");

            bookService.save(book);

            System.out.println(bookService.findAll());
        };
    }
}
