package huangduValley.farm.taskHandler;

/**
 * ShopTaskHandler:the handler to handle the task in shop domain.
 */
public class ShopTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "Shop";
    }

    @Override
    protected void handle(Request request) {
        System.out.println("The task of -"+request.requestType()+"- has been handled by ShopTaskHandler.");
    }
}
