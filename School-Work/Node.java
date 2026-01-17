public class Node {
    String value; //value to be stored in node
    Node next; //connection to the next Node

    public Node(String value){
        this.value=value;
        this.next=null;
    }
    public Node(String value, Node next){
        this.value=value;
        this.next=next;
    }

    public void toStringN(){
        Node current = this.next;

        System.out.print(this.value+" -> ");
        while(current.next!=null){
            System.out.print(current.value+" -> ");
            current=current.next;
        }
        System.out.println(current.value);
    }

}