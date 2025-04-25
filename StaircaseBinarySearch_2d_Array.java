public class StaircaseBinarySearch_2d_Array {
    public static boolean staircaseBinarySrch_2d_Matrix(int matrix[][],int key ){
        int row=0;
        int colm=matrix[0].length-1;
        while(row<=matrix.length && colm>=0){
            if(matrix[row][colm]==key){
                System.out.println("Found key at (" +row +"," +colm +")");
                return true;
            } else if(key<matrix[row][colm]){
                colm--;
            } else{
                row++;
            }
        }
        System.out.println("Key not Found : ");
        return false;
    } 
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},{15,25,35,75},{27,29,37,45},{32,33,39,50}};
        int key=33;
        System.out.println(staircaseBinarySrch_2d_Matrix(matrix,key));
           
    }
}
