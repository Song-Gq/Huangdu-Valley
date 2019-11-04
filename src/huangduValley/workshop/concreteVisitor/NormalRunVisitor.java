package huangduValley.workshop.concreteVisitor;

import huangduValley.workshop.Visitor;
import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
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

    /**
     * Normal running of clean machine.
     * @param cm
     * Clean machine object.
     * @return
     * Vector of items that the clean machine produces.
     * @throws Exception
     */
    @Override
    public Vector<Items> visit(CleanMachine cm) throws Exception {
        cm.switchOn();
        Vector<Items> products = cm.run(ingredientsVector);
        cm.stop();
        return products;
    }

    /**
     * Normal running of rough processing machine.
     * @param rm
     * Rough processing machine object.
     * @return
     * Vector of items that the rough processing machine produces.
     * @throws Exception
     */
    @Override
    public Vector<Items> visit(RoughProMachine rm) throws Exception {
        rm.switchOn();
        Vector<Items> products = rm.run(ingredientsVector);
        rm.stop();
        return products;
    }

    /**
     * Normal running of fine processing machine.
     * @param fm
     * Fine processing machine object.
     * @return
     * Vector of items that the fine processing machine produces.
     * @throws Exception
     */
    @Override
    public Vector<Items> visit(FineProMachine fm) throws Exception {
        fm.switchOn();
        Vector<Items> products = fm.run(ingredientsVector);
        fm.stop();
        return products;
    }

}
