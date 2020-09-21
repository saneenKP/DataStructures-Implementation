import java.util.*;
class PriorityQueueUsingList {

    public static void main(String args[])
    {
         Scanner scanner = new Scanner(System.in);
         System.out.println("1. FOR DESCENDING\n2. FOR ASCENDING");
         int status = scanner.nextInt();
        Queue que = new Queue(status);
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

class Node{

    int value;
    int priority;
    Node next;

     Node(int value ,int priority, Node next)
    {
        this.value = value;
        this.next = next;
        this.priority = priority;
    }

}

class LinkedList {

    Node head;
    int size;

    public void Addtothebeginning(int value,  int priority)
    {
        Node new_value = new Node(value , priority ,null);
        size++;
        if(head == null)
        {
            head = new_value;
        }
        else
        {
            new_value.next = head;
            head = new_value;
        }
    }

    public void AddtotheEnd(int value , int priority)
    {
        Node new_value = new Node(value ,priority,null);
        size++;
        if(head == null)
        {
            head = new_value;
        }
        else
        {
            Node tmp = head;
            while(tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = new_value;
        }
    }

    public void DeleteAtEnd()
    {
        Node tmp1 = head;
        while(tmp1.next.next != null)
        {
            tmp1 = tmp1.next;
        }
        tmp1.next = null;
        size--;
    }

    public void DeleteAtBeginning()
    {
        head = head.next;
        size--;
    }


    public void DeleteAtPosition(int p)
    {
        
        System.out.println("POSITION THAT CAME = " + p);
        size--;
        if(p == 1)
        {
           DeleteAtBeginning();
        }
        else if(p == size)
        {

          DeleteAtEnd();
        }
        else if(p > size)
        {
            System.out.println("\t\t\t  INVALID POSITION ");
        }
        else
        {
            System.out.println("pos gone");
            Node tmp = head;
            int i = 2;
            while(i < p)
            {
                tmp = tmp.next;
                i++;
            }
            Node container = tmp.next.next;
            tmp.next = container;
        }

       
    }

    int getPriority(int status)
    {
        int pos = 1;
        Node tmp = head;
        int highest = getHighest(status);
        while(tmp.next != null)
        {
            if(tmp.priority == highest)
                break;
            tmp = tmp.next;
            pos++;
        }

        return pos;

    }

    private int getHighest(int status)
    {
        
        int max = head.priority;
        Node tmp = head;
        while(tmp.next != null)
        {
            int value = tmp.priority;
            max = status == 1 ? value > max ? value : max : value < max ? value : max; 
            tmp = tmp.next;
        }
        System.out.println("    THE MAX PRIORITY WE GOT IS = " + max);
        return max;
    }

    public void show()
    {
        Node tmp = head;
        while(tmp != null)
        {
            System.out.print(tmp.value + " -> ");
            tmp = tmp.next;
        }   
    }


}

class Queue {

    LinkedList que;
    int front;
    int rear;
    int status = 0;

    Queue(int status)
    {
        que = new LinkedList();
        front = 0;
        rear = -1;
        this.status = status;

    }

    void Enqueue(int value, int priority)
    {       
        que.AddtotheEnd(value , priority);
        rear++;
    }

    void Dequeue()
    {
        if(rear < front)
        {
            System.out.println("\t\t\t !!! QUEUE UNDERFLOW !!!");
        }
        else
        {
            que.DeleteAtPosition(que.getPriority(this.status));
            rear--;
        }
    }
    void show()
    {
        System.out.println("\n");
       que.show();
        System.out.println("\n");
    }
}