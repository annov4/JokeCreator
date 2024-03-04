import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JokeCreator {
    public static void getFiles(File dirName) throws IOException { //dirName - корневая папка для поиска
        if (dirName.isDirectory()) { //является ли dirName папкой
            File[] files = dirName.listFiles(); //получим все файлы, которые лежат внутри папки
            if (files != null) {
                for (File file : files) { //проверяем каждый файл
                    if (file.isDirectory()) { // если файл является папкой
                        getFiles(file); // функция вызывает сама себя
                        addJokeFile(file);// жобавляем в каждую подпапку joke.java
                    }
                }
            }
        }
    }

    public static void addJokeFile(File dirName) throws IOException {
        File jokeFile = new File(dirName, "joke.java");
        //нужно ли проверять, есть ли этот файл уже в данной папке?
        //if (!jokeFile.exists()) {
        jokeFile.createNewFile();
        FileWriter fileWriter = new FileWriter(jokeFile);
        fileWriter.write("public class Joke " +
                    "{\npublic static void main(String[] args) " +
                    "{\n System.out.println(\"Hello, World!\");\n}\n}");
        fileWriter.flush();
        fileWriter.close();
    }
}
