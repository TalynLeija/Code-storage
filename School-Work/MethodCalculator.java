import java.util.Scanner;

public class MethodCalculator {
    public static int addition(int x,int y ,int n){
        int i;
        int results = x;

        //i is 1 so as not to add extra
        for(i=1;i<=n;++i){
            // adds y to x n times
            results+=y;
        }
        return results;
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int xnum =input.nextInt();
        int ynum =input.nextInt();
        int nnum =input.nextInt();
        //method addition returns 11 in print statement
        System.out.println(addition(xnum,ynum,nnum));

        input.close();
    }
}
