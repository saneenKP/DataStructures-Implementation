import java.util.Scanner;
class DoublyLinkedList {

    public static void main(String args[])
    {
        LinkedList linkedlist = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        do{
            System.out.println("\nEnter\n1. to add elements\n2. to show\n3. to insert At End\n4. to Insert At position\n5. to delete at end\n6. To delete at beginnnig\n7. to delete at position\n8. ge the size of list \n9. exit. ");
            ch = scanner.nextInt();
            switch(ch)
            {
                case 1 :  System.out.println("Enter element");
                          int extra = scanner.nextInt();
                          linkedlist.Addtothebeginning(extra);
                          linkedlist.show();
                          break;
   
                case 2 :  linkedlist.show();
                          break;

                case 3 :  System.out.println("Enter position of the element ");
                          int end = scanner.nextInt();
                          linkedlist.AddtotheEnd(end);
                          linkedlist.show();
        
                          break;
                
                case 4 : System.out.println("Enter element");
                         int el = scanner.nextInt();                
                         System.out.println("Enter position of the element ");
                         int p = scanner.nextInt();
                         linkedlist.Addatposition(el , p);
                         linkedlist.show();
                         break;

                case 5 : linkedlist.DeleteAtEnd();
                         linkedlist.show();
                         break;         
                
                case 6 : linkedlist.DeleteAtBeginning();
                         linkedlist.show();
                         break;

                case 7 : System.out.println("Enter position of the element ");
                         int dp = scanner.nextInt();
                         linkedlist.DeleteAtPosition(dp);
                         linkedlist.show();
                         break;

                case 8 : System.out.println("SIZE = " + linkedlist.getsize());
                         break;

                default : System.out.println("\t\t\t !!! INVALID INPUT PRESS 9 TO EXIT !!!");

            }

        }while(ch!=9);
    }

}

class Node {

    int value;
    Node next;
    Node prev;

    Node(int value , Node next , Node prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

}

class LinkedList {


    Node head;
    Node tail;
    int size;

    public void AddtotheEnd(int value)
    {
        Node new_value = new Node(value , null , null);
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
            new_value.prev = tmp;
            tmp.next = new_value;
            tail = new_value;
        }
    }

    public void Addtothebeginning(int value)
    {
        Node new_value = new Node(value , null , null);
        size++;
        if(head == null)
        {
            head = new_value;
            tail = new_value;
        }
        else
        {
           head.prev = new_value;
           new_value.next = head;
           head = new_value;
        }
    }

    public void Addatposition(int  value , int p)
    {
        Node new_value = new Node(value , null , null);
        size++;
        if(p == 1)
        {
            Addtothebeginning(value);
        }
        else if(p == size)
        {
            AddtotheEnd(value);
        }
        else if(p > size || p < 1)
        {
            System.out.println("\t\t\t  INVALID POSITION ");
        }
        else
        {
            Node tmp = head;
            int i = 2;
            while(i < p)
            {
                tmp = tmp.next;
                i++;
            }
            new_value.prev = tmp;
            new_value.next = tmp.next;
            tmp.next.prev = new_value;
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
        tail = tmp1;
        size--;
    }

    public void DeleteAtBeginning()
    {
        head.next.prev = null;
        head = head.next;
        size--;
    }

    public void DeleteAtPosition(int p)
    {
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
            Node tmp = head;
            int i = 2;
            while(i < p)
            {
                tmp = tmp.next;
                i++;
            }
            tmp.next.next.prev = tmp.next;
            tmp.next = tmp.next.next;
        }

       
    }

    public int getsize()
    {return size+1;}

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
        if(head == null)
            System.out.println("\t\t\t EMPTY LIST!!!!!");

        else
        {
            Node tmp = head;
            while(tmp != null)
            {
                System.out.print(tmp.value + " -> ");
                tmp = tmp.next;
            }
        }   
    }

}