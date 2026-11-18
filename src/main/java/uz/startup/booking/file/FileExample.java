package uz.startup.booking.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileExample {
    //Food fod = new Bread();
    //Iteratorda
    //Path
    public static void main(String[] args) throws IOException {
        //File
        //Files Path
        //FileInputStream
        //BufferedInputStream
        //C://doniyor/text.txt

        Path path = Path.of("tasks.txt");
        Path fileName = path.getFileName();
        Path absolutePath = path.toAbsolutePath().normalize();
        Path parent = path.getParent();
        System.out.println(absolutePath);
        System.out.println(fileName);
        System.out.println(parent);

        List<String> texts = List.of("Hello1", "Hello2", "Hello3");
        Files.writeString(path, "Hello java");

        Files.write(path, texts);

//        String text = Files.readString(absolutePath);
//        System.out.println(text);
//        String s = Files.readString(path);
//        System.out.println(s);
//        List<String> list = Files.readAllLines(path);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println((i + 1) + ". " + list.get(i));
//        }

//        boolean exists = Files.exists(path); //File bormi degan narsa
//        System.out.println(exists);
//        Path path1 = Path.of("src");
//        Path absolutePath1 = path1.toAbsolutePath();
//        boolean data = Files.isDirectory(absolutePath1);
//        System.out.println(data);


//        try (Stream<String> lines = Files.lines(path)) {
//            //logic
//        } catch (Exception e) {
//
//        }
//        BufferedReader reader = null;
//        try {
//            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//        } finally {
//            if (reader != null) {
//                reader.close();
//            }
//        }
        //Files - UTF-8

    }
}
