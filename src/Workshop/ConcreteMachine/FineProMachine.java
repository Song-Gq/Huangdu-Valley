package Workshop.ConcreteMachine;

import Workshop.Ingredients;
import Workshop.Machine;
import Workshop.Product.FineProduct;
import Workshop.Product.Product;
import Workshop.Visitor;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class FineProMachine extends Machine {
    private String name;


    public FineProMachine(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void switchOn(){
        System.out.println("FineProMachine on!");
    }

    @Override
    public void stop(){
        System.out.println("FineProMachine off!");
    }

    @Override
    public Vector<Product> run(Vector<Ingredients> ingredientsVector){
        System.out.println("FineProMachine is running!");
        Vector<Product> productVector = new Vector<Product>();
        for(Ingredients ingredients:ingredientsVector){
            productVector.add(new FineProduct(ingredients.getClass().getSimpleName(), ingredients.getCount()));
            System.out.println(String.format("Fine processing machine produces %d %s",ingredients.getCount(),ingredients.getClass().getSimpleName()));
        }
        return productVector;
    }

    @Override
    public Vector<Product> accept(Visitor v){
        return v.visit(this);
    }
}
