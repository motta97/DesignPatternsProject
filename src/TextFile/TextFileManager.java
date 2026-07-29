package TextFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;


public  class TextFileManager {

    private static TextFileManager instance;

    private final Path dataDirectory;

    private TextFileManager() {

        dataDirectory = Path.of("data");

        try {
            Files.createDirectories(dataDirectory);

        } catch (IOException exception) {

            throw new IllegalStateException(
                    "Could not create the data directory.",
                    exception
            );
        }
    }

    public static TextFileManager getInstance() {

        if (instance == null) {
            instance = new TextFileManager();
        }

        return instance;
    }

    public List<String> readAll(String fileName) {

        Path file = prepareFile(fileName);

        try {
            return Files.readAllLines(
                    file,
                    StandardCharsets.UTF_8
            );

        } catch (IOException exception) {

            throw new IllegalStateException(
                    "Could not read " + fileName + ".",
                    exception
            );
        }
    }

    public void writeAll(String fileName, List<String> lines) {

        Path file = prepareFile(fileName);

        try {
            Files.write(
                    file,
                    lines,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );

        } catch (IOException exception) {

            throw new IllegalStateException(
                    "Could not write " + fileName + ".",
                    exception
            );
        }
    }

    private Path prepareFile(String fileName) {

        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException(
                    "File name is required."
            );
        }

        Path file = dataDirectory.resolve(fileName);

        try {
            if (Files.notExists(file)) {
                Files.createFile(file);
            }

            return file;

        } catch (IOException exception) {

            throw new IllegalStateException(
                    "Could not create " + fileName + ".",
                    exception
            );
        }
    }
}