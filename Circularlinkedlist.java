public class Circularlinkedlist
{
    public class Node {
        Node next;
        int element;

        public Node(int e, Node n) {
            element = e;
            next = n;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public Circularlinkedlist()
    {
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void addlast(int e)
    {
        Node n=new Node(e,null);
        if(isEmpty())
        {
            head=n;
            n.next=head;
        }
        else
        {
            n.next=tail.next;
            tail.next=n;
        }
        tail=n;
        size+=1;
    }
    public void addfirst(int e)
    {
        Node n=new Node(e,null);
        if(isEmpty())
        {
            n.next=n;
            head=n;
            tail=n;
        }
        else
        {
            tail.next=n;
            n.next=head;
            head=n;
        }
        size+=1;
    }
    public void addany(int e,int pos)
    {
        Node n=new Node(e,null);
        if(isEmpty())
        {
            if(pos==1)
            {
                n.next=n;
                head=n;
            }
            else{
                System.out.println("Invalid Position");
                return;
            }
        }
        else
        {
            if(pos<=0 || pos>size+1)
            {
                System.out.println("Invalid Position");
                return;
            }
            else
            {
                int i=1;
                Node temp=head;
                if(pos==1)
                {
                    n.next=head;
                    head=n;
                }
                else
                {
                    while(pos-1>i)
                    {
                        i+=1;
                        temp=temp.next;
                    }
                    if(pos==size+1)
                        tail=n;
                    n.next=temp.next;
                    temp.next=n;
                }
            }
            size+=1;
        }
    }
    public int removefirst()
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return 0;
        }
        else
        {
            tail.next=head.next;
            int e=head.element;
            head=head.next;
            size-=1;
            return e;
        }
    }
    public int removelast()
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return 0;
        }
        else
        {
            Node t=head;
            int i=1;
            while(i<size-1)
            {
                i+=1;
                t=t.next;
            }
            int e=t.next.element;
            t.next=head;
            tail=t;
            size-=1;
            return e;
        }
    }
    public int removeany(int pos)
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return 0;
        }
        else if(pos>size)
        {
            System.out.println("INVALID POSITION");
            return 0;
        }
        else
        {
            Node t=head;
            int i=1,e;
            while(pos-1>i)
            {
                i+=1;
                t=t.next;
            }
            if(pos==1) {
                e=head.element;
                head = head.next;
                tail.next = head;
            }
            else if(pos==size) {
                e=tail.element;
                tail = t;
                t.next=head;
            }
            else
            {
                e=t.next.element;
                t.next=t.next.next;
            }
            size-=1;
            return e;
        }
    }
    public void display()
    {
        Node temp=head;
        int i=0;
        while(i<size)
        {
            System.out.print(temp.element+" ");
            temp=temp.next;
            i+=1;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Circularlinkedlist cl = new Circularlinkedlist();
        cl.addlast(1);
        cl.addlast(2);
        cl.addlast(3);
        cl.addlast(4);
        cl.addlast(5);
        cl.display();
        cl.addfirst(0);
        cl.addfirst(-1);
        cl.addfirst(-2);
        cl.display();
        cl.addany(6,9);
        cl.display();
        System.out.println(cl.removefirst());
        System.out.println(cl.removelast());
        cl.display();
        System.out.println(cl.removeany(3));
        System.out.println(cl.removeany(10));
        System.out.println(cl.removeany(1));
        System.out.println(cl.removeany(5));
        cl.display();
    }
}
