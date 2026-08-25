import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int left = 0;
        int right = n - 1;
 
        int sereja = 0;
        int dima = 0;
        boolean turnSereja = true;
 
        while (left <= right) {
            int value;
 
            if (a[left] > a[right]) {
                value = a[left];
                left++;
            } else {
                value = a[right];
                right--;
            }
 
            if (turnSereja) {
                sereja += value;
            } else {
                dima += value;
            }
 
            turnSereja = !turnSereja;
        }
 
        System.out.println(sereja + " " + dima);
    }
}