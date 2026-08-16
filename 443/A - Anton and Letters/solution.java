import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.nextLine();
        Set<Character> set = new HashSet<>();
 
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                set.add(c);
            }
        }
 
        System.out.println(set.size());
    }
}