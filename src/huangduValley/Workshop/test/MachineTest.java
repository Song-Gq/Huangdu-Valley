package huangduValley.Workshop.test;

import huangduValley.Workshop.ConcreteVisitor.NormalRunVisitor;
import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.workSpace.SequentialProcessing;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class MachineTest {
    public static void main(String[] args) throws Exception {

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.setMaxSize(10);

        CleanMachine cm = new CleanMachine("1st CM");
        CleanMachine cm2 = (CleanMachine) cm.clone();
        RoughProMachine rm = new RoughProMachine("1st rm");
        FineProMachine fm = new FineProMachine("1st fm");

        wareHouse.release(cm);
        wareHouse.release(rm);
        wareHouse.release(fm);

        Vector<Items> ingredientsVector = new Vector<>();
        ingredientsVector.add(new Ingredients("rice", 10));
        ingredientsVector.add(new Ingredients("potato", 20));

        cm.accept(new NormalRunVisitor(ingredientsVector));


    }
}
