import java.util.Stack;
import java.util.Scanner;

public class StackArray {
    private int data[];
    private int top;
    public StackArray(int n)
    {
        data=new int[n];
        top=0;
    }
    public int length()
    {
        return top;
    }
    public boolean isEmpty()
    {
        return top==0;
    }
    public boolean isFull()
    {
        return top==data.length;
    }
    public void push(int e)
    {
        if(isFull())
        {
            System.out.println("Stack is Overflow");
            return;
        }
        else
        {
            data[top]=e;
            top++;
        }
    }
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is underflow");
            return -1;
        }
        int e=data[top-1];
        top--;
        return e;
    }
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Underflow");
            return -1;
        }
        int e=data[top-1];
        return e;
    }
    public void display()
    {
        for(int i=0;i<top;i++)
            System.out.print(data[top-i-1]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of terms you want to insert in Stack: ");
        int n=sc.nextInt();
        StackArray sa = new StackArray(n);
        System.out.println("ENTER THE ELEMENTS");
        for(int i=0;i<n;i++)
            sa.push(sc.nextInt());
        sa.display();
        System.out.println(sa.peek());
        System.out.println(sa.pop());
        System.out.println(sa.length());
    }
}