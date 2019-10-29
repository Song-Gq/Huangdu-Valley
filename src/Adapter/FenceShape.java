package Adapter;

/**
 * The interface used by client to display the outline of fence
 * it requires coordinate of the left-down point and width and height of fence which is defined by client.
 */

public interface FenceShape {
    public void display(int x,int y,int width,int height);
}
