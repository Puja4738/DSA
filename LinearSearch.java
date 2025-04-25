import java.util.*;
public class LinearSearch {
    public static void linearSearch(int marks[],int key){
        for(int i=0;i<marks.length;i++){
            if(marks[i]==key){
                System.out.println("Element is found at index: " +i);
            } 
        }
    }

    public static int linearSrch(int marks[],int key){
        for(int i=0;i<marks.length;i++){
            if(marks[i]==key){
                return i;
             }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the size of the array : ");
        int arr_size=sc.nextInt();
        int marks[]=new int[arr_size];
        System.out.print("Enter the element of the array :");
        for(int i=0;i<marks.length;i++){
            marks[i]=sc.nextInt();
        }
        System.out.print("Enter the search key element : ");
        int key=sc.nextInt();

        //  linearSearch( marks,key);

        int index= linearSrch(marks,key);
        if(index==-1){
            System.out.println("Element not Found :");
        } else{
            System.out.println("Element is found at index : " +index);
        }

        sc.close();

    }
    
}

// Time complexity=O(n)
