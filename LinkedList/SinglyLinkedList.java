//TIME COMPLEXITY.
    /* SEARCH         O(n)
       INSERT AT HEAD O(1)
       INSERT AT TAIL O(1)
       REMOVE HEAD    O(1)
       REMOVE TAIL    O(n)
       REMOVE POS     O(n)*/ 
import java.util.Scanner;
class SinglyLinkedList {

    public static void main(String args[])
    {
        LinkedList linkedlist = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        do{
            System.out.println("\nEnter\n1. to add elements\n2. to show");
            ch = scanner.nextInt();
            switch(ch)
            {
               case 1 :  System.out.println("Enter element");
                         int extra = scanner.nextInt();
                         linkedlist.Addtothebeginning(extra);
                         break;
   
               case 2 : linkedlist.show();
                        break;
               case 3 :  System.out.println("Enter position of the element ");
                           int r = scanner.nextInt();
                          linkedlist.AddtotheEnd(r);
                          break;
                case 4 : 
                            System.out.println("Enter element");
                            int el = scanner.nextInt();                
                            System.out.println("Enter position of the element ");
                           int p = scanner.nextInt();

                          linkedlist.Addatposition(el , p);
                
            } 
        }while(ch!=5);
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
    /*String value;
    float value;
    char value;


   
    Node(float value , Node next)
    {
        this.value = value;
        this.next = next;
    }
    Node(String value , Node next)
    {
        this.value = value;
        this.next = next;
    }
    Node(char value , Node next)
    {
        this.value = value;
        this.next = next;
    }*/

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

    public void Addtothebeginning(int value)
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
            new_value.next = head;
            head = new_value;
        }
    }

    public void Addatposition(int  value , int p)
    {
        Node new_value = new Node(value , null);
        size++;
        if(p == 1)
        {
            new_value.next = head;
            head = new_value;
        }
        else if(p == size)
        {
            Node tmp = head;
            while(tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = new_value;
            tail = new_value;
        }
        else
        {
            Node tmp1 = head;
            Node tmp2 = head.next;
            int i = 2;
            while(i < p)
            {
                tmp2 = tmp2.next;
                tmp1 = tmp1.next;
                i++;
            }
            tmp1.next = new_value;
            new_value.next = tmp2;
        }
    }


    public void add(String value)
    {

    }
    public void add(char value)
    {

    }
    public void add(float value)
    {

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