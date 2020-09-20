import java.util.*;
class PriorityQueueUsingArray {

    public static void main(String args[])
    {
         Scanner scanner = new Scanner(System.in);
         System.out.println("1. FOR DESCENDING\n2. FOR ASCENDING");
         int status = scanner.nextInt();
        System.out.print("Enter the size of the Queue : ");
        int size = scanner.nextInt();
        Queue que = new Queue(size , status);
        int ch = 0;
       do{
            System.out.println("Enter\n1. TO Enqueue\n2. TO Dequeue\n3. TO SHOW");
            ch = scanner.nextInt();
            
            switch(ch)
            {
                case 1 : System.out.print("Enter an element to Enqueue : ");
                         int el = scanner.nextInt();
                         System.out.print("Enter priority :  ");
                         int priority = scanner.nextInt();
                         que.Enqueue(el , priority);
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
    int[] priority;
    int size;
    int front;
    int rear;
    int status = 0;
    Queue(int size , int status)
    {
        this.size = size;
        que = new int[size];
        priority = new int[size];
        front = 0;
        rear = -1;
        this.status = status;

    }

    void Enqueue(int value, int priority)
    {
        try{
               rear++;
               que[rear] = value;
               this.priority[rear] = priority;
                           System.out.println("Priority before = " + Arrays.toString(this.priority));

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
            System.out.println("\t\t\t !!! QUEUE UNDERFLOW !!!");
        }
        else
        {
            int pos=0;
            int smallest = get_priority();
            while(pos<=rear){
                if(priority[pos] == smallest)
                    break;
                pos++;
            }
            re_arrrange(pos);
            rear--;
            size--;
        }
    }
    private void re_arrrange(int point)
    {
        for(int i = point ; i < rear ; i++)
        {
            que[i] = que[i+1];
            priority[i] = priority[i+1];
        }
        
    }
    private int get_priority()
    {   
        int max = priority[0];
        for(int i = 0; i <= rear ; i++)
        {
            int value = priority[i];
            max = status == 1 ? value > max ? value : max : value < max ? value : max; 
        }
        return max;
    }


    void show()
    {
        System.out.println("\n");
        for(int i = front ; i <= rear ; i++)
        {
            System.out.print(que[i]+"    ");
        }
        System.out.println("\n");
    }

}