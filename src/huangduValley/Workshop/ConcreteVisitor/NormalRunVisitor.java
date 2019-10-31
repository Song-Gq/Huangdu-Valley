package huangduValley.Workshop.ConcreteVisitor;

import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.Visitor;
import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class NormalRunVisitor extends Visitor {
    private Vector<Items> ingredientsVector;

    /**
     * NormalRunVisitor defines the operation of machines (Visitor)
     * @param ingredientsVector
     * Vector of the ingredients to be processed
     */
    public NormalRunVisitor(Vector<Items> ingredientsVector){
        this.ingredientsVector = ingredientsVector;
    }

    @Override
    public Vector<Items> visit(CleanMachine cm) throws Exception {
        cm.switchOn();
        return cm.run(ingredientsVector);
    }

    @Override
    public Vector<Items> visit(RoughProMachine rm) throws Exception {
        rm.switchOn();
        return rm.run(ingredientsVector);
    }

    @Override
    public Vector<Items> visit(FineProMachine fm) throws Exception {
        fm.switchOn();
        return fm.run(ingredientsVector);
    }

}
