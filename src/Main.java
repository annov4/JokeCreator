

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();// считываем путь к папке с консоли
        Files.walkFileTree(Paths.get(dirName), new JokeFileVisitor());
    }
}
/*
/Users/anastasianovikova/Desktop/joke
 */