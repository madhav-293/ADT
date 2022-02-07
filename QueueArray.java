import java.util.*;
public class QueueArray {
    private int data[];
    private int front;
    private int rear;
    private int size;
    public QueueArray(int n)
    {
        data=new int[n];
        size = 0;
        front = 0;
        rear = 0;
    }
    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==data.length;
    }
    public void enqueue(int e)
    {
        if(isFull())
        {
            System.out.println("QUEUE IS FULL");
            return;
        }
        data[rear]=e;
        rear++;
        size++;
    }
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }
        int e=data[front];
        for(int i=0;i<rear-1;i++)
            data[i]=data[i+1];
        rear--;
        size--;
        return e;
    }
    public void display()
    {
        for(int i=front;i<rear;i++)
            System.out.print(data[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        QueueArray qa=new QueueArray(10);
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        qa.enqueue(4);
        qa.enqueue(5);
        qa.enqueue(6);
        qa.display();
        System.out.println("element removed : "+qa.dequeue());
        qa.display();
        qa.dequeue();
        qa.dequeue();
        qa.dequeue();
        qa.dequeue();
        qa.dequeue();
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        qa.enqueue(4);
        qa.enqueue(5);
        qa.enqueue(1);
        qa.enqueue(2);
        qa.enqueue(3);
        qa.enqueue(4);
        qa.enqueue(5);
        qa.enqueue(3);
        qa.display();
    }
}
