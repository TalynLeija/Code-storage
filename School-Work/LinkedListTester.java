public class LinkedListTester{
    public static void main(String[]args){
        LinkListTester list = new LinkListTester();
        System.out.println("Is my list empty? "+list.isEmpty());
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Is my list empty? "+list.isEmpty());
        // System.out.println("Is B in list? "+list.find("B",list.first));
    }
}