public class NodeInt {
    int value; //value to be stored in node
    NodeInt next; //connection to the next Node

    public NodeInt(int value){
        this.value=value;
        this.next=null;
    }
    public NodeInt(int value, NodeInt next){
        this.value=value;
        this.next=next;
    }

    public void toStringN(){
        NodeInt current = this.next;

        System.out.print(this.value+" -> ");
        while(current.next!=null){
            System.out.print(current.value);
            if(current.next.next!=null){
                System.out.print(" -> ");
            }
            else{
                System.out.println("");
            }
            current=current.next;
        }
    }        

}
