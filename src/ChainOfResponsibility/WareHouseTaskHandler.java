package ChainOfResponsibility;

/**
 * WareHouseTaskHandler:the handler to handle the task in WareHouse domain.
 */
public class WareHouseTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "WareHouse";
    }

    @Override
    protected void handle(Request request) {
        System.out.println("The task of -"+request.requestType()+"- has been handled by WareHouseTaskHandler.");
    }
}
