import java.util.Scanner;
class GraphsUsingAdjacencyMatrix
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER NO. OF NODES : ");
        int nodes = scanner.nextInt();
        Graph graph = new Graph(nodes);
        graph.feed();
        graph.show();
        

    }
   
}

class Graph {


    int[][] adjmatrix;
    int nodes;
    Graph(int nodes)
    {
        adjmatrix = new int[nodes][nodes];
        this.nodes = nodes;
    }

    void feed()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter edge weights : ");
        for(int i = 0 ; i < nodes ; i ++)
        {
            for(int j = 0 ; j < nodes ; j++)
            {
                System.out.println(Alphabets(i)+" ----> "+Alphabets(j)+" : ");
                adjmatrix[i][j] = scanner.nextInt();
            }
        }
        
    }

    void show()
    {
        System.out.print("     ");
        for(int i = 0 ; i < nodes ; i++)
        {
            System.out.print(Alphabets(i)+"    ");
        }
        System.out.println("\n");
        for(int i = 0 ; i < nodes ; i ++)
        {
            System.out.print(Alphabets(i)+"    ");
            for(int j = 0 ; j < nodes ; j++)
            {
                System.out.print(adjmatrix[i][j]+"    ");
            }
            System.out.println();

        }

    }

    private char Alphabets(int x)
    {return (char)(65+x);}
    

}
