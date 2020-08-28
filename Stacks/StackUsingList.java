import java.util.*;
class StackUsingList {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        int ch =0;
        do{
            System.out.println("Enter\n1. TO PUSH\n2. TO POP\n3. TO SHOW\n4. exit");
            ch = scanner.nextInt();
            
            switch(ch)
            {
                case 1 : System.out.print("Enter an element to push : ");
                            int el = scanner.nextInt();
                            stack.push(el);
                            stack.show();
                            break;

                case 2 : stack.pop();
                            stack.show();
                            break;

                case 3 : stack.show();
                            break;
            }
        }while(ch!=4);
    }

}


class Stack 
{

    LinkedList list = new LinkedList();
    void push(int value)
    {list.AddtotheEnd(value);}
    void pop()
    {
        System.out.println(list.getsize());
        if(list.getsize()!=1)
            list.DeleteAtEnd();
        else
            System.out.println("\t\t\t !!! STACK UNDERFLOW !!!");

    }
    void show()
    {list.show();}

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
     
     
    public void DeleteAtEnd()
    {
        size--;
        System.out.println("size = " + size);
        if(size == 1)
            head=null;
        else
        {
            Node tmp1 = head;
            while(tmp1.next.next != null)
            {
                tmp1 = tmp1.next;
            }
            tmp1.next = null;
            tail = tmp1;
        }
    }
   
    public int getsize()
    {return size;}

    public void show()
    {
        Node tmp = head;
        int[] str_array = new int[this.size];
        int i = this.size-1;
        while(tmp != null)
        {
            str_array[i] = tmp.value;
            tmp = tmp.next;
            i--;
        }   

        for(int j = 0 ; j < this.size ; j++)
        {
            System.out.println(str_array[j]);
        }
    }

}