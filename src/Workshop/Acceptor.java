package Workshop;

import Workshop.Product.Product;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public interface Acceptor {
    public abstract Vector<Product> accept(Visitor v);
}
