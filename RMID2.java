import java.util.*;
import java.io.*;
class Codechef {
    public static void main(String args[]){
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }
    static long mod = (int)1e9+7;

    static class Task{

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while(T-->0){
                PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                PriorityQueue<Integer> right = new PriorityQueue<>();
                while(true){
                    int N = in.nextInt();
                    if(N == 0)
                        break;
                    if (N == -1){
                        if(left.size() == right.size()){
                            out.println(left.peek());
                            left.poll();
                            left.add(right.poll());
                        }else if (left.size() > right.size()){
                            out.println(left.poll());
                        }
                    }else{
                        if (left.isEmpty() && right.isEmpty())
                            left.add(N);
                        else if(left.size() > 0 && right.size() == 0){
                            if(N >= left.peek())
                                right.add(N);
                            else{
                                right.add(left.poll());
                                left.add(N);
                            }
                        }else if(left.size() == right.size()){
                            if (N <= right.peek()){
                                left.add(N);
                            }else{
                                left.add(right.poll());
                                right.add(N);
                            }
                        }else if(left.size() > right.size()){
                            if (N < left.peek()){
                                right.add(left.poll());
                                left.add(N);
                            }else{
                                right.add(N);
                            }
                        }
                    }
                }
            }

        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}