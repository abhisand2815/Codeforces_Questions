import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            long sum = 0;
            Map<Integer, Integer> freq = new HashMap<>();
 
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
            }
 
            // find value with max frequency
            int bestVal = 0, maxCount = 0;
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                if (e.getValue() > maxCount) {
                    maxCount = e.getValue();
                    bestVal = e.getKey();
                }
            }
 
            int half = (n + 1) / 2; // ceil(n/2)
 
            long ans;
            if (maxCount <= half) {
                ans = sum;
            } else {
                long wasted = 2L * maxCount - n - 2;
                ans = sum - wasted * bestVal;
            }
 
            sb.append(ans).append("
");
        }
 
        System.out.print(sb);
    }
}