public class Twodarray2 {
    public static void findSmallest(int[][] a){
        int smallest;
        for(int i=0;i<a.length;i++){
            smallest=a[i][0];            
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]<smallest){
                    smallest = a[i][j];
                }       
            }
            System.out.println("smallest in row "+i+":  "+smallest);

        }
                   
    }

    public static void min(int[][] a){
        int smallest=a[0][0];
        for(int i=0;i<a.length;i++){
            smallest=a[i][0];            
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]<smallest){
                    smallest = a[i][j];
                }       
            }
            
        }
        System.out.println("\nsmallest in array: "+smallest);          
    }

    public static void findlargest(int[][] a){
        int largest;
        for(int i=0;i<a.length;i++){
            largest=a[i][0];            
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]>largest){
                    largest = a[i][j];
                }       
            }
            System.out.println("largest in row "+i+":  "+largest);

        }
                   
    }
    public static void main(String[]args){
        int[][] testarray = {{3,5},{1,4},{9,5},{2,6}};
        findSmallest(testarray);
        System.out.println("");
        findlargest(testarray);
        min(testarray);

    }
}
