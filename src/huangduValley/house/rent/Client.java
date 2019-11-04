//package huangduValley.house.Rent;
//
//public class Client {
//
//    public static void rentHouse() {
//        // 实例化房屋中介
//        Mediator mediator = new HouseMediator();
//
//        Person landlordA, landlordB, renter;
//        landlordA = new Landlord("Landlord Python", mediator);
//        landlordB = new Landlord("Landlord Java", mediator);
//
//        renter = new Renter("Renter DP",mediator);
//
//        // 房东注册中介
//        mediator.registerLandlord(landlordA);
//        mediator.registerLandlord(landlordB);
//        // 求租者注册中介
//        mediator.registerRenter(renter);
//
//        // 求租者 发送求租消息
//        renter.sendMessage("Near land, $3115/month");
//        System.out.println("--------------------------");
//        // 房东A 发送房屋出租消息
//        landlordA.sendMessage("Near factory, $3694/month");
//    }
//
//}

package huangduValley.house.rent;

public class Client {

    public static void rentHouse() {
        // 实例化房屋中介
        Mediator mediator = new HouseMediator();


        Person landlordA, landlordB, renter;
        landlordA = new Landlord("喜欢蟹肉煲的房东", mediator);
        landlordB = new Landlord("食指比中指长的房东", mediator);
        System.out.println("你放心地离开加工坊，想给自己找一个温暖的小家，便来到了房屋中介\n"+
                "房屋中介处冷冷清清，房主登记册上只记录了两个别具特色的房东，\n"+
                "他们一个喜欢蟹肉煲，另一个食指比中指长，\n"+
                "你在中介发布了一条求租信息[想在工厂附近拥有便宜又能养狗的屋子！],\n"+
                "两个奇怪的房东在远方收到了你的求租信息，\n"+
                "喜欢蟹肉煲的房东随即发布了一条出租信息[工厂附近宽敞又漂亮的房子，只是工厂不生产蟹肉煲]！\n"+
                "在房屋中介的你，收到了这条消息，租下了这套房子。");
        renter = new Renter("租房的你",mediator);

        // 房东注册中介
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);
        // 求租者注册中介
        mediator.registerRenter(renter);

        // 求租者 发送求租消息
        renter.sendMessage("想在工厂附近拥有便宜又能养狗的屋子！");
//        System.out.println("--------------------------");
        // 房东A 发送房屋出租消息
        landlordA.sendMessage("工厂附近宽敞又漂亮的房子，只是工厂不生产蟹肉煲！");
//        Stdout.print("huangduVally.house.Rent.Client@static", "你拥有了自己的小家！");
    }
}