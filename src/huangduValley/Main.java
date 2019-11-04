package huangduValley;

import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.workshop.Machine;
import huangduValley.workshop.wareHouse.Store;
import huangduValley.workshop.wareHouse.WareHouse;
import huangduValley.workshop.processFactory.factory.ClosedFactory;
import huangduValley.workshop.processFactory.factory.Context;
import huangduValley.workshop.processFactory.factory.FactoryState;
import huangduValley.workshop.processFactory.factory.NormalFactory;
import huangduValley.workshop.processFactory.workSpace.CompleteProcessing;
import huangduValley.workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.manager.Manager;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;
import huangduValley.farm.taskHandler.PlantTaskHandler;
import huangduValley.farm.taskHandler.Request;
import huangduValley.farm.taskHandler.TaskHandler;
import huangduValley.house.rent.Client;
import huangduValley.house.brick.Floorboard;
import huangduValley.house.brick.FlyweightBrick;

import java.util.ArrayList;
import java.util.Scanner;

import static huangduValley.house.HouseMain.houseDoAll;

import huangduValley.farm.fence.Fence;
import huangduValley.farm.fence.FenceBuilder;
import huangduValley.farm.fence.ShortFenceBuilder;
import huangduValley.farm.fence.Worker;

import java.util.Vector;

public class Main {

    // if the player wants to skip
    static boolean skip = false;

    public static void main(String[] args) {

        // Flyweight 创建地砖
        ArrayList<Floorboard> floorboardList = new ArrayList<Floorboard>();
        for(int i=1;i<3;i++) {
            for (int j = 1; j < 3; j++){
                Floorboard floorboard = new Floorboard(FlyweightBrick.textures[0]); // 初始地砖为木质
                floorboard.setX(i);
                floorboard.setY(j);
                floorboardList.add(floorboard);
            }
        }

        try {
            // farm
            // taskHandler
            System.out.println("你的农场实在是太大了，对讲机传输距离不够远，你和四个合伙人连成一串，\n" +
                    "你只能通知到负责农场的一号合伙人，而一号合伙人将非农场的指令传给二号合伙人，\n" +
                    "如此向下，直到命令被相应的负责人处理。");
            skip();

            // storage
            System.out.println("你有一个仓库，存放着水、化肥、收获的产物等等\n" +
                    "对于有强迫症的你来说，一定要把这些杂物分门别类地排放好\n" +
                    "所以，你通知合伙人们，在仓库里放置一个私密格子，并称之为巴啦啦格子\n"+
                    "于是，任务发出[put a private bag named Balala into storage]\n"+
                    "合伙人将会传递任务直到处理");
            TaskHandler rootHandler=new PlantTaskHandler();
            rootHandler.setHandlerChain();
            Request request1=new Request("put a private bag named Balala into storage");
            rootHandler.handleRequest(request1);
            skip();

            System.out.println("并把你心爱的奖杯放在了里面\n" +
                    "于是，任务发出[add a trophy into storage]");
            Request request2=new Request("add a trophy into storage");
            rootHandler.handleRequest(request2);
            skip();

            System.out.println("此外，你在仓库的主空间里还有100吨的水和100吨的化肥\n" +
                    "于是，任务发出[add 100 tons of water and 100 tons of fertilizer into MAIN space of storage]");
            Request request3=new Request("add 100 tons of water and 100 tons of fertilizer into MAIN space of storage");
            rootHandler.handleRequest(request3);
            skip();

            // manager, land
            System.out.println("你还雇了一位经理帮你打理一些事物，并通过神秘外星科技与他交流");
            System.out.println("现在，你通知他要开垦6块荒地\n" +
                    "经理效率很高，不知怎么你就拥有了3块贫瘠农田和3块肥沃农田\n" +
                    "肥沃农田的产量是贫瘠农田的2倍");
            Manager manager = Manager.getInstance();
            for(int i = 0; i < 3; i++) {
                manager.addDryLand();
            }
            for(int i = 0; i < 3; i++) {
                manager.addFertileLand();
            }
            skip();

            System.out.println("但是你不满足，要求经理不论如何要把产量再提升一个台阶\n" +
                    "经理费尽心力，空运来了一批红土壤和黑土壤\n" +
                    "不论是贫瘠农田还是肥沃农田，红土壤都能让它们的产量变为其原先的两倍\n" +
                    "而黑土壤则是三倍\n" +
                    "并且，红土壤上作物的生长时间为原来的80%\n" +
                    "黑土壤则为60%\n" +
                    "但土壤有限，你现在总共拥有了贫瘠红土地（2倍产量）、贫瘠黑土地（3倍）、\n" +
                    "肥沃红土地（4倍）、肥沃黑土地（6倍），\n" +
                    "加上原有的贫瘠黄土地（1倍）、肥沃黄土地（2倍）各一块\n" +
                    "花掉了你1元钱");
            manager.upgradeLand(1, 2, 2, 4, 5, 5);
            skip();

            // plant
            System.out.println("现在，你让经理种下一批胡萝卜\n" +
                    "胡萝卜在贫瘠土地上长得普普通通，在肥沃土地上茁壮生长\n" +
                    "花掉了你1元钱");
            manager.plantCarrotAll();
            skip();

            System.out.println("它们需要水和肥料才能成熟\n" +
                    "于是，你吩咐经理去仓库取水和肥料，把所有土地浇水施肥了一遍\n" +
                    "（经理无权搜索你的私密格子，也就不能取到里面的水或肥料）");
            manager.waterAll();
            manager.fertilizeAll();
            skip();

            System.out.println("经理顺便收获了所有的胡萝卜");
            manager.harvestAll();
            skip();

            // guard
            System.out.println("但是，刚刚有小偷趁警卫睡着，到仓库偷取了100吨的胡萝卜！");
            manager.stopTheft();
            skip();

            System.out.println("你让经理叫醒了警卫");
            manager.wakeupGuard();
            skip();

            System.out.println("之后，经理又种下了土豆，地上长出了普通的土豆和茁壮的土豆\n" +
                    "并浇水、施肥、收获\n" +
                    "又一名小偷试图盗窃，但被精神焕发的警卫逮住了！\n" +
                    "随后，警卫安心地睡着了");
            manager.doAll();
            skip();

            System.out.println("你找了一个工人，准备为农场建一个栅栏\n" +
            		"由于资金的原因，我们建一个木制矮栅栏");
    		Worker worker = new Worker();
    		FenceBuilder shortfb = new ShortFenceBuilder();
    		worker.setFenceBuilder(shortfb);
    		worker.buildFence();
    		Fence fence = worker.getFence();
    		skip();







            // workshop
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






            // house
            Client.rentHouse();
            skip();

            houseDoAll();
            skip();

            System.out.println("安心地睡着了\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void skip() throws Exception {
        if(!skip) {
            System.out.println("按Enter继续，或输入任意其他全部跳过\n");

            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.length() != 0)
                skip = true;
        }
    }

}
