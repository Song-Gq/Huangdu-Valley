package Workshop;


import Workshop.ConcreteMachine.MachineType;
import Workshop.Product.Product;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/28
 */
public abstract class Machine implements Acceptor{
    public abstract String getName();

    public abstract MachineType getMachineType();

    /**
     * Machine on
     */
    public abstract void switchOn();

    /**
     * Machine off
     */
    public abstract void stop();

    /**
     * Machine running
     */
    public abstract Vector<Product> run();
}
