import java.util.HashMap;
import java.util.Map;

public class duplicateCharacter {
    // Find duplicates characters
    public static void main(String[] args) {
        String input = "automation";

        // using loops
        String d = "";
        for (int i = 0; i <= input.length() - 1; i++) {
            for (int j = i + 1; j <= input.length() - 1; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    d += input.charAt(i);
                }
            }
        }
        System.out.println(d);

        // using MAPS
        HashMap<Character, Integer> inputMap = new HashMap<>();
        // Step 1: Count frequency of each character
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Print characters that appear exactly 2 times
        System.out.println("Characters appearing exactly twice:");
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println(entry.getKey());
            }
        }
    }
}
