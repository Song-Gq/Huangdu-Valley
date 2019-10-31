package huangduValley.Workshop.processFactory.workSpace;

import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.Machine;
import huangduValley.farm.storage.Items;

import java.util.Vector;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/31
 */
public abstract class QuickProcessing implements WorkSpace {
    Vector<CleanMachine> cleanMachines;

    Vector<RoughProMachine> roughProMachines;

    Vector<FineProMachine> fineProMachines;

    protected Vector<Items> ingredients;
    @Override
    public Vector<Items> doProcess() throws Exception{
        return new Vector<>();
    }

    @Override
    public void doInit(Vector<Items> items, Vector<Machine>... machineVector) throws Exception{

    }

    @Override
    public void doExit(){
    }

    protected abstract Vector<Items> process() throws Exception;
    protected abstract void exit();

    private void addCleanMachine(Vector<Machine> machines){
        for(Machine machine:machines){
            cleanMachines.add((CleanMachine) machine);
        }
    }
    private void addRoughProMachine(Vector<Machine> machines){
        for(Machine machine:machines){
            roughProMachines.add((RoughProMachine) machine);
        }

    }
    private void addFindProMachine(Vector<Machine> machines){
        for(Machine machine:machines){
            fineProMachines.add((FineProMachine) machine);
        }
    }
}
