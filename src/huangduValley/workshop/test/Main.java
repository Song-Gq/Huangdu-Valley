package huangduValley.workshop.test;

import huangduValley.workshop.concreteVisitor.NormalRunVisitor;
import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.workshop.wareHouse.WareHouse;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public class Main {
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

        int leng = wareHouse.getProductsVector().size();
        for (int i = 0; i < leng; i++) {
            Vector vector = wareHouse.getProductsVector().elementAt(i);
            for (int j = 0; j < vector.size(); j++) {
                System.out.print(vector.elementAt(j)+" ");
            }
            System.out.println();
        }
    }
}
