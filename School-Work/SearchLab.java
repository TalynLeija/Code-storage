public class SearchLab {
    //sSearch short for SequentialSearch
    public static int sSearch(int[] array, int target){
        int result=array.length-1;
        for(int i=0;i<array.length;++i){
            if(array[i]==target){
                result=i;
            }
        }
        return result;
    }

    private static int sSearchR(int[] array, int target,int i){
        if(i<array.length){
            if(array[i]==target){
                return i;
            }
            else{
                return sSearchR(array, target, i+1);
            }            
        }
        else{
            return i;
        }
    }

    public static int sSearchR(int[] array, int target){
        return sSearchR(array,target,0);
    }

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

    // bSearch short for BinarySearch
    public static int bSearch(int[] array, int target){
        int first=0;
        int last=array.length-1;
        int middle=0;

        while(array[middle]!=target&&first<=last){
            middle =(first+last)/2;
            if(array[middle]==target){
                break;
            }
            else if(array[middle]>target){
                last = middle -1;
            }
            else{
                first = middle +1;
            }
        }
        return middle;
    }

    private static int bSearchR(int[] array, int target, int first, int last){
        int middle =(first+last)/2;        
        if(first>last){
            return 0;
        }

        if(array[middle]==target){
            return middle;
        }
        else if(array[middle]<target){
            // I totaly forgot you can return the method
            return bSearchR(array, target,middle+1,last);
        }
        else{
            return bSearchR(array, target,first,middle-1);
        }

    }

    public static int BinarySearchR(int[] array, int target){
        return bSearchR(array,target,0,array.length-1);
    }

    public static void printarray(int[] a){
        for(int j=0;j<a.length-1;++j){
            System.out.print(a[j]+", ");
        }
        System.out.println(a[a.length-1]);            
    }

    public static void main(String[]args){
        int[] a = {2, 5, 7, 1, 10, 4};
        // SortingAlgo.bubbleSort(a);
        bubbleSort(a);
        printarray(a);
        System.out.println(sSearch(a,1));
        System.out.println(sSearchR(a,10));
        System.out.println(bSearch(a,2));
        System.out.println(BinarySearchR(a,10));
    }
}
