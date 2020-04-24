    import java.util.*;
    import java.io.*;
    class Main {
        public static void main(String args[]){
            InputReader in = new InputReader();
            PrintWriter out = new PrintWriter(System.out);
            Task solver = new Task();
            solver.solve(1, in, out);
            out.close();
        }
        static int mod = (int)1e9+7;
     
        static class Task{
     
            public void solve(int testNumber, InputReader in, PrintWriter out) {
                while(true){
                    String s = in.nextLine();
                    if(s.equals("42")){
                        break;
                    }else{
                        out.println(s);
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