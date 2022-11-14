package ru.otus.task4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.CommentDao;
import ru.otus.task4.domain.Comment;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Service
public class ServiceCommentImpl implements ServiceComment{

    CommentDao commentDao;

    @Transactional
    @Override
    public void getAllCommnetsById(){
        System.out.println("Please enter id of book");
        Scanner in = new Scanner(System.in);
        long id = in.nextInt();
        List<Comment> res =  this.commentDao.getCommentByBookId(id);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i).getComment());
        }
        return;
    }
    @Transactional
    @Override
    public void putCommentById(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter book id");
        Long id = Long.parseLong(in.nextLine());
        System.out.println("Enter comment");
        String str = in.nextLine();
        Comment comment = new Comment(0,str);
        this.commentDao.putCommentByBookId(id, comment);
    }
}
