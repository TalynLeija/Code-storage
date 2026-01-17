import java.io.*;
import java.util.*;
public class Lab{
    public static void main(String[]args)throws IOException{
        int [] a = new int[50];
        fill(a);
        PrintWriter in = new PrintWriter("Start.txt");
        for(int i = 0; i<a.length; i++){
            in.println(a[i]);
        }
        in.close();
        bubbleSort(a);
        PrintWriter out = new PrintWriter("Output.txt");
        for(int i = 0; i<a.length; i++){
            out.println(a[i]);
        }
        out.close();
    }
    public static void bubbleSort(int []a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j<a.length -1 - i; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j]= a[j+1];
                    a[j+1]= temp;
                }
            }
        }
    }
    public static void fill(int a[]){
        Random rand = new Random();
        for(int i = 0; i<a.length; i++){
            a[i] = rand.nextInt(-500,500);
        }
    }
    public static void print(int []a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void bubbleSortR(int[]a){
        bubbleSortR(a,a.length,0);
    }
    private static void bubbleSortR(int[]a, int unsorted, int j){
        int temp;
        if(j<unsorted -1){
            if(a[j+1]<a[j]){
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
            bubbleSortR(a, unsorted, j+1);
        }
        else if(unsorted > 1){
            bubbleSortR(a, unsorted - 1, 0);
        }
    }

    public static double coefficient(long[] a, double avg){
        double standardDeviation = 0.0;
        for(int i = 0; i < a.length; i++){
            standardDeviation += Math.pow((double) a[i] - avg, 2);
           
        }
        standardDeviation /= a.length ;
        standardDeviation = Math.sqrt(standardDeviation);
        return standardDeviation / avg;
    }
    
    public static double average(long[] a){
        long sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return (float) sum / a.length;
    }
}
