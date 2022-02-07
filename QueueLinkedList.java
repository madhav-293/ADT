public class QueueLinkedList {
    class Node
    {
        Node next;
        int element;
        public Node(int e,Node n){
            element=e;
            next=n;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public QueueLinkedList()
    {
        head=null;
        size=0;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int length(){
        return size;
    }
    public void enqueue(int e){
        Node n=new Node(e,null);
        if(isEmpty())
            head=n;
        else{
            tail.next=n;
        }
        tail=n;
        size++;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("QUEUE IS UNDERFLOW");
            return -1;
        }
        int e=head.element;
        head=head.next;
        size--;
        return e;
    }
    public void display(){
        Node p=head;
        while(p!=null){
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        QueueLinkedList qll=new QueueLinkedList();
        qll.enqueue(1);
        qll.enqueue(2);
        qll.enqueue(3);
        qll.enqueue(1);
        qll.enqueue(5);
        qll.display();
        System.out.println(qll.dequeue());
        qll.display();
        qll.length();
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        System.out.println(qll.dequeue());
        qll.enqueue(1);
        qll.enqueue(2);
        qll.display();
    }
}
