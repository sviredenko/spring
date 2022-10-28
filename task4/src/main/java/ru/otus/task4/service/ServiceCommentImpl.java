package ru.otus.task4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.task4.dao.CommentDao;
import ru.otus.task4.domain.Comment;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Service
public class ServiceCommentImpl implements ServiceComment{

    CommentDao commentDao;

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
}
