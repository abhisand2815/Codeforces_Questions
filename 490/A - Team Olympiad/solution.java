import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Integer> pe = new ArrayList<>();
 
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
 
            if (x == 1) p.add(i);
            else if (x == 2) m.add(i);
            else pe.add(i);
        }
 
        int teams = Math.min(p.size(), Math.min(m.size(), pe.size()));
 
        System.out.println(teams);
 
        for (int i = 0; i < teams; i++) {
            System.out.println(p.get(i) + " " + m.get(i) + " " + pe.get(i));
        }
    }
}