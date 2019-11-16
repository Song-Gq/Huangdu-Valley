
package huangduValley.workshop.test;

import huangduValley.workshop.concreteMachine.CleanMachine;
import huangduValley.workshop.concreteMachine.FineProMachine;
import huangduValley.workshop.concreteMachine.RoughProMachine;
import huangduValley.workshop.Machine;
import huangduValley.workshop.product.Product;
import huangduValley.workshop.wareHouse.Store;
import huangduValley.workshop.wareHouse.Wallet;
import huangduValley.workshop.wareHouse.WareHouse;
import huangduValley.workshop.processFactory.factory.ClosedFactory;
import huangduValley.workshop.processFactory.factory.Context;
import huangduValley.workshop.processFactory.factory.FactoryState;
import huangduValley.workshop.processFactory.factory.NormalFactory;
import huangduValley.workshop.processFactory.workSpace.CompleteProcessing;
import huangduValley.workshop.processFactory.workSpace.WorkSpace;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.Items;

import java.util.Vector;

public class FactoryTest {

    public static void main(String[] args) throws Exception {
        Context context=new Context();
        FactoryState factory=ClosedFactory.getInstance();
        context.setState(factory);    //设置状态为工厂关闭
        context.runState();         //状态为关闭工厂下的运行函数
        factory= NormalFactory.getInstance();
        context.setState(factory);    //设置状态为工厂开启

        /**
        Create machine
         */

        CleanMachine cm = new CleanMachine("1st CM");
        CleanMachine cm2 = (CleanMachine) cm.clone();
        cm2.setName("2nd CM");
        RoughProMachine rm = new RoughProMachine("1st rm");
        FineProMachine fm = new FineProMachine("1st fm");

        /**
         * Set wareHouse size
         */

        WareHouse wareHouse = WareHouse.getInstance();
        Store store = Store.getInstance();
        Wallet wallet = Wallet.getInstance();

        wareHouse.setMaxSize(10);

        /**
         * Create ingredients
         */

        Vector<Items> ingredientsVector = new Vector<>();
        ingredientsVector.add(new Ingredients("rice", 10));
        ingredientsVector.add(new Ingredients("potato", 20));

        /**
         * Create processing
         */

        Vector<WorkSpace> processVector = new Vector<>();
        CompleteProcessing processing1 = new CompleteProcessing();
        Vector<Machine> machineVector = new Vector<>();
        machineVector.add(cm);
        machineVector.add(cm2);
        Vector<Machine> machineVector1 = new Vector<>();
        machineVector1.add(rm);
        Vector<Machine> machineVector2 = new Vector<>();
        machineVector2.add(fm);
        processing1.doInit(ingredientsVector, machineVector, machineVector1, machineVector2);
        processVector.add(processing1);
        ((NormalFactory) factory).setProcessVector(processVector);


        /**
         * Run
         */

        context.runState();         //状态为开启工厂下的运行函数
        Vector<Product> vector1 = wareHouse.getProductsVector().elementAt(0);
        System.out.println("Name is " + vector1.elementAt(0).getName());
        System.out.println("Count is " + vector1.elementAt(0).getCount());
        store.buy("rice");
        System.out.println(vector1.elementAt(0).getName());
        System.out.println(vector1.elementAt(0).getCount());
        System.out.println(wallet.getBalance());
    }
}
