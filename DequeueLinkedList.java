public class DequeueLinkedList {
    class Node{
        Node next;
        int element;
        public Node(int e,Node n){
            element=e;
            next=n;
        }
    }
    private Node front;
    private Node rear;
    private int size;
    public DequeueLinkedList(){
        front = null;
        rear = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int length(){
        return size;
    }
    public int first(){
        if(isEmpty()){
            System.out.println("List is Underflow");
            return -1;
        }
        return front.element;
    }
    public int last(){
        if(isEmpty()){
            System.out.println("List is Underflow");
            return -1;
        }
        return rear.element;
    }
    public void addFirst(int e){
        Node n=new Node(e,null);
        if(isEmpty()){
            rear=n;
        }
        else{
           n.next=front;
        }
        front=n;
        size++;
    }
    public void addlast(int e){
        Node n=new Node(e,null);
        if(isEmpty()){
            front=n;
        }
        else{
            rear.next=n;
        }
        rear=n;
        size++;
    }
    public int removefirst(){
        if(isEmpty()){
            System.out.println("Dequeue is Underflow..");
            return -1;
        }
        int e=front.element;
        front=front.next;
        size--;
        if(isEmpty())
            rear=null;
        return e;
    }
    public int removelast(){
        if(isEmpty()){
            System.out.println("Dequeue is Underflow..");
            return -1;
        }
        Node p=front;
        int e;
        if(p.next==null){
            e=front.element;
            front=null;
            rear=null;
        }
        else {
            while (p.next.next != null) {
                p = p.next;
            }
            e = rear.element;
            p.next = null;
            rear = p;
        }
        size--;
        return e;
    }
    public void display(){
        Node p=front;
        while(p!=null){
            System.out.print(p.element+ " ");
            p=p.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        DequeueLinkedList dll=new DequeueLinkedList();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addlast(4);
        dll.addlast(5);
        dll.addFirst(1);
        dll.removelast();
        dll.removelast();
        dll.removelast();
        dll.removelast();
        dll.removelast();
        dll.removefirst();
        dll.addlast(1);
        dll.display();
        System.out.println(dll.first()+" "+dll.last()+" "+dll.length());
    }
}
