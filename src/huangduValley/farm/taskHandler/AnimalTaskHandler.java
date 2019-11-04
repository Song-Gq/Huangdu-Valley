package huangduValley.farm.taskHandler;

import huangduValley.Stdout;

/**
 * @pattern Chain Of Responsibility Pattern
 * AnimalTaskHandler:the handler to handle the task in animal domain.
 */
public class AnimalTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "Animal";
    }

    @Override
    protected void handle(Request request) {
        Stdout.print(this, "The task of -"+request.requestType()+"- has been handled by AnimalTaskHandler.");
    }
}
