import java.util.Scanner;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Class that verifies a Rorschach image
 * takes input from the commandline
 */
public class RorschachImage {
    public static void main(String[] args) {
        String[] opt;
        int rows =0;
        int cols = 0;
        boolean isRorschach = true;

        //Scanner in = new Scanner(System.in);
        //opt = in.nextLine().split(" ");
        //rows =  Integer.parseInt(opt[0]);
        //cols =  Integer.parseInt(opt[1]);
        Reader read = new Reader();
        try {
            rows = read.nextInt();
            cols = read.nextInt();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }

        //input test
        if (rows < 2 || rows > 10000) {
            System.out.println("Number of rows out of range");
            System.exit(0);
        }

        if (cols < 2 || cols > 10000) {
            System.out.println("Number of columns out of range");
            System.exit(0);
        }

        // Create image based on input
        char[][] image = new char[rows][cols];
        // append rows and clean up
        for (int idx = 0; idx < rows; idx++) {
            //image[idx] = in.nextLine().toCharArray();
            try{image[idx] = read.readLine().toCharArray();}
            catch (IOException e){
                e.printStackTrace();
                System.exit(0);
            }

        }

        for (int rowIdx = 0; rowIdx < rows ; rowIdx++) {
            for (int colIdx = 0; colIdx < (cols / 2); colIdx++) {

               //check row symmetry
                if (( image[rowIdx][colIdx] != image[rowIdx][cols - colIdx - 1])  ){
                    isRorschach = false;
                    break;

                }
            }
            if (!isRorschach) {
                break;
            }

        }

        //Print the result
        if (isRorschach) {
            System.out.println("Ja");
        } else{
            System.out.println("Nej");
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[10000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}








