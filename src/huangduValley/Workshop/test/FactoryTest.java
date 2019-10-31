package huangduValley.Workshop.test;

import huangduValley.Workshop.processFactory.factory.ClosedFactory;
import huangduValley.Workshop.processFactory.factory.Context;
import huangduValley.Workshop.processFactory.factory.FactoryState;
import huangduValley.Workshop.processFactory.factory.NormalFactory;

public class FactoryTest {

    public static void main(String[] args) {
	// write your code here
        Context context=new Context();
        FactoryState state=ClosedFactory.getInstance();
        context.setState(state);    //设置状态为工厂关闭
        context.runState();         //状态为关闭工厂下的运行函数
        state= NormalFactory.getInstance();
        context.setState(state);    //设置状态为工厂开启
        context.runState();         //状态为开启工厂下的运行函数
    }
}
