package Workshop.ConcreteMachine;

import Workshop.Ingredients;
import Workshop.Machine;
import Workshop.Product.CleanProduct;
import Workshop.Product.Product;
import Workshop.Visitor;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class CleanMachine extends Machine {
    private String name;


    public CleanMachine(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void switchOn(){
        System.out.println("CleanMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("CleanMachine off!");
    }

    /**
     *
     * @param ingredientsVector
     * @return
     */
    @Override
    public Vector<Product> run(Vector<Ingredients> ingredientsVector){
        System.out.println("CleanMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        for(Ingredients ingredients:ingredientsVector){
            productVector.add(new CleanProduct(ingredients.getClass().getSimpleName(), ingredients.getCount()));
            System.out.println(String.format("Clean machine produces %d %s",ingredients.getCount(),ingredients.getClass().getSimpleName()));
        }
        return productVector;
    }

    @Override
    public Vector<Product> accept(Visitor v){
        return v.visit(this);
    }
}
