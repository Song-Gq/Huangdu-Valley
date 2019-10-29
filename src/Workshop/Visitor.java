package Workshop;


import Workshop.ConcreteMachine.CleanMachine;
import Workshop.ConcreteMachine.FineProMachine;
import Workshop.ConcreteMachine.RoughProMachine;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/27.
 */
public abstract class Visitor {
    public abstract void visit(CleanMachine cm);
    public abstract void visit(RoughProMachine rm);
    public abstract void visit(FineProMachine fm);
}
