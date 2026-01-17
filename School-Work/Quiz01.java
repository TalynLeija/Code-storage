// import java.io.IOException;
// import java.util.DimensionsMissMatchException;

public class Quiz01 {

    //1
    public static int findSum(int[][] methodarray){
        int sum=0;
        for(int i=0;i<methodarray.length;i++){
            for(int j=0;j<methodarray[i].length;j++){
                sum+=methodarray[i][j];

            }

        }   
        return sum;     
    }

//     //2
    public static double findAVG(int[][] methodarray){
        double count=0.0;
        double sum=0.0;
        try{
            for(int i=0;i<methodarray.length;i++){
                for(int j=0;j<methodarray[0].length;j++){
                    sum+=methodarray[i][j];
                    count++;
                }
            }
        }
        catch(ArithmeticException ex){
            System.out.println(ex+" numbers array must be greater than zero");
            return 0.0;
        }               
        return sum/count;     
    }

//     //3
    public static int[] findSmallestPerRow(int[][] methodarray){
        int[] smallest = new int[methodarray.length];

        for(int i=0;i<methodarray.length;i++){
            int smallNum=methodarray[i][0]; 
            for(int j=0;j<methodarray[0].length;j++){   
                if(methodarray[i][j]<smallNum){
                    smallNum=methodarray[i][j];
                }
                else{
                    ;
                }
            }
            smallest[i]=smallNum;

        }   
        return smallest;     
    }

//     //4
    // public static int[][] addition(int[][] array1,int[][] array2)throws DimensionsMissMatchException{
    //     int[][] array3 = new int[array1.length][array1.length];
    //     if(array3.length!=array1.length){

    //     }
    //     try{
    //         for(int i=0;i<array1.length;i++){
    //             for(int j=0;j<array1.length;j++){
    //                 array3[i][j]=array1[i][j]+array2[i][j];
    //             }

    //         }
    //         return array3;           
    //     }
    //     catch(DimensionsMissMatchException ex){
    //         System.out.println(ex+" both matrixes do not match");
    //         return array3;
    //     } 
    // }

    public static void main(String[]args){  
        int[][] array1 = {{4,1},{3,4}};
        // int[][] array2 = {{4,2},{4,4}};

        System.out.println(findSum(array1));
        // System.out.println(findAVG(array1));
        // // System.out.println(findSmallestPerRow(array1).toString());
        // int[] smallarray=findSmallestPerRow(array1);
        // for(int i=0;i<smallarray.length;++i){
        //     System.out.println(smallarray[i]);
        // }


    }    
}
