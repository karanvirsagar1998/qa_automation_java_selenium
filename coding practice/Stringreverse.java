public class Stringreverse {
    public static void main(String[] args) {
        String s = "Selenium";
        String o = "";

        // use loop
        for (int i = s.length() - 1; i >= 0; i--) {
            o += s.charAt(i);
        }
        System.out.println(o);

        // StringBuilder
        String sb = new StringBuilder(s).reverse().toString();
        System.out.println(sb);
    }
}