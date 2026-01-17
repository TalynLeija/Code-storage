public class MyLinkedList {
    Node first;
    Node last;

    public MyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first==null;
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

    public int size(){
        int count=0;
        Node p=first;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }

    private int sizeR(Node n){       
        if(n!=null){           
            return 1+sizeR(n.next);

        }
        return 0;                
    }

    public int sizeR(){
        return sizeR(first);
    }

    public boolean find(String x){
        boolean found = false;
        Node p = first;
        while(p!=null){
            if(p.value==x){
                found=true;
            }
            p = p.next;
        }
        return found;
    }

    private boolean findR(String x, Node n){
        if(n!=null){
            if(n.value==x){
                return true;
            }
            else{
                return findR(x,n.next);
            }
        }
        else{
            return false;
        }
    }

    public boolean findR(String x){
        return findR(x,first);
    }
}
