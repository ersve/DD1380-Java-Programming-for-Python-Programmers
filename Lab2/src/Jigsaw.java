import java.util.Scanner;

public class Jigsaw {

    public static final int YEAR_IN_SECONDS=31536000;
    public static final int DAY_IN_SECONDS = 86400;
    public static final int HOUR_IN_SECONDS =3600;
    public static final int MINUTES_IN_SECONDS = 60;
    public static final int[] timeMeasure = {YEAR_IN_SECONDS,DAY_IN_SECONDS,HOUR_IN_SECONDS,MINUTES_IN_SECONDS,1};

    public static void main(String[] args) {
        //Variable declarations
        Double seconds;
        Double k = 0.0; // temporary variable for storing time for edge pieces.
        Double n = 0.0; // temporary variable for storing time for inner pieces.
        String valueString ="";
        int[] timeArray = new int[timeMeasure.length];

        //Create a scanner to read input from STDIN

        Scanner in = new Scanner(System.in);

        //Read the number of pieces in x-direction
        int x = in.nextInt();
        if (x<1 || x>100){
            System.out.println("Number of edge pieces in x-direction out of range");
            System.exit(0);
        }

        //Read the number of pieces in y
        int y = in.nextInt();
        if (y<1 || y>100){
            System.out.println("Number of pieces in y-direction out of range");
            System.exit(0);
        }

        //calculate the number of pieces
        int[] pieces = rectangle(x,y); //element 0 is inner, 1 is edge


        //Calculate the number of seconds
        for( int i = 1; i<pieces[1]+1; i++ ){
            //System.out.println(Math.pow(1.001,i));
            k = k + Math.pow(1.001,i);
            //System.out.println(k);


        }

        for( int j = 1; j<pieces[0]+1; j++ ){
            //System.out.println(Math.pow(1.01,j));
            n = n + Math.pow(1.01,j);
            //System.out.println(n);
        }


        seconds = k+n;

        // Calculate the time according to required measures
        for(int t = 0; t<timeMeasure.length; t++){
            timeArray[t] = (int)(seconds/timeMeasure[t]);
            seconds = seconds%timeMeasure[t];
            if(t<timeMeasure.length) {
                valueString +=  timeArray[t] + " ";
            }else{
                valueString +=  timeArray[t];
            }
        }
        //Print out the results:
        System.out.println(valueString);


        }

    /**
     * Function that calculates the number of squares inside a box made up of width times height number of
     * equally shaped squares. The function makes use of the fact that a 3x3 square fit within a 5x5, 5x5 in a 7x7 etc.
     * same applies for the even numbers.
     *
     * @param width (int) is the number of cubes in x-direction,
     * @param height (int) is the number of cubes in the y-direction
     * @return a vector consisting of [number of inner cubes, number of edge cubes]
     */
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

