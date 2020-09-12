import java.util.*;
class QueueUsingList {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Queue que = new Queue();
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

class Node {

    int value;
    Node next;

    Node(int value , Node next)
    {
        this.value = value;
        this.next = next;
    }
}

class Queue {

    LinkedList que;
    int front;
    int rear;

    Queue()
    {
        que = new LinkedList();
        front = 0;
        rear = -1;
    }

     void Enqueue(int value)
    {
        rear++;
        que.AddtotheEnd(value);
    }

    void Dequeue()
    {

        try{
            que.DeleteAtBeginning();
            front++;
        }catch(NullPointerException e)
        {System.out.println("QUEUE UNDERFLOW");}
       
    }

    void show()
    {que.show();}

}

class LinkedList {


    Node head;
    Node tail;
    int size;

    public void AddtotheEnd(int value)
    {
        Node new_value = new Node(value , null);
        size++;
        if(head == null)
        {
            head = new_value;
            tail = new_value;
        }
        else
        {
            Node tmp = head;
            while(tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = new_value;
            tail = new_value;
        }
    }
    public void DeleteAtBeginning()
    {
        head = head.next;
        size--;
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
