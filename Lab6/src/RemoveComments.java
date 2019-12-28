import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class RemoveComments {
    static final int st_start = 0;
    static final int st_percent = 1;
    static final int st_iscslash = 2;
    static final int st_ccomment = 3;
    static final int st_isendstar = 4;

    public static void main(String[] args) {
        int st_current = st_start;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new DataInputStream(System.in),
                            Charset.forName("UTF-8")));

            int c;
            while ((c = reader.read()) != -1) {

                char character = (char) c;


                if (st_current == st_start ) {
                    if (character == '%') {
                        st_current = st_percent;
                    } else if (character == '/') {
                        st_current = st_iscslash;
                    } else {
                        System.out.print(character);
                    }
                } else if (st_current == st_percent ) {
                    if (character == '%'){
                        st_current = st_start;
                    }
                } else if (st_current == st_iscslash ) {
                    if (character == '*') {
                        st_current = st_ccomment;
                    } else if (character == '/') {
                        System.out.print(character);
                    } else {
                        System.out.print('/');
                        System.out.print(character);
                        st_current = st_start;
                    }
                } else if (st_current == st_ccomment ) {
                    if ( character == '*'){
                        st_current = st_isendstar;
                    }
                } else if (st_current == st_isendstar ) {
                    if (character == '/') {
                        st_current = st_start;
                    }
                } else {
                    //System.exit(1);
                    System.out.print("strange input");
                }

            }
        }catch ( IOException I){
        //System.exit(0);
        }
    }

}

