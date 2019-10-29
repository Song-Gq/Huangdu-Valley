package Workshop.ConcreteVisitor;

import Workshop.Visitor;
import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/27
 */
public class NormalRunVisitor extends Visitor {
    //private Vector<Ingredients> materialList;
    private String rawMaterialType;

    /**
     * NormalRunVisitor defines the operation of machines (Visitor)
     * @param type
     * Type of the material to be processed
     * @param materialList
     * List of the material to be processed
     */
    public NormalRunVisitor(String type/*, Vector<Plant> materialList*/){
        this.rawMaterialType = type;
        //this.materialList = materialList;
    }

    @Override
    public void visit(CleanMachine cm){
        cm.switchOn();
        cm.run();//传入Vector，需要根据不同的原料产出不同的产品，输出Vector
        cm.stop();
    }

    @Override
    public void visit(RoughProMachine rm){
        rm.switchOn();
        rm.run();
        rm.stop();
    }

    @Override
    public void visit(FineProMachine fm){
        fm.switchOn();
        fm.run();
        fm.stop();
    }

}
