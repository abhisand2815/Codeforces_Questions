import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TestsNumT = Integer.parseInt(br.readLine());
 
        while (TestsNumT-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            int[] a = new int[x];
            int[] b = new int[y];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < x; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < y; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
 
            int i = x - 1;
            int j = y - 1;
 
            int rows = 0;
            int cols = 0;
            int count = 0;
            long answer = 0;
 
            while (count < n + m - 1 && (i >= 0 || j >= 0)) {
 
                if (j < 0 || (i >= 0 && a[i] > b[j])) {
                    if (rows < n) {
                        answer += a[i];
                        rows++;
                        count++;
                    }
                    i--;
                }
                else if (i < 0 || b[j] > a[i]) {
                    if (cols < m) {
                        answer += b[j];
                        cols++;
                        count++;
                    }
                    j--;
                }
                else {
                    answer += a[i];
                    count++;
                    i--;
                    j--;
                }
            }
 
            System.out.println(answer);
        }
    }
}