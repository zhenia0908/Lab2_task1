import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void Maker() throws IOException {
        String outputFileName = "file1";
        String[] array = {"one", "two", "three", "four", "four"};

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : array) {
                writter.write(value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Reader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file1"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // метод, который создает копию файла
    public void copyFile() throws IOException {


        File copied = new File("file2");
        try (InputStream input = new BufferedInputStream(new FileInputStream("file1"));
             OutputStream output = new BufferedOutputStream(new FileOutputStream("file2"))) {

            while (input.available() > 0) {
                int data = input.read();
                output.write(data);
            }
        }

    }


    public void howManyLines() throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("file2"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("How many lines: " + count);
    }

    public void howManySights() throws IOException {
        int characterCount = 0;

        try (FileReader fileReader = new FileReader("file2");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int character;
            while ((character = bufferedReader.read()) != -1) { //-1 = null for sights
                characterCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("How many sights: " + characterCount);
    }


    public void theLongestWord() {
        ArrayList<String> words = new ArrayList<>();
        int theBiggestWordLength = 0;
        int theBiggestWordIndex = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("file3"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                words.addAll(Arrays.asList(word));
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).length() > theBiggestWordLength) {
                        theBiggestWordLength = words.get(i).length();
                        theBiggestWordIndex = i;
                    }
                }
            }
            System.out.println("The biggest word is: " + words.get(theBiggestWordIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timesOfLongestWord() {
        int howManyTimes = 0;
        int theBiggestWordLength = 0;
        int theBiggestWordIndex = 0;
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("file3"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                words.addAll(Arrays.asList(word)); //из масссива создает коллекцию from String[] to ArrayList<String>
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).length() > theBiggestWordLength) {
                        theBiggestWordLength = words.get(i).length();
                        theBiggestWordIndex = i;
                    }
                }

            }
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).equals(words.get(theBiggestWordIndex))) {
                    howManyTimes++;
                }
            }
            System.out.println("Times of longest word: " + howManyTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void howManyWords() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("file3"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                words.addAll(Arrays.asList(word));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("How many words: " + words.size());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        main.Maker();//создает файл
        main.Reader();//читает файл
        main.copyFile();//делает копию
        main.howManyLines();
        main.howManySights();
        main.howManyWords();
        main.theLongestWord();
        main.timesOfLongestWord();
    }
}