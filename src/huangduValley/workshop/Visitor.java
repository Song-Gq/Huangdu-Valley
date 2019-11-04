package huangduValley.workshop;


import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 * Visitor Design Pattern
 * @author Leepaangsang
 * @version 2019/10/31
 */
public abstract class Visitor {
    public abstract Vector<Items> visit(CleanMachine cm) throws Exception;
    public abstract Vector<Items> visit(RoughProMachine rm) throws Exception;
    public abstract Vector<Items> visit(FineProMachine fm) throws Exception;
}
