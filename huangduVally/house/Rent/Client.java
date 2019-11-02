package huangduVally.house.Rent;

public class Client {

    public static void main(String[] args) {
        // 实例化房屋中介
        Mediator mediator = new HouseMediator();

        Person landlordA, landlordB, renter;
        landlordA = new Landlord("Landlord Python", mediator);
        landlordB = new Landlord("Landlord Java", mediator);

        renter = new Renter("Renter DP",mediator);

        // 房东注册中介
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);
        // 求租者注册中介
        mediator.registerRenter(renter);

        // 求租者 发送求租消息
        renter.sendMessage("Near land, $3115/month");
        System.out.println("--------------------------");
        // 房东A 发送房屋出租消息
        landlordA.sendMessage("Near factory, $3694/month");
    }

}