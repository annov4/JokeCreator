import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class JokeCreator {
    public static void getFiles(Path dirPath) throws IOException { //Path.dir коренная папка
        Files.walkFileTree(dirPath, new FileVisitor<Path>() { //обрабатываем дерево каталогов
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException { //включает в себя набор методов, которые следует выполнить перед посещением текущей поддиректории.
                return FileVisitResult.CONTINUE;// Чтобы исследовать каталог необходимо вернуть FileVisitResult.CONTINUE
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException { //набор методов, которые следует выполнить во время посещения текущего файла
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) { //Данный метод может пригодиться при ошибке доступа к файлу
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException { //все, что необходимо сделать после посещения директории, нужно перечислить в рамках перегрузки данного метода.
                addJokeFile(dir);//добавляем файл joke.java в каждую папку
                return FileVisitResult.CONTINUE;
            }

        });
    }

    public static void addJokeFile(Path dirPath) throws IOException {
        Path path = dirPath.resolve("joke.java");//преобразует последовательность путей или сегментов путей в абсолютный путь
        Files.createFile(path);
        Files.write(path, ("public class Joke " +
                "{\n public static void main(String[] args) " +
                "{\n System.out.println(\"Hello, World!\");\n}\n}").getBytes());

    }
}

