package huangduValley.Workshop.WareHouse;

import huangduValley.Workshop.Machine;
import huangduValley.Workshop.Product.Product;
import huangduValley.Workshop.processFactory.factory.Observer;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class WareHouse implements Observer, Proxy {
    private WareHouse(){
        System.out.println("Warehouse create");
        this.machineVector = new Vector<Machine>();
    }

    private Vector<Vector<Items>> productsVector = new Vector<Vector<Items>>();

    private Vector<Machine> machineVector;

    private Wallet wallet = Wallet.getInstance();

    private int poolSize;

    private static class WareHouseHolder{
        private static final WareHouse INSTANCE = new WareHouse();
    }

    public static WareHouse getInstance(){
        System.out.println("Get warehouse instance!");
        return WareHouseHolder.INSTANCE;
    }

    @Override
    public void update(Vector<Vector<Items>> products) {
        productsVector = products;
    }

    public Vector<Vector<Items>> getProductsVector() {
        return productsVector;
    }

    public boolean buy(String name) throws Exception {
        int length = productsVector.size();
        boolean flag = false;
        
        Product product = null;
        
        int indexA = -1, indexB = -1;
        for (indexA = 0; indexA < length; indexA++) {
            indexB = -1;
            Vector<Items> vector = productsVector.elementAt(indexA);
            for (int i = 0; i < vector.size(); i++) {
                if (vector.elementAt(i).getName() == name) {
                    indexB = i;
                    product = (Product) vector.elementAt(i);
                }
            }
            
            if (indexB != -1) {
                flag = true;
                break;
            }
        }
        if (flag) {

            int count = productsVector.elementAt(indexA).elementAt(indexB).getCount();

            productsVector.elementAt(indexA).elementAt(indexB).setCount(count - 1);

            wallet.increaseBalance(product.getPrice());
            
            return flag;
        }
        else {
            return flag;
        }

    }

    /**
     * Acquire for the machine with name and machine type.
     * @param name
     * Name of the machine
     * @param machineType
     * Type of the machine, such as CleanMachine, RoughProMachine, FineProMachine
     * @return
     * Machine object if there is one machine matched with the name an machineType in the machineVector,
     * else return null.
     */
    public Machine acquire(String name, String machineType){
        if(!machineVector.isEmpty()){
            for(Machine machine:machineVector){
                if(machine.getName().equals(name) && machine.getClass().getSimpleName().equals(machineType)){
                    System.out.println("Occupy one machine!");
                    machineVector.remove(machine);
                    return machine;
                }
            }
            /**
            if(machineVector.capacity() < poolSize){
                System.out.println("");
                switch (machineType){
                    case CleanMachine:
                        CleanMachine cleanMachine = new CleanMachine(name);
                        machineVector.add(cleanMachine);
                        return cleanMachine;
                    case RoughProMachine:
                        RoughProMachine roughProMachine = new RoughProMachine(name);
                        machineVector.add(roughProMachine);
                        return roughProMachine;
                    case FineProMachine:
                        FineProMachine fineProMachine = new FineProMachine(name);
                        machineVector.add(fineProMachine);
                        return fineProMachine;
                }
            } else{

            }
             */
            return null;
        }
        else{
            System.out.println("Warehouse has no idle machine!");
            return null;
        }
    }

    /**
     * Release idle machine to warehouse.
     * @param machine
     * Machine that is going to store in warehouse.
     * @return
     * True if warehouse has enough space to store,
     * else return False.
     */
    public boolean release(Machine machine){
        if(machineVector.size() < this.poolSize){
            machineVector.add(machine);
            return true;
        }else{
            System.out.println("Warehouse has no space to place more machines!");
            return false;
        }
    }

    public void setMaxSize(int size){
        this.poolSize = size;
        System.out.println(String.format("Set the warehouse size to %d", size));
    }

    public int getPoolSize(){
        return this.poolSize;
    }
}
