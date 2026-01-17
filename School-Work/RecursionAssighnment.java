public class RecursionAssighnment {
    public static void printReverseIter(int n){
        for(int i=n;i>1;--i){
            System.out.print(i+", ");
        }
        System.out.println(1);
    }

    public static void printReverseRec(int n){
        if(n>1){
            System.out.print(n+", ");
            printReverseRec(n-1);
        }
        else{
            System.out.println(n);
        }
    }

    public static int getSum(int n){
        int sum = 0;
        for(int i=0;i<=n;++i){
            sum+=i;
        }
        return sum;
    }

    public static int getSumR(int n, int Usum){
        int sum = Usum;
        sum+=getSum(n);
        return sum;
    }

    public static void printReverse(String s){
        for(int i=s.length()-1;i>0;--i){
            System.out.print(s.charAt(i));
        }
        System.out.println(s.charAt(0));
    }

    public static String printReverseR(String s){
        if(s==null||s.length()<=1){
            return s;
        }
        return printReverseR(s.substring(1))+s.charAt(0);
    }    

    public static void main(String[]args){
        printReverseIter(5);
        printReverseRec(5);
        System.out.println(getSum(5));
        System.out.println(getSumR(5,getSum(5)));
        printReverse("apple");
        System.out.println(printReverseR("apple"));
    }

}
