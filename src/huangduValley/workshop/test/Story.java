package huangduValley.workshop.test;
import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.workshop.Machine;
import huangduValley.workshop.wareHouse.Store;
import huangduValley.workshop.wareHouse.WareHouse;
import huangduValley.workshop.processFactory.factory.ClosedFactory;
import huangduValley.workshop.processFactory.factory.FactoryState;
import huangduValley.workshop.processFactory.factory.NormalFactory;
import huangduValley.workshop.processFactory.workSpace.CompleteProcessing;
import huangduValley.workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;
import huangduValley.workshop.processFactory.factory.Context;

import java.util.Scanner;
import java.util.Vector;

public class Story{
    static boolean skip = false;

    public static void main(String[] args) throws Exception {

        System.out.println("你现在坐着直升飞机和管家来到了工厂，并打算进入你五光十色的加工厂。");
        Context context=new Context();
        FactoryState factoryState= ClosedFactory.getInstance();
        context.setState(factoryState);
        context.runState();
        System.out.println("嗯？？为什么我的工厂是关闭的，管家，给我打开它\n"
                +"\"好的先生\"，管家边说边拿出了遥控器，按了一下加工厂的开关");

        skip();
        factoryState= NormalFactory.getInstance();
        context.setState(factoryState);
        System.out.println("你看先生，加工厂已经打开了，但是别着急，还要设置一下工作参数才能让加工厂正常运行\n"
                +"emmm那么要设置哪些参数呢？\n"
                +"很简单，只需要跟着我，我会一步一步教你怎么当一个好的加工厂主的。\n"
                +"首先，工具房的容量为10,也就是只能存放10个加工工具\n"
                +"让我们先拿到一个清洗工具");
        WareHouse wareHouse=WareHouse.getInstance();
        wareHouse.setMaxSize(10);
        skip();
        System.out.println("先生接下来来选择要加工的原料吧，我觉得加工100吨的土豆会让我们的机器容光焕发。\n"
                +"说着，管家打电话运来了100吨土豆并倒进了加工厂的加工台.\n"
                +"吨吨吨，这是倒土豆的声音\n"
                +"先清洗30吨土豆好了，先生。将30吨土豆加入清洗机器");

        Vector<Items> ingredientsVector1 = new Vector<>();
        ingredientsVector1.add(new Ingredients("potato", 30));

        CleanMachine cm1=new CleanMachine("1st cm");
        CleanMachine cm2 = (CleanMachine) cm1.clone();
        cm2.setName("2nd cm");
        RoughProMachine rm=new RoughProMachine("1st rm");
        FineProMachine fm=new FineProMachine("1st fm");
        Vector<WorkSpace> processVector = new Vector<>();
        CompleteProcessing processing1 = new CompleteProcessing();
        Vector<Machine> machineVector1 = new Vector<>();
        machineVector1.add(cm1);
        machineVector1.add(cm2);
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

        skip();
        System.out.println("终于准备就绪了，我们可以开始加工厂的加工了。");
        ((NormalFactory) factoryState).setProcessVector(processVector);
        context.runState();

        skip();
        System.out.println("听这嗡嗡作响的机器运转的声音，谁能想到我们现在就要和它们说再见了呢\n"
                +"让我们把机器回收了吧.");
        wareHouse.release(cm1);
        wareHouse.release(rm);
        wareHouse.release(fm);
        skip();
        System.out.println("差不多搞明白了吧先生，时间不早了，可以准备离开工厂了，别忘了关闭工厂哦先生。");
        factoryState=ClosedFactory.getInstance();
        context.setState(factoryState);
        skip();
        System.out.println("离开工厂之后，你在管家的陪同下来到了旁边的商店");
        System.out.println("你看着商店中琳琅满目的商品,一时有些眼花。\n管家,你有什么推荐吗");
        System.out.println("你好，先生，你可以试一试我们工厂中刚刚生产出的土豆\n好的，就来一个这个");
        Store store = Store.getInstance();
        store.buy("potato");
        System.out.println("嗯，口感还不错！好了，我们去看看别的地方吧！");
        System.out.println("好的，先生。请跟我来……");
    }

    private static void skip() throws Exception {
        if(!skip) {
            System.out.println("按Enter继续，或输入任意其他全部跳过\n");

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.length() != 0)
                skip = true;
        }
    }
}
