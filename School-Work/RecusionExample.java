public class RecusionExample {

    public static void main(String[]args){
        System.out.println(factorial(5));

    }

    public static int factorial(int n){
        int f=1; //accumulator
        for(int i=1;i<=n; ++i){
            f*=i;
        }
        return f;
    }

    public static int factorialR(int n){
        int f=1; //activation records
        int i=1;
        if(i<=n){
            f*=i;
            i++;
            return factorialR(n);
        }
        else{
            return f;
        }
    }
}
