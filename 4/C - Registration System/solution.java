import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
 
        int n = Integer.parseInt(br.readLine().trim());
        HashMap<String, Integer> database = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            String name = br.readLine().trim();
 
            if (!database.containsKey(name)) {
                // Name is not taken
                database.put(name, 1);
                out.println("OK");
            } else {
                // Name is taken; append the next available count
                int count = database.get(name);
                out.println(name + count);
                database.put(name, count + 1);
            }
        }
 
        out.flush();
    }
}