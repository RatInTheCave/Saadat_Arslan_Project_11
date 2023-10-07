package Complex_Project;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void saveToFile(String text, String fileName){
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < text.length(); i++) {
            try {
                fw.write(text.charAt(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFromFile(String fileName){
        int ch;
        StringBuilder result = new StringBuilder();
        FileReader fr = null;
        try
        {
            fr = new FileReader(fileName);
        }
        catch (FileNotFoundException fe){
            System.out.println("File not found");
        }
        while (true) {
            try {
                if ((ch = fr.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result.append((char) ch);
        }
        return result.toString();
    }
}
