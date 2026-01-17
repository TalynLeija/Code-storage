public class MyTreeTester {
    public static void main(String[]args){
        BNodeInt n1 = new BNodeInt(21);
        BNodeInt n2 = new BNodeInt(11);
        BNodeInt n3 = new BNodeInt(68);
        BNodeInt n4 = new BNodeInt(7);
        BNodeInt n5 = new BNodeInt(13);
        BNodeInt n6 = new BNodeInt(42);
        BNodeInt n7 = new BNodeInt(88);
        BNodeInt n8 = new BNodeInt(55);
        BNodeInt n9 = new BNodeInt(70);
        
        MyTree bst = new MyTree(n1);        
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n6.right=n8;
        n7.left=n9;

        System.out.println(bst.countParentWithOneChild());
        //PREORDER: 21 11 7 13 68 42 88 70
        //INORDER: 7 11 13 21 42 55 68 70 88
        //POSTORDER: 7 13 11 15 42 70 88 68 70

        
        

    }




}
