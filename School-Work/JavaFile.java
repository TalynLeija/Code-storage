import java.util.Scanner;
import java.io.*;

public class JavaFile {
    public static void main(String[]args)throws IOException{
        // Reading a File
        Scanner input = new Scanner(new File("Jmonke.txt"));
        while(input.hasNext()){
            String Line = input.nextLine();
            System.out.println(Line);
        }

        // Writeing in a File
        File Jmonke = new File("Jmonke.txt");//you can replace .txt with .doc or . httml
        PrintWriter pr = new PrintWriter(Jmonke);
        pr.println("the names monke j monke");
        pr.close();

    }
}