package test;

import Workshop.ConcreteVisitor.NormalRunVisitor;
import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;
import Workshop.WareHouse.WareHouse;

import java.awt.desktop.SystemSleepEvent;

public class main {
    public static void main(String[] args) {
        CleanMachine cm = new CleanMachine("1st CM");
        RoughProMachine rm = new RoughProMachine("1st rm");
        FineProMachine fm = new FineProMachine("1st fm");

        fm.accept(new NormalRunVisitor("rice"));

        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.setMaxSize(10);
        System.out.println(wareHouse.getPoolSize());

        WareHouse wareHouse1 = WareHouse.getInstance();
        System.out.println((wareHouse1.getPoolSize()));
        String type = wareHouse.getClass().getSimpleName();
        System.out.println(type);
    }
}
