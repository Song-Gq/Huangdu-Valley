package huangduValley.farm.taskHandler;

/**
 * AnimalTaskHandler:the handler to handle the task in animal domain.
 */
public class AnimalTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "Animal";
    }

    @Override
    protected void handle(Request request) {
        System.out.println("The task of -"+request.requestType()+"- has been handled by AnimalTaskHandler.");
    }
}
