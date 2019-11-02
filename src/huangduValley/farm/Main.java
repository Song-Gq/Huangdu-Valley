package huangduValley.farm;

import huangduValley.farm.manager.Manager;
import huangduValley.farm.storage.Explorer;

public class Main {

    public static void main(String[] args) {
        try {
            // taskHandler
            // 你的农场实在是太大了，对讲机传输距离不够远，你和四个合伙人连成一串，
            // 你只能通知到负责农场的一号合伙人，而一号合伙人将非农场的指令传给二号合伙人，
            // 如此向下，直到命令被相应的负责人处理。

            // storage
            // 你有一个仓库，存放着水、化肥、收获的产物等等
            // 对于有强迫症的你来说，一定要把这些杂物分门别类地排放好
            // 所以，你通知合伙人们，在仓库里放置一个私密格子，并称之为巴啦啦格子
            Explorer explorer = Explorer.getInstance();
            explorer.backRoot();
            explorer.addBag("Balala");
            // 并把你心爱的奖杯放在了里面
            explorer.into("Balala");
            explorer.addItems("Trophy", 1);
            // 此外，你在仓库的主空间里还有100吨的水和100吨的化肥
            explorer.back();
            explorer.addItems("Water", 100);
            explorer.addItems("Fertilizer", 100);

            // manager, land
            // 你还雇了一位经理帮你打理一些事物，并通过神秘外星科技与他交流
            Manager manager = Manager.getInstance();
            // 现在，你通知他要开垦6块荒地
            // 经理效率很高，不知怎么你就拥有了3块贫瘠农田和3块肥沃农田
            // 肥沃农田的产量是贫瘠农田的2倍
            for(int i = 0; i < 3; i++) {
                manager.addDryLand();
            }
            for(int i = 0; i < 3; i++) {
                manager.addFertileLand();
            }
            // 但是你不满足，要求经理不论如何要把产量再提升一个台阶
            // 经理费尽心力，空运来了一批红土壤和黑土壤
            // 不论是贫瘠农田还是肥沃农田，红土壤都能让它们的产量变为其原先的两倍
            // 而黑土壤则是三倍
            // 并且，红土壤上作物的生长时间为原来的80%
            // 黑土壤则为60%
            // 但土壤有限，你现在总共拥有了贫瘠红土地（2倍产量）、贫瘠黑土地（3倍）、
            // 肥沃红土地（4倍）、肥沃黑土地（6倍），
            // 加上原有的贫瘠黄土地（1倍）、肥沃黄土地（2倍）各一块
            manager.upgradeLand(1, 2, 2, 4, 5, 5);

            // plant
            // 现在，你让经理种下一批胡萝卜
            manager.plantCarrotAll();
            // 胡萝卜在贫瘠土地上长得普普通通，在肥沃土地上茁壮生长
            // 它们需要水和肥料才能成熟
            // 于是，你吩咐经理去仓库取水和肥料，把所有土地浇水施肥了一遍
            // （经理无权搜索你的私密格子，也就不能取到里面的水或肥料）
            manager.waterAll();
            manager.fertilizeAll();
            // 经理顺便收获了所有的胡萝卜
            manager.harvestAll();

            // guard
            // 但是，刚刚有小偷趁警卫睡着，到仓库偷取了100吨的胡萝卜！
            manager.stopTheft();
            // 你让经理叫醒了警卫
            manager.wakeupGuard();

            // 之后，经理又种下了土豆，地上长出了普通的土豆和茁壮的土豆
            // 并浇水、施肥、收获
            // 又一名小偷试图盗窃，但被精神焕发的警卫逮住了！
            // 随后，警卫安心地睡着了
            manager.doAll();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
