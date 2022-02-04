public class Doublylinkedlist {
    public class Node
    {
        int element;
        Node next,prev;
        public Node(int e,Node n,Node p)
        {
            element=e;
            next=n;
            prev=p;
        }
    }
    Node head;
    Node tail;
    int size;
    Doublylinkedlist()
    {
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void addlast(int e)
    {
        Node n=new Node(e,null,null);
        if(isEmpty())
        {
            head=n;
        }
        else
        {
            tail.next=n;
            n.prev=tail;
        }
        tail=n;
        size++;
    }
    public void addfirst(int e)
    {
        Node n=new Node(e,null,null);
        if(isEmpty())
        {
            head=n;
            tail=n;
        }
        else
        {
            n.next=head;
            head.prev=n;
            head=n;
        }
        size++;
    }
    public void atany(int e,int pos)
    {
        Node n=new Node(e,null,null);
        if(isEmpty())
        {
            if(pos==1)
            {
                head=n;
                tail=n;
            }
            else
            {
                System.out.println("Invalid Position");
                return;
            }
        }
        else if(pos<=0 || pos>size+1)
        {
            System.out.println("Invalid Position");
            return;
        }
        else
        {
            if(pos==1)
            {
                n.next=head;
                head.prev=n;
                head=n;
            }
            else if(pos==size+1)
            {
                n.prev=tail;
                tail.next=n;
                tail=n;
            }
            else {
                Node p = head;
                int i = 1;
                while (pos - 1 > i)
                {
                    p = p.next;
                    i++;
                }
                p.next.prev = n;
                n.next = p.next;
                n.prev = p;
                p.next = n;
            }
        }
        size++;
    }
    public int removefirst()
    {
        if(isEmpty())
        {
            System.out.println("LIST IS EMPTY");
            return -1;
        }
        else
        {
            int e=head.element;
            head=head.next;
            if(head!=null)
                head.prev=null;
            size--;
            return e;
        }
    }
    public int removelast()
    {
        if(isEmpty())
        {
            System.out.println("List is empty");
            return -1;
        }
        else
        {
            if(head.next==null) {
                int e=head.element;
                head=null;
                return e;
            }
            int e=tail.element;
            tail.prev.next=null;
            tail=tail.prev;
            size--;
            return e;
        }
    }
    public int removeany(int pos)
    {
        int e;
        if(size<pos)
        {
            System.out.println("Invalid Position");
            return -1;
        }
        else if(pos==1)
        {
            e=head.element;
            head=head.next;
            if(head!=null)
                head.prev=null;
        }
        else if(pos==size)
        {
            e=tail.element;
            tail.prev.next=null;
            tail=tail.prev;
        }
        else
        {
            Node p=head;
            int i=1;
            while(pos-1>i)
            {
                p=p.next;
                i++;
            }
            e=p.next.element;
            p.next.next.prev=p;
            p.next=p.next.next;
        }
        size--;
        return e;
    }
    public void display()
    {
        Node t=head;
        while(t!=null)
        {
            System.out.print(t.element+" ");
            t=t.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Doublylinkedlist dl=new Doublylinkedlist();
        dl.addlast(1);
        dl.addlast(2);
        dl.addlast(3);
        dl.addlast(4);
        dl.display();
        dl.addfirst(0);
        dl.addfirst(-1);
        dl.addfirst(-2);
        dl.display();
        dl.atany(5,8);
        dl.atany(-3,1);
  //      dl.atany(9,8);
        dl.display();
        dl.removefirst();
        dl.removelast();
        dl.display();
        int w=dl.removeany(1);
        System.out.println(w+" "+dl.removeany(12));
        System.out.println(dl.removeany(1));
        dl.display();
    }
}