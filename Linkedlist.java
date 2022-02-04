public class Linkedlist {
    class Node
    {
        int element;
        Node next;
        Node(int e,Node n)
        {
            element=e;
            next=n;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    Linkedlist()
    {
        head=null;
        tail=null;
        size=0;
    }
    int length()
    {
        return size;
    }
    boolean isEmpty()
    {
        return size==0;
    }
    void addlast(int e)
    {
        Node newest=new Node(e,null);
        if(isEmpty())
            head=newest;
        else
            tail.next=newest;
        tail=newest;
        size+=1;
    }
    void addfirst(int e)
    {
        Node newest=new Node(e,null);
        if(isEmpty())
        {
            head = newest;
            tail = newest;
        }
        else
        {
            newest.next=head;
            head=newest;
        }
        size+=1;
    }
    void display()
    {
        Node p=head;
        while(p!=null)
        {
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }
    void addany(int e,int pos)
    {
        if(pos<=0 || pos >=size)
        {
            System.out.println("INVALID POSITION");
            return;
        }
        Node newest =new Node(e,null);
        Node p=head;
        int i=1;
        while(i<pos-1)
        {
            p=p.next;
            i+=1;
        }
        newest.next=p.next;
        p.next=newest;
        size+=1;

    }
    int removeLast()//returning the last element
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return -1;
        }
        Node p=head;
        int i=1;
        while(i<size-1)
        {
            p=p.next;
            i+=1;
        }
        tail=p;
        int o=p.next.element;
        p.next=null;
        size-=1;
        return o;
    }
    int removeFirst()//returning the removed element
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return 0;
        }
        int e=head.element;
        head=head.next;
        size-=1;
        if(isEmpty())
            tail=null;
        return e;
    }
    int removeany(int position)
    {
        if(position<=0 || position>=size-1 || isEmpty())
        {
            System.out.println("INVALID INPUT");
            return -1;
        }
        Node p=head;
        int i=1;
        while(i<position-1)
        {
            p=p.next;
            i+=1;
        }
        int o=p.next.element;
        p.next=p.next.next;
        size-=1;
        if(size==1)
            tail=head;
        return o;
    }
    void insertsorted(int e)
    {
        Node newest=new Node(e,null);
        if(isEmpty()) {
            head = newest;
            tail = newest;
        }
        else
        {
            Node p=head;
            Node q=head;
            while(p!=null && p.element<e)
            {
                q=p;
                p=p.next;
            }
            if(p==head)
            {
                newest.next=head;
                tail=head;
                head=newest;
            }
            else {
                newest.next = q.next;
                q.next = newest;
            }
        }
        Node p=head;
        while(p.next!=null)
            p=p.next;
        tail=p;
        size+=1;
    }

    void searching(int ele)
    {
        Node p=head;
        int i=0;
        while(p.next!=null)
        {
            if(p.element==ele)
            {
                System.out.println("Element is present at index: "+i);
                break;
            }
            i+=1;
            p=p.next;
        }
        if(i==size)
            System.out.println("ELEMENT IS NOT PRESENT");
    }
    public static void main(String args[])
    {
        Linkedlist l=new Linkedlist();
        l.insertsorted(3);
        l.insertsorted(2);
        l.insertsorted(22);
        l.insertsorted(8);
        l.display();
        l.addfirst(2);
        l.display();
        l.addlast(56);
        l.searching(3);
        l.searching(8);
        l.display();
    }
}
