/*
public class test {
    public static void main(String[] args) {
        int[] rect = rectangle(1, 1);
        System.out.printf("Inner %d, Outer %d",rect[0],rect[1]);
    }
    public static int[] rectangle(int width, int height){
        int x = width;
        int y = height;
        int total = x*y;
        int inner = total;
        int[] rect = new int[2];

        for(int i = 0; i<2; i++){
            inner -= (x-1)+(y-1)+1;
            x--;
            y--;

            if (inner <0){
                inner = 0;
            }

        }
        rect[0] = inner; // inner pieces
        rect[1] = total - inner; // edge pieces
        return rect;
    }
}
*/