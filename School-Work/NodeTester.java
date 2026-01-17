// import Node

public class NodeTester{
    public static void main(String[]args){
        //B -> A -> C -> E -> D ->
        
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");

        n2.next = n1;
        n1.next = n3;
        n3.next = n5;
        n5.next = n4;
        n4.next = null; // this is redundant because null is default

        System.out.println(find(n2,"D"));
        print(n2);
        printR(n2);
        n2.toString();

    }

    public static void print(Node node){
        Node current = node;

        while(current.next!=null){
            System.out.print(current.value);
            if(current.next.next!=null){
                System.out.print(" -> ");
            }
            current=current.next;
        }
        System.out.println(" -> "+current.value);
    }

    public static boolean find(Node n, String t){
        Node current = n;
        boolean results = false;

        while(current.next!=null){
            if(current.value==t){
                results=true;
            }
            current=current.next;
        }   
        if(current.value==t){
            results=true;
        }
        return results;     
    }

    public static void printR(Node node){
        Node current = node;
        if(current.next!=null){
            System.out.print(current.value+" -> ");
            printR(current.next);
        }
        else{
            System.out.println(current.value);
        }
    }

}