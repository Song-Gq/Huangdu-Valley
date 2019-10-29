package huangduValley.farm.test;

import huangduValley.farm.fence.FenceShape;
import huangduValley.farm.fence.RectangleAdapter;

public class Test_adapter {
    public static void main(String[] args){
        FenceShape fenceShape=new RectangleAdapter();
        fenceShape.display(1, 1, 2, 2);
    }
}
