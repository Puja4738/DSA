import java .util.*;
public class Arr_Assign4 {
    public static int trappingRainwater(int height[]){
        // find left max boundary
        int left_max[]=new int[height.length];
        left_max[0]=height[0];
        for(int i=1;i<height.length;i++){
            left_max[i]=Math.max(height[i],left_max[i-1]);
        }
        // find right max boundary
        int right_max[]=new int [height.length];
        right_max[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right_max[i]=Math.max(height[i],right_max[i+1]);
        }
        // loop
        int trappedWater=0;
        int width=1;
        for(int i=0;i<height.length;i++){
            // calculate waterlevel
            int Waterlevel=Math.min(left_max[i],right_max[i]);
            // calculate trappedWater
            trappedWater+=(Waterlevel-height[i])*width;
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the height: ");
        int height_size=sc.nextInt();
        int height[]=new int[height_size];
        System.out.print("Enter the elementt of the height :");
        for(int i=0;i<height.length;i++){
            height[i]=sc.nextInt();
        }

        int volume_of_trappedWater=trappingRainwater(height);
        System.out.println("Volume of Trapped water : " +volume_of_trappedWater);
        sc.close();
    }
    
}
