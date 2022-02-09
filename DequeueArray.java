public class DequeueArray {
    private int data[];
    private int rear;
    private int front;
    private int size;
    public DequeueArray(int n)
    {
        data = new int[n];
        rear=front=size=0;
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int length(){
        return size;
    }
    public int first(){
        if(isEmpty()){
            System.out.println("QUEUE IS UNDERFLOW..");
            return -1;
        }
        return data[0];
    }
    public int last(){
        if(isEmpty()){
            System.out.println("DEQUEUE IS UNDERFLOW..");
            return -1;
        }
        return data[rear-1];
    }
    public void addFirst(int e){
        if(isFull()) {
            System.out.println("QUEUE IS FULL");
            return;
        }
        else if(isEmpty()){
            data[0]=e;
        }
        else{
            for(int i=rear;i>0;i--)
                data[i]=data[i-1];
            data[0]=e;
        }
        rear++;
        size++;
    }
    public void addLast(int e){
        if(isFull()){
            System.out.println("QUEUE IS FULL..");
            return;
        }
        data[rear] = e;
        rear++;
        size++;
    }
    public int removefirst(){
        if(isEmpty()){
            System.out.println("QUESE IS UNDERFLOW..");
            return -1;
        }
        int e=data[0];
        for(int i=0;i<rear-1;i++)
            data[i]=data[i+1];
        rear--;
        size--;
        return e;
    }
    public int removeLast(){
        if(isEmpty()){
            System.out.println("QUEUE IS UNDERFLOW..");
            return -1;
        }
        int e=data[rear-1];
        rear--;
        size--;
        return e;
    }
    public void display(){
        for(int i=0;i<rear;i++)
            System.out.print(data[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        DequeueArray da=new DequeueArray(5);
        da.addFirst(3);
        da.addFirst(2);
        da.addFirst(1);
        da.addLast(4);
        da.addLast(5);
        da.removefirst();
        da.addLast(2);
        da.addFirst(1);
        da.removeLast();
        da.removeLast();
        da.removeLast();
        da.removeLast();
        da.removeLast();
        da.removefirst();
        da.addLast(5);
        da.display();
        System.out.println(da.first()+" "+da.last());
    }
}
