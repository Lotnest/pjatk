package exercise.ex10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class FileInputTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lotne\\Desktop\\test.txt");
        HashMap<Character, Integer> characters = new HashMap<>();
        while (fileInputStream.available() > 0) {
            char c = (char) fileInputStream.read();
            if (characters.containsKey(c)) {
                characters.put(c, characters.get(c) + 1);
            } else {
                characters.put(c, 1);
            }
        }
        System.out.println(characters);
    }
}
