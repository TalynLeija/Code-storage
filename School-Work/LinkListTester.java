public class LinkListTester {
    Node first;
    Node last;

    public LinkListTester(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        if(first==null){
            return true;
        }
        else{
            return false;
        }
    }

    // add node to linked list
    public void add(String s){
        Node n = new Node(s);
        if(isEmpty()){
            first=last=n;
        }
        else{
            last.next=n; //conect the last
            last=last.next; // update last
        }
    }
    // public static void printIterR(Node node){
    //     Node current = node;
    //     if(current!=null){
    //         System.out.println(current.value+" -> ");
    //         printIterR(current.next); // next has adress for next node
    //     }
    // }

    // private static boolean find(String s,Node n){
    //     if(n==null){
    //         return false;
    //     }
    //     else if(n.value==s){
    //         return true;
    //     }
    //     else{
    //         find(s,n.next);
    //     }
    // }
    // private static boolean find(String s){
    //     return find(s,this.first);
    // }
    
}
