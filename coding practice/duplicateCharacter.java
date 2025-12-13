public class duplicateCharacter {
    // Find duplicates characters
    public static void main(String[] args) {
        String input = "automation";
        String d = "";
        for (int i = 0; i <= input.length() - 1; i++) {
            for (int j = i + 1; j <= input.length() - 1; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    d += input.charAt(i);
                }
            }
        }
        System.out.println(d);
    }
}
