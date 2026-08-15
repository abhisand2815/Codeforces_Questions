import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
 
        while (T-- > 0) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());
 
            if (k > m) {
                out.append("NO
");
                continue;
            }
 
            out.append("YES
");
 
            long[] pref = new long[n + 1];
 
            for (int i = 0; i <= n; i++) {
                pref[i] = i % k;
            }
 
            for (int i = 1; i <= n; i++) {
                long x = (pref[i] - pref[i - 1] + m) % m;
                if (x == 0) x = m;
                out.append(x).append(' ');
            }
 
            out.append('
');
        }
 
        System.out.print(out);
    }
}