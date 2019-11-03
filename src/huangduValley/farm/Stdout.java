package huangduValley.farm;

// used to print
// pass "this" and description
public class Stdout {
    public static void print(Object obj, String description) {
        String str = obj.toString();
        int firstDotIndex = str.indexOf(".");
        int atIndex = str.lastIndexOf("@");

        // class name
        fillSpace(str.substring(firstDotIndex + 1, atIndex) + ": ", 35);

        // object address
        fillSpace(str.substring(atIndex) + ": ", 15);

        // method name
        fillSpace(Thread.currentThread().getStackTrace()[2].getMethodName() + "(): ", 20);

        // action description
        System.out.println(description);
    }

    // fill the output with space
    private static void fillSpace(String str, int maxLength) {
        System.out.printf("%-" + maxLength + "s", str);
    }
}
