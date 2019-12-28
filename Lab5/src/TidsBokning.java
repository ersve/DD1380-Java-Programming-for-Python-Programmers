import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class TidsBokning {
    //Object to store Appointment and number of votes in
    public static class Appointment implements Comparable<Appointment> {
        private String data;
        private Integer vote = 0;

        public Appointment(){}

        public void setData(String data) {
            this.data = data;
        }

        public void setVote(Integer vote) {
            this.vote = vote;
        }

        public void incrementVote() {
            this.vote++;
        }

        public Integer getVote() {
            return this.vote;
        }

        @Override
        public int compareTo(Appointment other) {
            return this.vote-other.vote;
        }

        @Override
        public String toString() {
            return this.data+" "+this.vote;
        }
    }

    public static void main(String[] args) {
	Reader in = new Reader();
	try {
	    //Get the number of meetings and people
        String[] params = in.readLine(100).split(" ");
        int numMeetings = Integer.parseInt(params[0]);
        int numPeople = Integer.parseInt(params[1]);
        //Create the number of possible Appointments and get the data
        Appointment[] meetings = new Appointment[numMeetings];

        for (int i = 0; i <numMeetings; i++){
            meetings[i] = new Appointment();
            meetings[i].data = in.readLine(10000);
        }
        // increment the votes on each Appointment
        for (int i = 0; i <numPeople; i++){
            String[] personAvailable = in.readLine(10000).split(" ");
            for( int j = 1; j<personAvailable.length;j++){
                meetings[Integer.parseInt(personAvailable[j])].incrementVote();
            }
        }
        //Sort the voting array
        Arrays.sort(meetings,Collections.reverseOrder());
        for (Appointment meeting:meetings
             ) {
            System.out.println(meeting);
        }



    }catch (IOException e){

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
