public class StackArray2 {
    String[] stack;
    int top;

    public StackArray2(){
        stack = new String[10];
        top=0;
    }

    public StackArray2(int size){
        stack = new String[size];
        top=0;
    }

    public boolean isEmpty(){
        return top==0;
    }

    public boolean isFull(){
        return top==stack.length;
    }

    public int size(){
        return top;
    }

    public void push(String n){
        if(isFull()){
            ensureCapacity();            
        }
        stack[top]=n;
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
        return stack[top-1];         
    }

    public String pop(){
        String r = stack[top-1];
        --top;
        return r;    

    }
}