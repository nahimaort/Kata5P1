package kata5;

import java.util.List;

public class Kata5 {
    public static void main(String[] args) {
        String emailFile = "email.txt";
        List<String> emailList = MailListReader.read(emailFile);
        InsertData app = new InsertData();
        for (String mail : emailList) {
            app.insert(mail);
        }
        System.out.println("Datos insertados.");
    }
}
