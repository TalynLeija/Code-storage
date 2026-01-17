public class MyLinkedListTester {
    public static void main(String[]args){
        //createing the nodes
        MyLinkedList n1 = new MyLinkedList();

        n1.add("apple");
        n1.add("orange");
        n1.add("bannana");
        n1.add("pineapple");

        System.out.println(n1.size());
        System.out.println(n1.sizeR());
        System.out.println(n1.findR("apple"));
        System.out.println(n1.find("apple"));

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
