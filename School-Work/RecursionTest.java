public class RecursionTest {

    public static void printHelloR(int n){
        if(n>0){
            // print numbers backwords
            System.out.print(n+" ");
            printHelloR(n-1);
        }
        // print numbers
        // System.out.print(n+" ");
    }

    public static void printHelloF(int n){
        for(int i=0;i<n;++i){
            System.out.println("Hello");
        }
    }

    public static void printHelloW(int n){
        while(n<0){
            System.out.println("Hello");
            n--;
        }
    }
    /*
    @param int n
    @return sum of all digits in integer
    int n=5; sum = 5+4+3+2+1+0
     */
    public static int findSum(int n){
        int sum = 0;
        for(int i=0;i<=n;++i){
            sum+=i;
        }
        return sum;
    }

    public static int findSumR(int n){
        if(n>=0){
            return n+findSumR(n-1);
        }
        else{
            return 0;
        }
    }

    public static void backwordsNum(int n){
        for(int i=n;i>0;--i){
            System.out.print(i+", ");
        }
        System.out.println(0);
    }

    public static void backwordsNumR(int n){
        if(n>0){
            System.out.print(n+", ");
            backwordsNumR(n-1);
        }
        else{
            System.out.println(n);
        }

    }
    public static void main(String[]args){
        printHelloR(10);
        System.out.println("\n"+findSumR(5));
        backwordsNumR(5);
        backwordsNum(5);
    }
}
