public class MyQueueATester {

    public static void reverseQue(MyQueueA oldQue)throws EmptyQueueException{
        int[] temp = new int[oldQue.size()];
        int i = 0;
        while(!oldQue.isEmpty()){
            temp[i] = oldQue.deQueue();
            i++;
        }
        while(oldQue.size()!=temp.length){
            oldQue.enque(temp[i-1]);
            i--;
        }
    }

    public static void main(String[]args) throws EmptyQueueException{
        //skips "A" for some reason
        MyQueueA n1 = new MyQueueA();
        try{
            // n1.peek();
            n1.deQueue();
            n1.enque(1);
            n1.enque(2);
            n1.enque(3);

            System.out.println("size: "+n1.size());
            System.out.println("Head: "+n1.peek());
            reverseQue(n1);
            System.out.println("reverse order");
            System.out.println("Head: "+n1.peek());

            System.out.println("removeing number: "+n1.deQueue());
            System.out.println("size: "+n1.size());
            System.out.println("Head: "+n1.peek());            
        }
        catch(EmptyQueueException ex){
            System.out.println("\n"+ex);
        }



    }
}
