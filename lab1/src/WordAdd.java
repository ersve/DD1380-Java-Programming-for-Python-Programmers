import java.util.Scanner;

public class WordAdd {


    public static void main(String[] args){
        int numOfStr = 0;
        String str2print = "";

        //Using Scanner for getting input from commandline.
        Scanner in = new Scanner(System.in);

        // Read the number of strings to be read.
        try{
            numOfStr = in.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Number Format Exception");
            System.exit(0);

        }
        // Concatenate strings
        for(int i = 0 ; i < numOfStr ; i++){
            str2print += in.next();
        }
        // close Scanner
        in.close();

        System.out.println(str2print);


    }
}
