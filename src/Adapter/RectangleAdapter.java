package Adapter;

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

        adaptee.display(x, y, x1, y1);
    }
}
