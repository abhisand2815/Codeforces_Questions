import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            String team = sc.next();
            map.put(team, map.getOrDefault(team, 0) + 1);
        }
 
        String winner = "";
        int max = 0;
 
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                winner = entry.getKey();
            }
        }
 
        System.out.println(winner);
    }
}