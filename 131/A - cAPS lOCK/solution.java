import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.nextLine();
 
        boolean valid = true;
 
        for (int i = 1; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                valid = false;
                break;
            }
        }
 
        if (valid) {
            StringBuilder ans = new StringBuilder();
 
            for (char ch : s.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    ans.append(Character.toLowerCase(ch));
                } else {
                    ans.append(Character.toUpperCase(ch));
                }
            }
 
            System.out.println(ans);
        } else {
            System.out.println(s);
        }
    }
}