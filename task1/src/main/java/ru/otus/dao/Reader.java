package ru.otus.dao;
import ru.otus.domain.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Reader {

    final private Question[] list;
    public  Reader(String filename) throws IOException {
        String buf1;
        String buf2;
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        list = new Question[5];
         try {
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str;
            int i = 0;
            while((str = reader.readLine())!=null) {
                buf1 = str;
                str = reader.readLine();
                buf2 = str;
                list[i] = new Question(buf1, buf2);
                i+=1;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Question[] getAllQuestion() { return list;}
}
