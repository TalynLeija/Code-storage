public class RecursionFactorial {

    public static int factorial(int n){
        int i,fact=1;  
        int number=n;//It is the number to calculate factorial    
        for(i=1;i<=number;i++){    
            fact=fact*i;    
        }
        return fact;
    }

    public static int factorialR(int n){
        int fact=n;     
        if(n==1){
            return fact;
        }
        else{
            return fact*factorialR(n-1);
        }
    }

    public static void main(String[]args){
        System.out.println(factorial(5));
        System.out.println(factorialR(5));
    }
}
