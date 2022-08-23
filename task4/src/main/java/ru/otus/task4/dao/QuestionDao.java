package ru.otus.task4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.task4.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:settings.properties")
public class QuestionDao {
    private final String filename;


    public QuestionDao(@Value("${filename}") String filename){
        this.filename = filename;
    }
    public List<Question> getAllQuestion() {
        List<Question> list;
        String buf1;
        String buf2;
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        list = new ArrayList<>();
        try {
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str;
            int i = 0;
            while((str = reader.readLine())!=null) {
                buf1 = str;
                str = reader.readLine();
                buf2 = str;
                list.add(i,new Question(buf1, buf2));
                i+=1;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
