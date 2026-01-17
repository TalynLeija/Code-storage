public class MyQueueA {
    NodeInt front;
    NodeInt rear;
    int size=0;

    public MyQueueA(){
        front = rear = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enque(int n){
        NodeInt num = new NodeInt(n);
        if(isEmpty()){
            front = rear = num;
        }
        else{
            rear.next = num;
            rear = rear.next;

        }
        size++;
    }

    public int peek() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException("Stack is empty...");
        }
        return front.value;
    }

    public int deQueue() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException("Stack is empty...");
        }
        int n = front.value;
        front = front.next;
        size--;
        return n;
    }

    // public int deQueue(){
    //     if(isEmpty()){
    //         System.out.println("Stack is empty...");
    //         return 0;
    //     }
    //     else{
    //         int n = front.value;
    //         front = front.next;
    //         size--;
    //         return n;            
    //     }

    // }
}
