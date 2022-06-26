package ru.otus.reader;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Reader {

    String[] list;
    public  Reader(String filename) throws IOException {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        list = new String[5];
         try {
            //BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str;
            int i = 0;
            while((str = reader.readLine())!=null) {
                list[i] = str;
                i+=1;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] getList() { return list;}
}
