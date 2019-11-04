package huangduValley.workshop;


import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */

//原型模式
public abstract class Machine implements Acceptor, Cloneable{
    public abstract String getName();

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
     * @param ingredientsVector
     */
    public abstract Vector<Items> run(Vector<Items> ingredientsVector) throws Exception;
}
