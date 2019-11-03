package huangduValley.farm.test;

import huangduValley.farm.taskHandler.*;

/**
 * class to test the pattern
 * @author zdy
 */
public class Test_ChainOfResponsibility {
    public static void main(String[] args) throws Exception {
        Request request1=new Request("harvest the plant");
        Request request2=new Request("feed the Animal");
        Request request3=new Request("store in the storage");
        Request request4=new Request("do nothing.");

        TaskHandler rootHandler=new PlantTaskHandler();
        rootHandler.setNextHandler(new AnimalTaskHandler());
        rootHandler.setNextHandler(new ShopTaskHandler());
        rootHandler.setNextHandler(new ToolsTaskHandler());
        rootHandler.setNextHandler(new StorageTaskHandler());

        rootHandler.handleRequest(request1);
        rootHandler.handleRequest(request2);
        rootHandler.handleRequest(request3);
        rootHandler.handleRequest(request4);
    }
}
