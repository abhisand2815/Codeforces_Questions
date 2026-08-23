import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        boolean[] prime = new boolean[1000001];
        Arrays.fill(prime, true);
 
        prime[0] = false;
        prime[1] = false;
 
        for (int i = 2; i * i <= 1000000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
 
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        StringBuilder ans = new StringBuilder();
 
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            long root = (long) Math.sqrt(x);
 
            if (root * root == x && prime[(int) root]) {
                ans.append("YES
");
            } else {
                ans.append("NO
");
            }
        }
 
        System.out.print(ans);
    }
}