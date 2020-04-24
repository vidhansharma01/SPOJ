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
                    String s = in.nextLine();
                    Stack<Character> stack = new Stack<>();
                    String str = "";
                    for(int i = 0; i < s.length(); i++){
                        char ch = s.charAt(i);
                        if(ch >= (int)'a' && ch <= (int)'z'){
                            str += ch;
                        }else{
                            if (ch != ')'){
                                stack.push(ch);
                            }else{
                                while (!stack.isEmpty() && stack.peek() != '('){
                                    char top = stack.pop();
                                    if (top != '(')
                                        str += top;
                                }
                                stack.pop();
                            }
                        }
                    }
                    while (!stack.isEmpty()){
                        char top = stack.pop();
                        if (top != '(')
                            str += top;
                    }
                    out.println(str);
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