import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int Y = sc.nextInt();
        int W = sc.nextInt();
 
        int favorable = 6 - Math.max(Y, W) + 1;
        int gcd = gcd(favorable, 6);
 
        System.out.println((favorable / gcd) + "/" + (6 / gcd));
    }
 
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}