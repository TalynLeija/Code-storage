import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class SortingAlgo {

    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;++i){
            for(int j=0;j<array.length-1-i;++j){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for(int i=0;i<array.length;++i){
            int smallest=0+i;
            for(int j=0+i;j<array.length;++j){
                if(array[j]<array[smallest]){
                    smallest=j;
                }
                
            }
            int temp = array[i];
            array[i]=array[smallest];
            array[smallest]=temp;           
        }
    }

    public static void insertionSort(int[] array){
        int j=0;
        for(int i=1;i<array.length;++i){
            j = i;
            while(j>0 && (array[j] < array[j-1])){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                --j;
            }            
        }

    }

    public static void mergeSort(int[] array,int i,int k){
        int j=0;

        if(i<k){
            j=(i+k)/2;
            mergeSort(array, i, j);
            mergeSort(array, j+1, k);

            merge(array, i, j, k);            
        }


    }

    public static void merge(int[] array,int i,int j,int k){
        int mergeSize = k-i+1;
        // merge list
        int[] mergeArray = new int[mergeSize];
        //
        int mergePosition;
        //
        int leftPos;
        int rightPos;

        mergePosition=0;
        leftPos=i;
        rightPos=j+1;

        while(leftPos<=j && rightPos <= k){
            if(array[leftPos]<array[rightPos]){
                mergeArray[mergePosition]=array[leftPos];
                leftPos++;
            }
            else{
                mergeArray[mergePosition]=array[rightPos];
                rightPos++;
            }
            mergePosition++;
        }

        while(leftPos<=j){
            mergeArray[mergePosition]=array[leftPos];
            leftPos++;
            mergePosition++;         
        }

        while(rightPos<=k){
            mergeArray[mergePosition]=array[rightPos];
            rightPos++;
            mergePosition++;         
        }

        for(mergePosition=0;mergePosition<mergeSize;++mergePosition){
            array[i+mergePosition]= mergeArray[mergePosition];
        }
    }

    public static void quickSort(int[] array, int first, int last){
        if(first>=last){
            return;
        }

        int p = partition(array,first,last);

        // left call
        quickSort(array,first,p-1);
        // right call
        quickSort(array,p+1,last);
    }

    public static int partition(int[] array, int first, int last){
        int pivot = array[last];
        int i = first-1;

        for(int j=first;j<last;++j){
            if(array[j]<=pivot){
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[last];
        array[last]=temp;
        return i + 1;
    }


    public static void printarray(int[] a){
        for(int j=0;j<a.length-1;++j){
            System.out.print(a[j]+", ");
        }
        System.out.println(a[a.length-1]);            
    }

    public static int[] copyarray(int[] array){
        int[] newarray = new int[array.length];
        for(int i=0;i<array.length;++i){
            newarray[i]=array[i];
        }
        return newarray;
    }

    public static int[] ArrayConverter(ArrayList<Integer> array){
        int[] newarray = new int[array.size()];
        for(int i=0;i<array.size();++i){
            newarray[i]=array.get(i);
        }
        System.out.println("Data scan completed");
        return newarray;
    }
    public static void main(String[]args)throws IOException{
        // this is a test sample
        // int[] a = {34,9,18,6,50,25,19,26,1,40};
        // the code below creates and array from Data.txt
//"C:/Users/Talyn/Documents/VScode/Main/JavaProjects/Data.txt"
        ArrayList<Integer> fileData = new ArrayList<>();
        // If you test the data.txt I recomend you change the path
        Scanner input = new Scanner(new File("C:/Users/Talyn/Documents/VScode/Main/JavaProjects/Data.txt"));
        while(input.hasNextInt()){
            int Line = input.nextInt();
            fileData.add(Line);
        }
        int[] a = ArrayConverter(fileData);
        

        File Data = new File("SortingTime.txt");//you can replace .txt with .doc or . httml
        PrintWriter pr = new PrintWriter(Data);
        long startTime;
        long endTime;
        long totalTime;
        
        // int[] array1 = copyarray(a);
        // startTime = System.nanoTime();        
        // bubbleSort(array1);
        // endTime = System.nanoTime(); 
        // totalTime = endTime-startTime;
        // pr.println("Bubble sort nano seconds "+totalTime);
        // System.out.println("Bubble sort finished");


        // int[] array2 = copyarray(a);
        // startTime = System.nanoTime();        
        // selectionSort(array2);
        // endTime = System.nanoTime(); 
        // totalTime = endTime-startTime;
        // pr.println("Selection sort nano seconds "+totalTime);
        // System.out.println("Selection sort finished");


        // int[] array3 = copyarray(a);
        // startTime = System.nanoTime();        
        // insertionSort(array3);
        // endTime = System.nanoTime(); 
        // totalTime = endTime-startTime;
        // pr.println("Insertion sort nano seconds "+totalTime);
        // System.out.println("Inserstion sort finished");


        // int[] array4 = copyarray(a);
        // startTime = System.nanoTime();        
        // mergeSort(array4,0,array4.length-1);
        // endTime = System.nanoTime(); 
        // totalTime = endTime-startTime;
        // pr.println("Merge sort nano seconds "+totalTime);
        // System.out.println("Merge sort finished");


        int[] array5 = copyarray(a);
        startTime = System.nanoTime();        
        quickSort(array5, 0, array5.length-1);
        endTime = System.nanoTime(); 
        totalTime = endTime-startTime;
        pr.println("Quick sort nano seconds "+totalTime);
        System.out.println("Quick sort finished");          
        pr.close();

        // printarray(a);


    }
}
