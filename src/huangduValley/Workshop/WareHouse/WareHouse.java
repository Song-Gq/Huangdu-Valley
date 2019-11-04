package huangduValley.Workshop.WareHouse;

import huangduValley.Stdout;
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
        Stdout.print(this, "Warehouse create!");
        this.machineVector = new Vector<Machine>();
    }

    private Vector<Machine> machineVector;

    private Wallet wallet = Wallet.getInstance();

    private Vector<Vector<Product>> productsVector = new Vector<>();

    private int poolSize;

    /**
     * Singleton Object
     */
    private static class WareHouseHolder{
        private static final WareHouse INSTANCE = new WareHouse();
    }

    /**
     * Get singleton object warehouse.
     * @return
     * WareHouse
     */
    public static WareHouse getInstance(){
        Stdout.print(WareHouseHolder.INSTANCE.toString(), "Get warehouse instance!");
        return WareHouseHolder.INSTANCE;
    }

    //观察者模式
    @Override
    public void update(Vector<Vector<Items>> products) {
        int length = products.size();
        for (int indexA = 0; indexA < length; indexA++) {
            Vector<Product> temp = new Vector<>();
            for (int indexB = 0; indexB < products.elementAt(indexA).size(); indexB++) {
                Product product = (Product) products.elementAt(indexA).elementAt(indexB);
                product.setPrice((int)(Math.random()*100));
                temp.add(product);
            }
            productsVector.add(temp);
        }

    }

    public Vector<Vector<Product>> getProductsVector() {
        return productsVector;
    }

    //代理模式
    public boolean buy(String name) throws Exception {
        int length = productsVector.size();
        boolean flag = false;

        Product product = null;

        int indexA = -1, indexB = -1;
        for (indexA = 0; indexA < length; indexA++) {
            indexB = -1;
            Vector<Product> vector = productsVector.elementAt(indexA);
            for (int i = 0; i < vector.size(); i++) {
                if (vector.elementAt(i).getName() == name) {
                    indexB = i;
                    product = vector.elementAt(i);
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

            Stdout.print(this, "You bought " + name);
            Stdout.print(this, "The price of " + name + "is "+ product.getPrice());

            return true;
        }
        else {
            return false;
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
                    Stdout.print(this, "Occupy one machine!");
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
            Stdout.print(this, "Warehouse has no idle machine!");
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
            Stdout.print(this, String.format("Warehouse stores the machine:",machine.getName()));
            machineVector.add(machine);
            return true;
        }else{
            Stdout.print(this, "Warehouse has no space to place more machines!");
            return false;
        }
    }

    /**
     * Set the pool size
     * @param size
     * Max size of the object pool
     */
    public void setMaxSize(int size){
        this.poolSize = size;
        Stdout.print(this, String.format("Set the warehouse size to %d", size));
    }

    /**
     * Get the pool size
     * @return
     * Max size of the object pool
     */
    public int getPoolSize(){
        return this.poolSize;
    }
}
