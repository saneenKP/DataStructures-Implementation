import java.util.Scanner;
class GraphsUsingAdjacencyList {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NO. OF size : ");
        int size = scanner.nextInt();
        Graph graph = new Graph(size);
        graph.feed();
        graph.show();
    }
}


class Node {

    char name;
    int value;
    Node next;

    Node(char name , int value , Node next)
    {
        this.value = value;
        this.next = next;
        this.name = name;
    }
    
}



class LinkedList {


    Node head;
    Node tail;
    int size;

    public void AddtotheEnd(char x , int value)
    {
        Node new_value = new Node(x ,value , null);
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



    public int getsize()
    {return size;}

    public void show()
    {
        Node tmp = head;
        while(tmp != null)
        {
            System.out.print(" ("+tmp.name+" , "+tmp.value+") ");
            tmp = tmp.next;
        }   
    }

}

class Graph {

    LinkedList[] node; 
    int size;

    Graph(int size)
    {
        node = new LinkedList[size];
        this.size = size;
        for(int i = 0 ; i < size ; i++)
        {
            node[i] = new LinkedList();
        }
    }

    void feed()
    {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter edge weights : ");
        for(int i = 0 ; i < size ; i ++)
        {
            System.out.println("Enter no. of size connected to "+Alphabets(i)+" : ");
            int no = scanner.nextInt();
            for(int j = 0 ; j < no ; j++)
            {
                System.out.print("Enter node name "+(j+1)+" : ");
                char name = scanner.next().charAt(0);
                System.out.print("Enter edge value : ");
                int value = scanner.nextInt();
                node[i].AddtotheEnd(name , value);
            }
        }
    }

    void show()
    {
        for(int i = 0 ; i < size ; i++)
        {
            System.out.print(Alphabets(i) + " [ ");
            node[i].show();
            System.out.println();

        }
    }

     private char Alphabets(int x)
    {return (char)(65+x);}
    


}


