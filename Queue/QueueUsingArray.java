import java.util.*;
class QueueUsingArray {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Queue : ");
        int size = scanner.nextInt();
        Queue que = new Queue(size);
        int ch = 0;
       do{
            System.out.println("Enter\n1. TO Enqueue\n2. TO Dequeue\n3. TO SHOW");
            ch = scanner.nextInt();
            
            switch(ch)
            {
                case 1 : System.out.print("Enter an element to Enqueue : ");
                         int el = scanner.nextInt();
                         que.Enqueue(el);
                         que.show();
                         break;

                case 2 : que.Dequeue();
                         que.show();
                         break;

                case 3 : que.show();
                         break;
            }
        }while(ch!=4);
    }

}

class Queue {

    int[] que;
    int size;
    int front;
    int rear;

    Queue(int size)
    {
        this.size = size;
        que = new int[size];
        front = 0;
        rear = -1;
    }

    void Enqueue(int value)
    {
        try{
               rear++;
               que[rear] = value;
           }catch(ArrayIndexOutOfBoundsException e)
           {
               System.out.println("\t\t\t !!! QUEUE OVERFLOW !!!");
               rear--;
           }
    }

    void Dequeue()
    {
        if(rear < front)
        {
            System.out.println("QUEUE UNDERFLOW");
        }
        else
        {
            front++;
            size++;
        }
    }

    void show()
    {
        for(int i = front ; i <= rear ; i++)
        {
            System.out.print(que[i]+"    ");
        }
    }

}