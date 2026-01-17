import java.util.Scanner;

public class MyStackATester {
    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        MyStackA st = new MyStackA(4);
        while(!st.isFull()){
            System.out.print("Enter String: ");
            String val = scnr.next();
            st.push(val);
        }
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

        scnr.close();

    }
}
