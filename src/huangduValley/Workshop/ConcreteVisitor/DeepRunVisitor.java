package huangduValley.Workshop.ConcreteVisitor;

import huangduValley.Stdout;
import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.Visitor;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class DeepRunVisitor extends Visitor {
    private Vector<Items> ingredientsVector;

    /**
     * NormalRunVisitor defines the operation of machines (Visitor)
     * @param ingredientsVector
     * Vector of the ingredients to be processed
     */
    public DeepRunVisitor(Vector<Items> ingredientsVector){
        this.ingredientsVector = ingredientsVector;
    }

    /**
     * Deep running of clean machine.
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
        Stdout.print(this, "Redoing cleaning!");
        products = cm.run(products);
        cm.stop();
        return products;
    }

    /**
     * Deep running of rough processing machine.
     * @param rm
     * Rough processing machine object.
     * @return
     * Vector of items that the rough processing machine.
     * @throws Exception
     */
    @Override
    public Vector<Items> visit(RoughProMachine rm) throws Exception {
        rm.switchOn();
        Vector<Items> products = rm.run(ingredientsVector);
        Stdout.print(this, "Redoing rough processing!");
        products = rm.run(products);
        rm.stop();
        return products;
    }

    /**
     * Deep running of fine processing machine.
     * @param fm
     * Fine processing machine object.
     * @return
     * Vector of items that the Fine processing machine.
     * @throws Exception
     */
    @Override
    public Vector<Items> visit(FineProMachine fm) throws Exception {
        fm.switchOn();
        Vector<Items> products = fm.run(ingredientsVector);
        Stdout.print(this, "Redoing fine processing!");
        products = fm.run(products);
        fm.stop();
        return products;
    }

}
