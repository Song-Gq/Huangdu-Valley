package huangduValley.Workshop.processFactory.factory;

import huangduValley.farm.storage.Items;

import java.util.Vector;

//使用状态模式
public interface FactoryState{
    public Vector<Vector<Items>> runFactory() throws Exception;
}