package huangduValley.farm.taskHandler;

import huangduValley.Stdout;
import huangduValley.farm.storage.Explorer;

/**
 * StorageTaskHandler:the handler to handle the task in storage domain.
 */
public class StorageTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "storage";
    }

    @Override
    protected void handle(Request request) throws Exception {
        switch (request.requestText()) {
            case "put a private bag named Balala into storage": {
                Explorer explorer = Explorer.getInstance();
                explorer.backRoot();
                explorer.addBag("Balala");
                break;
            }
            case "add a trophy into storage": {
                Explorer explorer = Explorer.getInstance();
                explorer.into("Balala");
                explorer.addItems("Trophy", 1);
                break;
            }
            case "add 100 tons of water and 100 tons of fertilizer into MAIN space of storage": {
                Explorer explorer = Explorer.getInstance();
                explorer.back();
                explorer.addItems("Water", 100);
                explorer.addItems("Fertilizer", 100);
                break;
            }
        }

        Stdout.print(this, "The task of -"+request.requestType()+"- has been handled by StorageTaskHandler.");
    }
}
