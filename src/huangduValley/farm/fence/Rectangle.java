package huangduValley.farm.fence;

/**
 * the rectangle shape: display using coordinates of two points on the diagonal.
 * This way is accurate and definite
 * (x1,y1,x2,y2)----(x1,y1)left-down point,(x2,y2)right-upper point
 */
public class Rectangle {
    /**
     * the method to display a rectangle with coordinate(x1,y1),(x2,y2)
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void display(int x1,int y1,int x2,int y2){
        System.out.print("Rectangle shape with left-down point ("+x1+","+y1+") and right-upper point ("+x2+","+y2+")");
    }
}
