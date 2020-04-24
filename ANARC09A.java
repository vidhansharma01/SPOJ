    import java.util.*;
    import java.io.*;
    public class Main {
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
    //            int T = in.nextInt();
    //            while (T-->0){
    //
    //            }
                int t = 0;
                while (true){
                    String s = in.nextLine();
                    if (s.startsWith("-"))
                        break;
                    t++;
                    int res = 0;
                    int c = 0;
                    int r = 0;
                    char ch[] = s.toCharArray();
                    for (int i = 0; i < s.length(); i++){
                        if (ch[i] == '{')
                            c++;
                        if (ch[i] == '}' && c > 0)
                            c--;
                        else if (ch[i] == '}' && c <= 0){
                            r++; c++;
                        }
                    }
                    res = r + c/2;
                    out.println(t + ". " + res);
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