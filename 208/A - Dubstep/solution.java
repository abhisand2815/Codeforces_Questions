import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.nextLine();
 
        String[] words = s.split("WUB");
 
        StringBuilder ans = new StringBuilder();
 
        for (String word : words) {
            if (!word.isEmpty()) {
                if (ans.length() > 0) {
                    ans.append(" ");
                }
                ans.append(word);
            }
        }
 
        System.out.println(ans);
    }
}
