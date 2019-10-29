package Workshop.WareHouse;

import Workshop.ConcreteMachine.MachineType;
import Workshop.Machine;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/28
 */
public class WareHouse {
    private WareHouse(){
        System.out.println("Warehouse create");
        this.machineVector = new Vector<Machine>();
    }

    private Vector<Machine> machineVector;

    private int poolSize;

    private static class WareHouseHolder{
        private static final WareHouse INSTANCE = new WareHouse();
    }

    public static WareHouse getInstance(){
        System.out.println("Succeed getting instance");
        return WareHouseHolder.INSTANCE;
    }

    public Machine acquire(String name, MachineType machineType){
        if(!machineVector.isEmpty()){
            for(Machine machine:machineVector){
                if(machine.getName().equals(name) && machine.getMachineType() == machineType){
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

    public boolean release(Machine machine){
        if(machineVector.capacity() < this.poolSize){
            machineVector.add(machine);
            return true;
        }else{
            System.out.println("Warehouse has no space to place more machines!");
            return false;
        }
    }

    public void setMaxSize(int size){
        this.poolSize = size;
    }

    public int getPoolSize(){
        return this.poolSize;
    }
}
