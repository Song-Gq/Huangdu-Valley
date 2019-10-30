package Workshop.ConcreteVisitor;

import Workshop.Ingredients;
import Workshop.Product.Product;
import Workshop.Visitor;
import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/27
 */
public class NormalRunVisitor extends Visitor {
    private Vector<Ingredients> ingredientsVector;

    /**
     * NormalRunVisitor defines the operation of machines (Visitor)
     * @param ingredientsVector
     * Vector of the ingredients to be processed
     */
    public NormalRunVisitor(Vector<Ingredients> ingredientsVector){
        this.ingredientsVector = ingredientsVector;
    }

    @Override
    public Vector<Product> visit(CleanMachine cm){
        cm.switchOn();
        return cm.run(ingredientsVector);//传入Vector，需要根据不同的原料产出不同的产品，输出Vector
        //cm.stop();
    }

    @Override
    public Vector<Product> visit(RoughProMachine rm){
        rm.switchOn();
        return rm.run(ingredientsVector);
        //rm.stop();
    }

    @Override
    public Vector<Product> visit(FineProMachine fm){
        fm.switchOn();
        return fm.run(ingredientsVector);
        //fm.stop();
    }

}
