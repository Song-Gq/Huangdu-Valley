package huangduValley.farm.taskHandler;

import huangduValley.farm.Stdout;
import huangduValley.farm.storage.Explorer;

/**
 * WareHouseTaskHandler:the handler to handle the task in WareHouse domain.
 */
public class WareHouseTaskHandler extends TaskHandler {
    @Override
    protected String getType() {
        return "WareHouse";
    }

    @Override
    protected void handle(Request request) throws Exception {
        switch (request.requestText()) {
            case "put a private bag named Balala into warehouse": {
                Explorer explorer = Explorer.getInstance();
                explorer.backRoot();
                explorer.addBag("Balala");
                break;
            }
            case "add a trophy into warehouse": {
                Explorer explorer = Explorer.getInstance();
                explorer.into("Balala");
                explorer.addItems("Trophy", 1);
                break;
            }
            case "add 100 tons of water and 100 tons of fertilizer into MAIN space of warehouse": {
                Explorer explorer = Explorer.getInstance();
                explorer.back();
                explorer.addItems("Water", 100);
                explorer.addItems("Fertilizer", 100);
                break;
            }
        }

        Stdout.print(this, "The task of -"+request.requestType()+"- has been handled by WareHouseTaskHandler.");
    }
}
