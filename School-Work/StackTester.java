public class StackTester {
    public static void main(String[]args){
        StackArray st = new StackArray();
        st.push("b");
        st.push("cringe");
        st.push("Meme");
        st.push("Based");

        System.out.println(st.isEmpty());
        System.out.println(st.peek());
        // System.out.println(st.pop());
        st.pop();
        System.out.println(st.peek());

    }
}
