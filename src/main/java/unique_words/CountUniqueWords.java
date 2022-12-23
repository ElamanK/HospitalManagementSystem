package unique_words;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.*;


public class CountUniqueWords {
    public static void main(String[] args) throws IOException {

        File myFile = new File("src/main/java/unique_words/myFile");
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(myFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedHashMap<String,Integer> numberOfWords = new LinkedHashMap<>();
        if (lines != null) {
            for (String line : lines) {
                String[] words = StringUtils.split(line, " ");
                for (String word : words) {
                    word = word.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
                    if (numberOfWords.containsKey(word)) {
                        numberOfWords.put(word, numberOfWords.get(word) + 1);
                    } else {
                        numberOfWords.put(word, 1);
                    }
                }
            }
        }
        FileUtils.write(myFile,
                "Count of unique words -> " +numberOfWords.size(),"UTF-8",true);

    }


}
