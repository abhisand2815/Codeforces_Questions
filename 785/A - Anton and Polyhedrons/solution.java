import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int totalFaces = 0;
        
        for (int i = 0; i < n; i++) {
            String shape = br.readLine().trim();
            
            // Compare the first character for faster execution
            char firstChar = shape.charAt(0);
            switch (firstChar) {
                case 'T': // Tetrahedron
                    totalFaces += 4;
                    break;
                case 'C': // Cube
                    totalFaces += 6;
                    break;
                case 'O': // Octahedron
                    totalFaces += 8;
                    break;
                case 'D': // Dodecahedron
                    totalFaces += 12;
                    break;
                case 'I': // Icosahedron
                    totalFaces += 20;
                    break;
            }
        }
        
        System.out.println(totalFaces);
    }
}