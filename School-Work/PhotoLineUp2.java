import java.util.Scanner;
import java.util.ArrayList;
// import java.util.Arrays;

public class PhotoLineUp2 {

   // Write method to create and output all permutations of the list of names.

    public static String[][] getPermute(ArrayList<String> nameL, int num) {
        String[][] layer = new String[nameL.size()-num][nameL.size()];
        int count = 0;

        for(int i=num;i<=nameL.size()-num;++i){
            layer[count]=swap(nameL,num,i);
            count++;        
        }
        return layer;

    }
    
    public static int factorial(int n){
        int i,fact=1;  
        int number=n;//It is the number to calculate factorial    
        for(i=1;i<=number;i++){    
            fact=fact*i;    
        }
        return fact;
    }

    public static ArrayList<String> copyArray(ArrayList<String> a){
        ArrayList<String> b= new ArrayList<String>();
        for(int i=0;i<a.size();++i){
            b.add(a.get(i));
        }
        return b;
    }
   
    public static String[] swap(ArrayList<String> nameL, int num1, int num2) {
        String temp;
        String[] NewArray = new String[nameL.size()];
        for(int i=0;i<nameL.size();++i){
            NewArray[i]=nameL.get(i);
        }
        temp=NewArray[num1];
        NewArray[num1]=NewArray[num2];
        NewArray[num2]=temp;   
        return NewArray;
    }


    public static void printAllPermutations(ArrayList<String> nameL, int L){
        String[][] PermuteL;
        if(L==nameL.size()-2){
            PermuteL=getPermute(nameL, nameL.size()-2);

            for(int i=0;i<nameL.size()-1;i++){
                for(int j=0;j<nameL.size();j++){
                    System.out.print(PermuteL[i][j]+", ");
                }
                System.out.println(PermuteL[nameL.size()-2][nameL.size()-1]);

            }     
        }
        else{
            PermuteL=getPermute(nameL, L+1);
            for(int i=0;i<PermuteL.length;i++){
                for(int j=0;j<nameL.size();j++){
                    getPermute(nameL, L+1);
                }

            }              
        }

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String name;
        int stop=0;
        boolean gate=true;

        while(gate){
            try{
                stop=scnr.nextInt();
                if(stop==-1){
                    gate=false;
                }
                else{
                    continue;
                }

            }
            catch(Exception e){
                name=scnr.next();
                nameList.add(name);
                permList.add(name);
            }            
        }

        //Julia Lucas Mia -1
        //Julia Lucas Mia Talyn -1
        //a b c d -1

        printAllPermutations(nameList, 1);
        // System.out.println(Arrays.toString(swap(nameList,0,2)));
        // System.out.println(factorial(2));
        // String[][] doubleList = getPermute(nameList, 1);
        // for(int i=0;i<doubleList.length;++i){
        //     System.out.println(Arrays.toString(doubleList[i]));
        // }
        // System.out.println(Arrays.toString(doubleList[0]));
        scnr.close();
    }
}
