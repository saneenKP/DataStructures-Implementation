import java.util.*;
class StackUsingArray {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack : ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);
        int ch =0;
        do{
            System.out.println("Enter\n1. TO PUSH\n2. TO POP\n3. TO SHOW");
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

    int[] i_stck;
    int size;
    int pointer = -1;

    Stack(int i_stck)
    {
        this.i_stck = new int[i_stck];
        size = i_stck;
    }
   

    void push(int value)
    {

        try{
            pointer++;
            i_stck[pointer] = value;
        }catch(ArrayIndexOutOfBoundsException e)
        {
             System.out.println("\t\t\t !!! STACK OVERFLOW !!!");
             pointer--;
        }

            
    }

    void pop()
    {
        if(pointer<0)
        {
            System.out.println("\t\t\t !!! STACK UNDERFLOW !!!");
        }
        else
        {
            pointer--;
            size--;
        }
    }

    void show()
    {
        System.out.println("\n\n");
        for(int i = pointer ; i >= 0 ; i--)
        {
            System.out.println(i_stck[i]);
        }
        System.out.println("\n\n");
    }

}