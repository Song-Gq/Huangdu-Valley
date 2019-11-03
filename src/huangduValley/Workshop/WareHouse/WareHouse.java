package huangduValley.Workshop.WareHouse;

import huangduValley.Workshop.Machine;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public class WareHouse {

    private WareHouse(){
        System.out.println("Warehouse create");
        this.machineVector = new Vector<Machine>();
    }

    private Vector<Machine> machineVector;

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
        System.out.println("Get warehouse instance!");
        return WareHouseHolder.INSTANCE;
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

    /**
     * Set the pool size
     * @param size
     * Max size of the object pool
     */
    public void setMaxSize(int size){
        this.poolSize = size;
        System.out.println(String.format("Set the warehouse size to %d", size));
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
