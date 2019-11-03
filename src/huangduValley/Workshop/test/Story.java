package huangduValley.Workshop.test;
import huangduValley.Workshop.ConcreteMachine.CleanMachine;
import huangduValley.Workshop.ConcreteMachine.FineProMachine;
import huangduValley.Workshop.ConcreteMachine.RoughProMachine;
import huangduValley.Workshop.Machine;
import huangduValley.Workshop.WareHouse.WareHouse;
import huangduValley.Workshop.processFactory.factory.ClosedFactory;
import huangduValley.Workshop.processFactory.factory.FactoryState;
import huangduValley.Workshop.processFactory.factory.NormalFactory;
import huangduValley.Workshop.processFactory.workSpace.CompleteProcessing;
import huangduValley.Workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;
import huangduValley.Workshop.processFactory.factory.Context;
import java.util.Vector;

public class Story{
        try{
        System.out.println("你现在坐着直升飞机和管家来到了工厂，并打算进入你五光十色的加工厂。");
        Context context=new Context();
        FactoryState factoryState= ClosedFactory.getInstance();
        context.setState(factoryState);
        context.runState();
        System.out.println("嗯？？为什么我的工厂是关闭的，管家，给我打开它\n"
                +"\"好的先生\"，管家边说边拿出了遥控器，按了一下加工厂的开关");

        factoryState= NormalFactory.getInstance();
        context.setState(factoryState);
        System.out.println("你看先生，加工厂已经打开了，但是别着急，还要设置一下工作参数才能让加工厂正常运行\n"
                +"emmm那么要设置哪些参数呢？\n"
                +"很简单，只需要跟着我，我会一步一步教你怎么当一个好的加工厂主的。\n"
                +"首先，工具房的容量为10,也就是只能存放10个加工工具\n"
                +"让我们先拿到一个清洗工具");
        WareHouse wareHouse=WareHouse.getInstance();
        wareHouse.setMaxSize(10);
        System.out.println("先生接下来来选择要加工的原料吧，我觉得加工100吨的土豆会让我们的机器容光焕发。\n"
                +"说着，管家打电话运来了100吨土豆并倒进了加工厂的加工台.\n"
                +"吨吨吨，这是倒土豆的声音\n"
                +"先清洗30吨土豆好了，先生。将30吨土豆加入清洗机器");
        Vector<Items> ingredientsVector1 = new Vector<>();
        ingredientsVector1.add(new Ingredients("potato", 30));
        CleanMachine cm=new CleanMachine("1st cm");
        RoughProMachine rm=new RoughProMachine("1st rm");
        FineProMachine fm=new FineProMachine("1st fm");
        Vector<WorkSpace> processVector = new Vector<>();
        CompleteProcessing processing1 = new CompleteProcessing();
        Vector<Machine> machineVector1 = new Vector<>();
        machineVector1.add(cm);
        processing1.doInit(ingredientsVector1,machineVector1);
        processVector.add(processing1);
        System.out.println("然后粗加工30吨土豆");
        Vector<Machine> machineVector2=new Vector<>();
        Vector<Items> ingredientsVector2 = new Vector<>();
        machineVector2.add(rm);
        CompleteProcessing processing2=new CompleteProcessing();
        ingredientsVector2.add(new Ingredients("potato",30));
        processing2.doInit(ingredientsVector2, machineVector2);
        processVector.add(processing2);
        System.out.println("最后精加工剩下的土豆。");
        Vector<Machine> machineVector3=new Vector<>();
        Vector<Items> ingredientsVector3 = new Vector<>();
        machineVector3.add(fm);
        CompleteProcessing processing3=new CompleteProcessing();
        ingredientsVector3.add(new Ingredients("potato",40));
        processing3.doInit(ingredientsVector3, machineVector3);
        processVector.add(processing3);
        System.out.println("终于准备就绪了，我们可以开始加工厂的加工了。");
        ((NormalFactory) factoryState).setProcessVector(processVector);
        context.runState();
        System.out.println("听这嗡嗡作响的机器运转的声音，谁能想到我们现在就要和它们说再见了呢\n"
                +"让我们把机器回收了吧.");
        wareHouse.release(cm);
        wareHouse.release(rm);
        wareHouse.release(fm);
        System.out.println("差不多搞明白了吧先生，时间不早了，可以准备离开工厂了，别忘了关闭工厂哦先生。");
        factoryState=ClosedFactory.getInstance();
        context.setState(factoryState);
    }
        catch (Exception e) {
        e.printStackTrace();
    }
}