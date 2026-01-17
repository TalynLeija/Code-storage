public class Search {
    public static boolean SequentialSearch(int[] array, int target){
        boolean result=false;
        for(int i=0;i<array.length;++i){
            if(array[i]==target){
                result=true;
            }
        }
        return result;
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

    public static boolean BinarySearch(int[] array, int target){
        int first=0;
        int last=array.length-1;
        boolean found=false;

        while(!found&&first<=last){
            int middle =(first+last)/2;
            if(array[middle]==target){
                found = true;
            }
            else if(array[middle]>target){
                last = middle -1;
            }
            else{
                first = middle +1;
            }
        }
        return found;
    }

    private static boolean BinarySearchR(int[] array, int target, int first, int last){
        if(first>last){
            return false;
        }
        int middle =(first+last)/2;
        if(array[middle]==target){
            return true;
        }
        else if(array[middle]<target){
            // I totaly forgot you can return the method
            return BinarySearchR(array, target,middle+1,last);
        }
        else{
            return BinarySearchR(array, target,first,middle-1);
        }

    }

    public static boolean BinarySearchR(int[] array, int target){
        return BinarySearchR(array,target,0,array.length-1);
    }

    public static void main(String[]args){
        int[] a = {2, 5, 7, 1, 10, 4};
        SortingAlgo.bubbleSort(a);
        // bubbleSort(a);
        System.out.println(SequentialSearch(a,1));
        System.out.println(BinarySearch(a,2));
        System.out.println(BinarySearchR(a,69));
    }
}
