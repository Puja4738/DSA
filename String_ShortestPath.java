public class String_ShortestPath {
    public static float getShortestPath(String path){
        System.out.print("The Shortest Path is : ");
        int x=0 ,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            // south
            if(dir=='S'){
                y--;
            } else if(dir=='N'){
                y++;
            } else if(dir=='W'){
                x--;
            } else{
                x++;
            }
        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String[] args) {
        String path="WNEENESENN";
        System.out.println(getShortestPath(path));
    }
}

// Time complexity =  O(n)
