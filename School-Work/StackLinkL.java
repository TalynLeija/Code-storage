public class StackLinkL {
    Node top;

    public StackLinkL(){
        top = null;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public void push(String s){
        top = new Node(s,top);
    }

    public String peek(){
        if(isEmpty()){
            return "Stack is empty";
        }
        else{
            return top.value;
        }
        
    }

    public String pop(){
        if(isEmpty()){
            return "Stack is empty";
        }
        else{
            String r = top.value;
            // node list is backwords so this works?
            top = top.next;
            return r;
        }
    }
}
