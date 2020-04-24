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
    //            int T = in.nextInt();
    //            while (T-->0){
    //
    //            }
                while (true){
                    int N = in.nextInt();
                    if(N==0)
                        break;
                    long a[] = new long[N];
                    for (int i = 0 ; i < N; i++)
                        a[i] = in.nextLong();
                    Stack<Integer> stack = new Stack<>();
                    long max_ans = 0;
                    long area = 0;
                    int i = 0;
                    for (i = 0 ; i < N; ) {
                        if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
                            stack.push(i++);
                        } else {
                            int top = stack.pop();
                            if (stack.isEmpty())
                                area = a[top] * i;
                            else
                                area = a[top] * (i - stack.peek() - 1);
                            if (area > max_ans)
                                max_ans = area;
                        }
                    }
                    while(!stack.isEmpty()){
                        int top = stack.pop();
                        if (stack.isEmpty())
                            area = a[top] * i;
                        else
                            area = a[top] * (i - stack.peek() - 1);
                        if (area > max_ans)
                            max_ans = area;
                    }
                    out.println(max_ans);
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