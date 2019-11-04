package huangduValley.workshop.processFactory.factory;

import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 * Observer Pattern
 */

public interface Observer {
    public default void update(Vector<Vector<Items>> products) {

    }
}
