
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();// считываем путь к папке с консоли
        File folder = new File(dirName);
        JokeCreator.getFiles(folder);
    }
}
/*
/Users/anastasianovikova/Desktop/joke
 */