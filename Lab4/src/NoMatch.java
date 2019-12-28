
import java.util.ArrayList;
import java.util.List;

// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class NoMatch {
    private static int[] counter(String text, String pattern) {

        int count[] = new int[text.length()];
        int numPos = text.length() - pattern.length() + 1;

        for (int i = 0; i < numPos; i++) {
            int pntr = 0;
            while (pntr < pattern.length() && text.charAt(i + pntr) != pattern.charAt(pntr)) {
                pntr++;
            }
            count[i] = pntr;
        }
        return count;
    }

    private static List<Integer>  check(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int count[] = counter(text, pattern);
        for (int i  = 0; i< text.length(); i++) {
            if (count[i] == pattern.length()) {
                result.add(i+1);
            }
        }
        if (result.isEmpty()){
            result.add(-1);
        }
        return result;
    }

    public static void main (String []args){
        Reader in = new Reader();
        try {
            String text1 = in.readLine(10000);
            String pattern1 = in.readLine(50);
            if (pattern1.length()==0 || pattern1.length()>text1.length()) {
                throw  new IOException();
            }

            List<Integer> result = check(text1, pattern1);

            for (int element : result) {
                System.out.print(element + " ");

            }

        }catch (IOException e) {
            System.out.println(-1);
            System.exit(0);
        }


    }

    static class Reader
    {
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

        public String readLine(int max) throws IOException
        {
            byte[] buf = new byte[max]; // line length
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
