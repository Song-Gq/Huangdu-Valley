package huangduValley.Workshop;

import huangduValley.Workshop.Product.Product;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public interface Acceptor {
    Vector<Items> accept(Visitor v) throws Exception;
}
