// This is a programme to implement dynamic array
 // This logic is to first create an array with initial element and a specific pointer;

 // then if there needs to be more elements and if the array is full . Create another array with double the pointer of the initial array
 // and then load the extra elements to that array.

 // Repeat this process whenever an array is full.




import java.util.*;
class dynamicarray{

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nLoad the elements of the initial array : ");
        System.out.println("\nEnter the pointer : ");
        int size  = scanner.nextInt();
        int[] initial_aray = new int[size];
        for(int i =0 ; i < size ; i++)
        {
            System.out.print("Enter element "+ (i+1)+" : ");
            initial_aray[i] = scanner.nextInt();
        }
        System.out.println("\t\t\tYour initial array = " + Arrays.toString(initial_aray));
        Darray darray = new Darray(initial_aray);
        int ch=0;
        do{
            System.out.println("Enter\n1. to add more elements\n2. to show current array\n3. remove element from a position\n4. exit");
            ch = scanner.nextInt();
            switch(ch)
            {
                case 1 :  System.out.println("Enter element");
                        int extra = scanner.nextInt();
                        darray.add(extra , 0);
                        break;

                case 2 : darray.show();
                         break;

                case 3 :  System.out.println("Enter position of the element to remove ");
                        int r = scanner.nextInt();
                        darray.remove(r);
                        break;
         

                case 4 : break; 

                default : System.out.println("\t\t\t!!! You have given the wrong input choose an option or Press 3 to exit !!!") ;
            }

        }while(ch!=4);
    }

    

}

class Darray {

    int[] initial_array;
    int pointer = 0;

    Darray(int[] initial_array)
    {
        this.initial_array = initial_array;
        this.pointer = initial_array.length -1;
    }

    public void add(int x  , int flag)
    {
        if(pointer < initial_array.length-1)
        {
            initial_array[++pointer] = x;
            System.out.println(flag==1?"\n\t\t\tAs your array got full ":"");
            System.out.println(flag==1?"\n\t\t\t your array changed to = " + Arrays.toString(initial_array):"");
            
        }
        else
        {
            create_double();
            add(x , 1);
        }
    }    

    private void create_double()
    {
        int[] double_array = new int[this.initial_array.length*2];
        double_array = copy_elements(this.initial_array , double_array , null);
        this.initial_array = double_array;

    }

    private int[] copy_elements(int[] filled , int[] empty , String exception)
    {
        boolean remove_flag = exception != null;
        for(int i = 0 , j = 0 ; i < empty.length && j < filled.length ; i++)
        {

            if(remove_flag)
                if(i == Integer.parseInt(exception))
                    continue;
                  
             
            empty[j] = filled[i];
            j++;

        }

        return empty;
       
    }

    public void show()
    {
        System.out.println("\n \t\t\tyour current array = " + Arrays.toString(initial_array));
    }

    public void remove(int position)
    {
        if(pointer >= 0)
        {
            System.out.println("POSITION = " + position);
            int[] tmp = new int[initial_array.length-1];
            initial_array = copy_elements(initial_array , tmp , Integer.toString(position));
            System.out.println("\n\t\t\t your array changed to = " + Arrays.toString(initial_array));
            pointer--;
        }
        else
        {
            System.out.println("\t\t\t!!!EMPTY ARRAY!!!");
        }
    }
}