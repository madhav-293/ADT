import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class StackLinkedList {
    class Node {
        Node next;
        int element;

        public Node(int e, Node n) {
            next = n;
            element = e;
        }
    }

    Node head;
    int size;

    public StackLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int length(){
        return size;
    }
    public void push(int e)
    {
        Node n=new Node(e,null);
        if(isEmpty())
            head=n;
        else{
            n.next=head;
            head=n;
        }
        size++;
    }
    public int pop()
    {
        if(isEmpty()) {
            System.out.println("List is Underflow");
            return -1;
        }
        int e=head.element;
        head=head.next;
        size--;
        return e;
    }
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("List is Underflow");
            return -1;
        }
        return head.element;
    }
    public void display()
    {
        Node p=head;
        while(p!=null)
        {
            System.out.print(p.element+" ");
            p=p.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        StackLinkedList sll=new StackLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1 to PUSH");
        System.out.println("2 for Pop");
        System.out.println("3 for Peek");
        System.out.println("4 for Size");
        System.out.println("5 for display");
        System.out.println("6 to stop");
        while(true)
        {
            System.out.println("ENTER YOUR CHOICE");
            int n=sc.nextInt();
            switch(n)
            {
                case 1:{
                    System.out.println("ENTER THE ELEMENT:");
                    sll.push(sc.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("Pop element : " + sll.pop());
                    break;
                }
                case 3: {
                    System.out.println("Element : " + sll.peek());
                    break;
                }
                case 4: {
                    System.out.println("Size of Stack : " + sll.length());
                    break;
                }
                case 5: {
                    System.out.println("Elements of stack : ");
                    sll.display();
                    break;
                }
                case 6: {
                    break;
                }
                default:{
                    System.out.println("Invalid Input");
                }
            }
            if(n==6)
                break;
        }
    }
}
