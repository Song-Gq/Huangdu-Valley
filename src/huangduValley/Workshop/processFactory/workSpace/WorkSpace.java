package huangduValley.Workshop.processFactory.workSpace;

import huangduValley.Workshop.Machine;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

public interface WorkSpace{
    //使用策略模式
    void doInit(Vector<Items> ingredients, Vector<Machine>... machineVector) throws Exception;
    Vector<Items> doProcess() throws Exception;
    void doExit();
}