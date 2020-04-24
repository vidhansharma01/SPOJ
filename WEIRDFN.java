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
                long a = in.nextLong();
                long b = in.nextLong();
                long c = in.nextLong();
                long n = in.nextLong();
                PriorityQueue<Long> left = new PriorityQueue<>(new Comparator<Long>() {
                    @Override
                    public int compare(Long o1, Long o2) {
                        return o2.compareTo( o1);
                    }
                });
                PriorityQueue<Long> right = new PriorityQueue<>();
                left.add((long) 1);
                int sl = 1, sr = 0;
                long fun = 1;
                long sum = 1;
                for (int i = 2; i <= n; i++){
                    long temp = left.peek();
                    fun = a*temp + b*i + c;
                    if (fun >= mod)
                        fun %= mod;
                    sum += fun;
                    if (sl > sr){
                        if (fun < temp){
                            left.poll();
                            right.add(temp);
                            left.add(fun);
                        }else{
                            right.add(fun);
                        }
                        sr++;
                    }else{
                        temp = right.peek();
                        if (fun > temp){
                            right.poll();
                            left.add(temp);
                            right.add(fun);
                        }else{
                            left.add(fun);
                        }
                        sl++;
                    }
                }
                out.println(sum%mod);
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