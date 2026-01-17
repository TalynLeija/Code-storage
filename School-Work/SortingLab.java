public class SortingLab {

    private static int[] bubbleR(int[] array, int index){
        if(index!=array.length){
            for(int j=0;j<array.length-1-index;++j){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            bubbleR(array,index+1);
        }
        return array;            

    }

    public static int[] bubbleR(int[] array){
        return bubbleR(array,0);
    }

    public static int[] bubble(int[] array){
        for(int i=0;i<array.length;++i){
            for(int j=0;j<array.length-1-i;++j){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public static void printarray(int[] a){
        for(int j=0;j<a.length-1;++j){
            System.out.print(a[j]+", ");
        }
        System.out.println(a[a.length-1]);            
    }

    public static void findMissing(int[] array){
        for(int i=0;i<array.length-1;++i){
            if(array[i+1]!=array[i]+1){
                // System.out.print("Missing number is ");
                System.out.println(array[i]+1);
            }
        }
    }

    public static void main(String[]args){
        int[] a = {34,9,18,6,50,25,19,26,1,40};
        // int test[] = {1, 2, 3, 4, 6, 7, 8};
        int test2[] = {1, 2, 3, 4, 5, 6, 8};
        System.out.println("Original array");
        printarray(a);
        System.out.println("Sorted array");
        printarray(bubble(a));
        System.out.println("Recursion Sorted array");
        printarray(bubbleR(a));   
        findMissing(test2);    
        System.out.println("All is well");
    }
}
