package ChainOfResponsibility;

/**
 * PlantTaskHandler:the handler to handle the task in plant domain.
 */
public class PlantTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "Plant";
    }

    @Override
    protected void handle(Request request) {
        System.out.println("The task of -"+request.requestType()+"- has been handled by PlantTaskHandler.");
    }
}
