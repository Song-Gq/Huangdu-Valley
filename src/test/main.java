package test;

import Workshop.ConcreteVisitor.NormalRunVisitor;
import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;
import Workshop.Ingredients;
import Workshop.WareHouse.WareHouse;

import java.awt.desktop.SystemSleepEvent;
import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class main {
    public static void main(String[] args) {

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.setMaxSize(10);

        CleanMachine cm = new CleanMachine("1st CM");
        RoughProMachine rm = new RoughProMachine("1st rm");
        FineProMachine fm = new FineProMachine("1st fm");

        wareHouse.release(cm);
        wareHouse.release(rm);
        wareHouse.release(fm);

        Vector<Ingredients> ingredientsVector = new Vector<Ingredients>();
        ingredientsVector.add(new Ingredients(10,"rice"));
        ingredientsVector.add(new Ingredients(20,"potato"));

        System.out.println(ingredientsVector.size());
        cm.accept(new NormalRunVisitor(ingredientsVector));

    }
}
