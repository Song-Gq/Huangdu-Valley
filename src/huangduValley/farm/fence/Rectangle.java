package huangduValley.farm.fence;

import huangduValley.Stdout;

/**
 * @pattern Adapter Pattern
 * the rectangle shape: display using coordinates of two points on the diagonal.
 * This way is accurate and definite
 * (x1,y1,x2,y2)----(x1,y1)left-down point,(x2,y2)right-upper point
 */
class Rectangle {
    /**
     * the method to display a rectangle with coordinate(x1,y1),(x2,y2)
     * @param x1:x coordinate of left-down point
     * @param y1:y coordinate of left-down point
     * @param x2:x coordinate of right-upper point
     * @param y2:y coordinate of right-upper point
     */
    void display(int x1, int y1, int x2, int y2){
        Stdout.print(this, "Rectangle shape with left-down point ("+x1+","+y1+") and right-upper point ("+x2+","+y2+")");
    }
}
