package Workshop;


import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;
import Workshop.Product.Product;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30.
 */
public abstract class Visitor {
    public abstract Vector<Product> visit(CleanMachine cm);
    public abstract Vector<Product> visit(RoughProMachine rm);
    public abstract Vector<Product> visit(FineProMachine fm);
}
