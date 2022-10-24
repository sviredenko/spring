package ru.otus.task4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.BookDao;
import ru.otus.task4.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ServiceBookImpl implements ServiceBook{

   @Autowired
    BookDao dao;

   @Override
   public int getNumberOfBook(){
       System.out.println(dao.count());
       return dao.count();
   }
    @Override
    public void getAllBook(){
        List<Book> books = dao.getAllBooks();
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).getId() + "." + books.get(i).getBookName());
        }
    }

    @Override
    public void deleteBookById(Long id) {
        this.dao.deleteBookById(id);
    }

    @Override
    public void getBookById(Long Id){
        Optional<Book> book = this.dao.getBookById(Id);
        book.ifPresent(buf -> System.out.println(buf.getId() + "." + buf.getBookName()));

    }

    @Override
    public void saveBook(){
        System.out.println("Enter ypur book");
        Scanner in = new Scanner(System.in);
        String bookName = in.nextLine();
        String authorName = in.nextLine();
        String genreName = in.nextLine();
        List<String> ls1 = new ArrayList<String>();
        ls1.add("wwgew");
        List<String> ls2 = new ArrayList<String>();
        ls2.add("wwgew");
        this.dao.saveBook(new Book());

    }


}
