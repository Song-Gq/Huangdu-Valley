package huangduValley.Workshop;


import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.Product.Product;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public abstract class Visitor {
    public abstract Vector<Items> visit(CleanMachine cm) throws Exception;
    public abstract Vector<Items> visit(RoughProMachine rm) throws Exception;
    public abstract Vector<Items> visit(FineProMachine fm) throws Exception;
}
