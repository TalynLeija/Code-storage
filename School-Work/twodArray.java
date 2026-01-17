public class twodArray {
    
    public static void print(int[][] methodarray){
            for(int i=0;i<methodarray.length;i++){
                for(int j=0;j<methodarray[0].length;j++){
                    // if(methodarray[i][j]>=10){
                    //     System.out.print(methodarray[i][j]+"  ");
                    // }
                    // else{
                    //     System.out.print(methodarray[i][j]+"   ");
                    // }
                    System.out.print(methodarray[i][j]+"\t");
                }
                System.out.println("");

            }        
    }

    public static int[][] populateArray(int row, int col){
        int[][] newarray = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                newarray[i][j] = (int)(Math.random()*16);       
            }
        }     
        return newarray;   
    }

    public static int[][] copy(int[][] methodarray){
        int[][] copy = methodarray;
        return copy;   
    }

    //page 55
    public static void main(String[]args){
        int[][] arraytest = populateArray(4,3);
        int[][] copyarray = copy(arraytest);
        System.out.println("Original Array");
        print(arraytest);
        System.out.println("Copy Array");
        copyarray[3][2] = 4;
        print(copyarray);
    
    }
}
