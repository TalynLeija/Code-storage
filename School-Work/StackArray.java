public class StackArray {
    String[] stack;
    int top;

    public StackArray(){
        stack = new String[10];
        top=0;
    }

    public boolean isEmpty(){
        return top==0;
    }

    public void push(String s){
        if(top==stack.length){
            ensureCapacity();            
        }
        stack[top]=s;
        ++top;              
    }

    public void ensureCapacity(){
        String[] newStack = new String[stack.length*2];
        for(int i=0;i<stack.length;++i){
            newStack[i]=stack[i];
        }
        stack = newStack;
    }

    public String peek(){
        if(isEmpty()){
            return "Stack is empty";
        }
        else{
           return stack[top-1]; 
        }
        
    }

    // it's common to return element when removeing
    public String pop(){
        if(isEmpty()){
            return "Stack is empty";
        }
        else{
            String r = stack[top-1];
            --top;
            return r;            
        }

    }

}
