package Adapter;

public class Test {
    public static void main(String[] args){
        FenceShape fenceShape=new RectangleAdapter();
        fenceShape.display(1, 1, 2, 2);
    }
}
