package huangduValley.farm;

// used to print
// pass "this" and description
public class Stdout {
    public static void print(Object obj, String description) {
        String str = obj.toString();
        int firstDotIndex = str.indexOf(".");
        int atIndex = str.lastIndexOf("@");

        // class name
        System.out.print(str.substring(firstDotIndex + 1, atIndex) + ": ");

        // object address
        System.out.print(str.substring(atIndex) + ": ");

        // method name
        System.out.print(Thread.currentThread().getStackTrace()[2].getMethodName() + "(): ");

        // action description
        System.out.println(description);
    }
}
