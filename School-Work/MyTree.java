public class MyTree {
    BNodeInt root;

    MyTree(){
        this.root=null;
    }
    MyTree(BNodeInt bn){
        this.root=bn;
    }

    public int countParentWithOneChild(){
        return countParentWithOneChild(this.root);
    }

    private int countParentWithOneChild(BNodeInt root){
        if(root==null){
            return 0;
        }
        else if((root.left!=null && root.right==null)||(root.left==null && root.right!=null)){

            return 1+countParentWithOneChild(root.left)+countParentWithOneChild(root.right);            
        }
        else{
            return 0+countParentWithOneChild(root.left)+countParentWithOneChild(root.right);
        }
    }
    public int findMax(){
        return findMax(this.root);
    }

    private int findMax(BNodeInt root){
        if(root.right!=null){
            return findMax(root.right);
        }
        else{
            return root.value;            
        }
    }


}
