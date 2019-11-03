package huangduValley.farm.taskHandler;

import huangduValley.Stdout;

/**
 * ToolsTaskHandler:the handler to handle the task in tools domain.
 */
public class ToolsTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "Tools";
    }

    @Override
    protected void handle(Request request) {
        Stdout.print(this, "The task of -"+request.requestType()+"- has been handled by ToolsTaskHandler.");
    }
}
