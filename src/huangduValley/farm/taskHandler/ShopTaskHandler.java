package huangduValley.farm.taskHandler;

import huangduValley.farm.Stdout;

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
        Stdout.print(this, "The task of -"+request.requestType()+"- has been handled by ShopTaskHandler.");
    }
}
