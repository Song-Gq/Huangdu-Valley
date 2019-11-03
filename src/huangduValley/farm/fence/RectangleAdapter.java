package huangduValley.farm.fence;

import huangduValley.farm.Stdout;

/**
 * the adapter to adapter a Rectangle method to FenceShape method
 * so that we can reuse the existing method or interface.
 */
public class RectangleAdapter implements FenceShape {
    private Rectangle adaptee;

    public RectangleAdapter(){
        this.adaptee=new Rectangle();
    }
    @Override
    public void display(int x,int y,int width,int height){
        int x1=x+width;
        int y1=y+height;

        Stdout.print(this, "We have built a fence in ...");
        adaptee.display(x, y, x1, y1);
    }
}
