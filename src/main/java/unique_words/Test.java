package unique_words;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Test {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("src/main/java/unique_words/readFrom"), "UTF-8");
        LinkedHashMap<String,Integer> numberOfWords = new LinkedHashMap<>();
        for (String line : lines) {
            String[] words = StringUtils.split(line," ");
            for (String word : words) {
                word=word.replaceAll("[^A-Za-z0-9]","").toUpperCase();
                if (numberOfWords.containsKey(word)) {
                    numberOfWords.put(word, numberOfWords.get(word) + 1);
                } else {
                    numberOfWords.put(word, 1);
                }
            }
        }
        FileUtils.write(new File("src/main/java/unique_words/countOfUniqueWords"),
                "Count of unique words -> " +numberOfWords.size(),"UTF-8");


    }

}
