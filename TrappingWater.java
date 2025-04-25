import java.util.*;
public class TrappingWater {
    public static int printTrappedWater(int height[]){
        // find max left boundary
        int left_max[]=new int[height.length];
        left_max[0]=height[0];
        for(int i=1;i<height.length;i++){
            left_max[i]=Math.max(height[i],left_max[i-1]);
        }
        // find mar right boundary
        int right_max[]=new int[height.length];
        right_max[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right_max[i]=Math.max(height[i],right_max[i+1]);
        }
        // loop
        int trappedWater=0;
        int width=1;
        for(int i=0;i<height.length;i++){
            // find waterlevel=  min(max left bound,max right bound)
           int waterlevel=Math.min(left_max[i],right_max[i]);
           // find trapped water = (waterlevel-height of bar)*width
           trappedWater+=(waterlevel-height[i])*width;
        } 
        return trappedWater;
        
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the height_Size of the bar : ");
        int height_size=sc.nextInt();
        int height[]=new int [height_size];
        System.out.print("Enter the height of the bar : ");
        for(int i=0;i<height.length;i++){
            height[i]=sc.nextInt();
        }
        int volume_Of_TrappedWater=printTrappedWater(height);
        System.out.println("Volume of Trapped water : " +volume_Of_TrappedWater);
        sc.close();
    }
}

// Time complexity = O(n)
