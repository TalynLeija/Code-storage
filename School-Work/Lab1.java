import java.io.*;
import java.util.*;
import java.text.*;
public class Lab1{
    public static void main(String[]args)throws IOException{
        PrintWriter out = new PrintWriter("Output.txt");
        /* The averageTime Method has an input that will match the size of the array, then it
        will call on the sortPlusTime method which makes the array and put the size based on the input,
        fills the array(fills it everytime so its different), then sorts it 50 times, "
        counting the time taken for each sort then adding it to a placeHolder,
        then eventually returning the placeHolder/50
        It currently uses the Iterative BubbleSort, gotta fix Recursive one.
        */
        out.println("Size   Avg Count   Coef Count   Avg Time  Coef Time");
        out.println("_________________________________________________");        
        for(int i=200;i<=1000;i+=200){
            // System.out.println(i);
            // System.out.println(Output_data(i));
            out.println(Output_data(i));
        }



        // int n = 200;
        // int [] a1 = new int[n];
        // fill(a1);        
        // long Time = averageTime(n,a1);
        // // double Count = averageCount(a1);
        // out.println(n+"  "+"Count"+"                  "+Time);
        // n = 400;
        // int [] a2 = new int[n];
        // fill(a2); 
        // Time = averageTime(n,a2);
        // out.println(n+"   "+"                       "+Time);
        // n = 600;
        // int [] a3 = new int[n];
        // fill(a3); 
        // Time = averageTime(n,a3);
        // out.println(n+"   "+"                       "+Time);
        // n = 800;
        // int [] a4 = new int[n];
        // fill(a4); 
        // Time = averageTime(n,a4);
        // out.println(n+"   "+"                       "+Time);
        // n = 1000;
        // int [] a5 = new int[n];
        // fill(a5); 
        // Time = averageTime(n,a5);
        // // Count = averageCount(a5);
        // out.println(n+"   "+"                      "+Time);
        out.close();
    }
    public static long bubbleSort(int []a){
        int criticalcount = 0;
        for(int i = 0; i < a.length; i++){
            // checks condition
            criticalcount++;
            for(int j = 0; j<a.length -1 - i; j++){
                // checks condition
                criticalcount+=3;
                if(a[j] > a[j+1]){
                    //if statement
                    criticalcount+=2;
                    int temp = a[j];
                    //declare and initialization of j
                    criticalcount+=2;
                    a[j]= a[j+1];
                    a[j+1]= temp;
                    //swaping variables
                    criticalcount+=4;
                }
                //iterate j
                criticalcount+=2;
            }
            //declaration and initialization of j
            criticalcount+=2;
            //iterate i
            criticalcount+=2;
        }
        return criticalcount;
    }

    public static void fill(int a[]){
        Random rand = new Random();
        for(int i = 0; i<a.length; i++){
            a[i] = rand.nextInt(-9999,9999);
        }
    }
    public static void print(int []a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void bubbleSortR(int[]a){
        bubbleSortR(a, a.length, 0);
    }
    private static void bubbleSortR(int[] a, int unsorted, int j){
        int temp;
        if(j < unsorted - 1){
            if(a[j + 1] < a[j]){
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
            bubbleSortR(a, unsorted, j + 1);
        }
        else if(unsorted > 1){
            bubbleSortR(a, unsorted - 1, 0);
        }
    }

    // public static double coefCount(int[][] a, double avg){
    //     double standardDeviation = 0.0;
    //     for(int j = 0; j < a.length; j++){
    //         for(int i = 0; i < a[0].length; i++){
    //             standardDeviation += Math.pow((double) a[j][i] - avg, 2);
           
    //         }
    //     }
    //     standardDeviation /= a.length ;
    //     standardDeviation = Math.sqrt(standardDeviation);
    //     return standardDeviation / avg;
    // }

    public static double coefficent(long[] a, double avg){
        double standardDeviation = 0.0;
        for(int i = 0; i < a.length; i++){
            standardDeviation += Math.pow((double) a[i] - avg, 2);
           
        }
        standardDeviation /= a.length ;
        standardDeviation = Math.sqrt(standardDeviation);
        return standardDeviation / avg;
    }

    public static double Sum(int[] a){
        double sum = 0.0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    // public static long sortPlusTime(int n, int[] a){
    //     long start = System.nanoTime();
    //     bubbleSort(a);
    //     long end = System.nanoTime();
    //     return end - start;
    // }

    public static String Output_data(int n)throws IOException{
        // PrintWriter out = new PrintWriter("Output.txt");
        long time = 0;
        double avgCount = 0.0;
        // double avgCount2 = 0.0;
        double coefC = 0.0;
        double coefT = 0.0;
        long[] Countarray = new long[50];
        long[] timearray = new long[50];
        for(int i=0; i< 50;i++){
            int[] a = new int[n];
            fill(a);
            long critcount=0;
            long current_time = 0;
            long start = System.nanoTime();
            critcount+=bubbleSort(a);
            long end = System.nanoTime();
            avgCount+=critcount;
            Countarray[i]=critcount;
            current_time = end - start;
            time += current_time;
            timearray[i]=current_time;
        }
        avgCount/=50;
        time/=50;
        coefC=coefficent(Countarray, avgCount);
        coefT=coefficent(timearray,time);

        DecimalFormat df = new DecimalFormat(".##");
        return n+" \t"+df.format(avgCount)+"\t  "+df.format(coefC)+"%\t  "+time+"\t  "+df.format(coefT)+"%";
    }
}