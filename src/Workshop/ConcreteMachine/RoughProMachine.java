package Workshop.ConcreteMachine;

import Workshop.Ingredients;
import Workshop.Machine;
import Workshop.Product.Product;
import Workshop.Product.RoughProduct;
import Workshop.Visitor;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class RoughProMachine extends Machine {
    private String name;

    public RoughProMachine(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void switchOn(){
        System.out.println("RoughProMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("RoughProMachine off!");
    }

    /**
     * Rough processing machine run to process on
     * @param ingredientsVector
     * Vector of
     * @return
     */
    @Override
    public Vector<Product> run(Vector<Ingredients> ingredientsVector){
        System.out.println("RoughProMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        for(Ingredients ingredients:ingredientsVector){
            productVector.add(new RoughProduct(ingredients.getClass().getSimpleName(), ingredients.getCount()));
            System.out.println(String.format("Rough processing machine produces %d %s",ingredients.getCount(),ingredients.getClass().getSimpleName()));
        }
        return productVector;
    }

    @Override
    public Vector<Product> accept(Visitor v){
        return v.visit(this);
    }
}
