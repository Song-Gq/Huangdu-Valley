package huangduValley.farm;

// used to print
// pass "this" and description
public class Stdout {
    public static void print(Object obj, String description) {
        String str = obj.toString();
        int firstDotIndex = str.indexOf(".");
        int atIndex = str.lastIndexOf("@");

        System.out.print(str.substring(firstDotIndex + 1, atIndex) + ": ");

        System.out.print(str.substring(atIndex + 1) + ": ");

        System.out.println(description);
    }
}
