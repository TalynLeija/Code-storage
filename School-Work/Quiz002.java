// import java.util.ArrayList;

public class Quiz002 {
    //1
    public static int multiply(int x,int y){
        if(y==0){
            return 0;
        }
        else{
           return x+multiply(x,y-1); 
        }
    }

    //2
    public static int countOccurrences(String s,char c){
        if(s.length()!=0){
            if(s.charAt(0)==c){
                return 1+countOccurrences(s.substring(1,s.length()),c);
            }
            else{
                return countOccurrences(s.substring(1,s.length()),c);
            }
            
        }
        else{
            return 0;
        }

    }

    //3
    private static int findMax(int[] array, int current, int count){
        if(count==array.length){
            return array[current];
        }
        else{
            if(array[count]>array[current]){
                current=count;
                return findMax(array,current,count+1);
            }
            else{
                return findMax(array,current,count+1); 
            }            
        }


    }

    public static int findMax(int[] array, int current){
        return findMax(array,current,0);

    }


    //4
    public static void printEvenCharacters(String s, int index){
        if(index==s.length()){
            System.out.println(""); 
        }
        else{
            if(index%2==0){
                System.out.print(s.charAt(index));
                printEvenCharacters(s, ++index);
            }
            else{
                printEvenCharacters(s, ++index);
            }            
        }

        
    }

    public static void main(String[]args){
        int[] testarray = {0,9,4,5,23,14,2,40};
        String s1 = "test";
        String s2 = "murcielago";

        //1
        System.out.println(multiply(4,7));
        //2
        System.out.println(countOccurrences(s1,'t'));
        //3
        System.out.println(findMax(testarray,0));
        //4
        printEvenCharacters(s2,0);
    }
}
