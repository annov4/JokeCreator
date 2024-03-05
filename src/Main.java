
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();// считываем путь к папке с консоли
        Path dirPath = Path.of(dirName);
        JokeCreator.getFiles(dirPath);
    }
}
/*
/Users/anastasianovikova/Desktop/joke
 */