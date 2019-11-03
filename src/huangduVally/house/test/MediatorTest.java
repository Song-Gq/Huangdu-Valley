package huangduVally.house.test;

import huangduVally.house.Rent.HouseMediator;
import huangduVally.house.Rent.Landlord;
import huangduVally.house.Rent.Mediator;
import huangduVally.house.Rent.Person;
import huangduVally.house.Rent.Renter;

public class MediatorTest {

    public static void main(String[] args) {
		System.out.println("****************************  Test Mediator  ****************************");
        Mediator mediator = new HouseMediator();

        Person landlordA, landlordB,landlordC, renterA,renterB,renterC;
        landlordA = new Landlord("Python", mediator);
        landlordB = new Landlord("Java", mediator);
        landlordC = new Landlord("C++", mediator);
        
        renterA = new Renter("Poor Farmer",mediator);
        renterB = new Renter("Rich Farmer",mediator);
        renterC = new Renter("Extremely Wealthy Farmer ",mediator);

        // 房东注册中介
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);
        mediator.registerLandlord(landlordC);
        // 求租者注册中介
        mediator.registerRenter(renterA);
        mediator.registerRenter(renterB);
        mediator.registerRenter(renterC);

        // 求租者 发送求租消息
        renterA.sendMessage("Near land, $3115/month");
        renterB.sendMessage("Near factory, $4000/month");
        renterC.sendMessage("In the middle of the map, $8000000/month");
        System.out.println("-------------------------------------------------------------------------");
        // 房东A 发送房屋出租消息
        landlordA.sendMessage("Near factory, $3694/month");
        landlordB.sendMessage("Near factory, $4500/month");
		System.out.println("*************************************************************************");
    }

}