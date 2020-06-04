package ai.brace;

import ai.brace.domain.Book;
import ai.brace.domain.TextArray;
import ai.brace.json.MergeBooks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Gson gson;

    public static void main(String[] args) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Book a1 = taskOne();
            Book book = taskTwo(a1);
            taskThree(book);
            taskFour(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void performTextTask(Book book, String task) {
        System.out.println(task);
        book.getTextArray().forEach(text -> System.out.println(text.getTextdata()));
        System.out.println();
    }

    protected static Book taskOne() throws IOException {
        Book a1 = readJsonFile("a1.json");
        performTextTask(a1, "Task 1");
        return a1;
    }

    protected static Book taskTwo(Book a1) throws IOException {
        Book book = new MergeBooks().mergeBooks(a1, readJsonFile("a2.json"));
        performTextTask(book, "Task 2");
        return book;
    }

    /**
     * Count the words in the text held in the {@linkplain List} of {@linkplain TextArray}
     *
     * @param book {@linkplain Book}
     */
    protected static void taskThree(Book book) {
        List<String> list = book.getTextArray().stream().map(text -> text.getTextdata() + " ").collect(Collectors.toList());
        String text = String.join("", list);
        Stream<String> stream = Stream.of(text.toLowerCase().split("\\s+"));
        Map<String, Long> map = stream.collect(Collectors.groupingBy(txt -> txt.replaceAll("[^a-zA-Z0-9]+", ""), Collectors.counting()));
        System.out.println("Task 3");
        map.forEach((key, value) -> System.out.println("(" + key + ") : " + value));
        System.out.println();
    }

    /**
     * This takes the name of the file in the resources directory and reads it in as a {@link Book}
     *
     * @param filename the json file
     * @return {@link Book}
     * @throws IOException
     */
    public static Book readJsonFile(String filename) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("json-manipulation/src/main/resources/" + filename));
        return gson.fromJson(reader, Book.class);
    }

    public static void taskFour(Book book) throws IOException {
        System.out.println("Task 4");
        String jsonString = gson.toJson(book);
        System.out.println(jsonString);
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.json"));
        writer.write(jsonString);
        writer.close();
    }
}
