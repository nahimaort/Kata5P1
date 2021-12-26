package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5.Mail;

public class MailListReader {
    public static List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while (true) {
                String line = reader.readLine();
                if (line == null) 
                    break;
                if (Mail.isMail(line))
                    list.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR MailListReader::read (FileNotFoundException)" + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR MailHistogramReader::read (IOException)" + e.getMessage());
        }
        return list;
    }
}
