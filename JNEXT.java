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
                int T = in.nextInt();
                while (T-->0){
                    int N = in.nextInt();
                    int a[] = new int[N];
                    for (int i = 0; i < a.length; i++)
                        a[i] = in.nextInt();
                    int i = 0;
                    for (i = a.length - 2; i >= 0; i--){
                        if (a[i] < a[i+1])
                            break;
                    }
                    if (i == -1) {
                        out.println(-1);
                        continue;
                    }
                    int j = 0;
                    for (j = i+1; j < a.length; j++){
                        if (a[j] <= a[i])
                            break;
                    }
    //                swap(a[i], a[j-1]);
                    {
                        int s = a[i];
                        a[i] = a[j-1];
                        a[j-1] = s;
                    }
                    Arrays.sort(a, i+1, a.length);
                    for (int x : a)
                        out.print(x);
                    out.println();
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
} 