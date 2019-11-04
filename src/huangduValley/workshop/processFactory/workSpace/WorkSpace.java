package huangduValley.workshop.processFactory.workSpace;

import huangduValley.workshop.Machine;
import huangduValley.farm.storage.Items;

import java.util.Vector;

public interface WorkSpace{
    //使用策略模式
    void doInit(Vector<Items> ingredients, Vector<Machine>... machineVector) throws Exception;
    void doProcess() throws Exception;
    void doExit();
    Vector<Items> getIngredients();
}