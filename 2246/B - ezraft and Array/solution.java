import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
 
            if (n == 1) {
                sb.append(1).append('
');
            } else if (n == 2) {
                sb.append(-1).append('
');
            } else {
                List<Long> arr = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
                long S = 6L;
                while (arr.size() < n) {
                    arr.add(S);
                    S *= 2;
                }
                for (int i = 0; i < arr.size(); i++) {
                    sb.append(arr.get(i));
                    sb.append(i + 1 == arr.size() ? '
' : ' ');
                }
            }
        }
 
        System.out.print(sb);
    }
}