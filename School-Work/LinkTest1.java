public class LinkTest1 {
    public static void main(String[]args){
        //createing the nodes
        NodeInt n1 = new NodeInt(11);//11
        NodeInt n2 = new NodeInt(11);
        NodeInt n3 = new NodeInt(11);
        NodeInt n4 = new NodeInt(21);
        NodeInt n5 = new NodeInt(43);
        NodeInt n6 = new NodeInt(43);//43
        NodeInt n7 = new NodeInt(60);

        //linking the list
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        System.out.println(Sum(n1));
        print(n1);
        size(n1);        
        CountOccurences(n1, 11);
        removeDuplicatesT(n1);
        print(n1);

    }

    //counts occurences of specified number
    public static void CountOccurences(NodeInt n, int t){
        NodeInt current = n;
        int results=0;

        while(current.next!=null){
            if(current.value==t){
                results+=1;
            }
            current=current.next;
        }
        if(current.value==t){
            results+=1;
        }
        System.out.println(results);        
    }

    //prints all nodes linked together
    public static void print(NodeInt node){
        NodeInt current = node;

        while(current.next!=null){
            System.out.print(current.value);
            if(current.next.next!=null){
                System.out.print(" -> ");
            }
            current=current.next;
        }
        System.out.println(" -> "+current.value);
    }

    public static void size(NodeInt node){
        int size=0;
        NodeInt current = node;

        while(current.next!=null){
            ++size;
            current=current.next;
        }
        System.out.println(size);
    }
    public static int Sum(NodeInt node){
        NodeInt current = node;
        int sum=0;

        while(current.next!=null){
            sum+=current.value;
            current=current.next;
        }
        sum+=current.value;
        return sum;
    }

    public static void removeDuplicatesT(NodeInt n){
        NodeInt current = n;
        NodeInt update = n;
        int duplicate = update.value;

        while(current.next!=null){
            if(current.value==duplicate){
                if(current.next.value==current.value && current.next.next==null){
                    current.next=null;
                }
                else{
                    while(current.value==duplicate){
                        current=current.next;                        
                    }
                    update.next=current;
                    update=current;
                    duplicate=current.value;                    
                }

                
            }
            // current.next.next==null && current.next.next.value==duplicate
            
        }
    }
}
