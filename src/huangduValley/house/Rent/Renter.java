//package huangduValley.house.Rent;
//
//public class Renter extends Person {
//	public boolean sendBool=false;
//
//    public Renter(String name, Mediator mediator) {
//        super(name, mediator);
//    }
//    public boolean getsendBool() {
//    	return sendBool;
//    }
//
//
//    @Override
//	public void sendMessage(String msg) {
//
//        System.out.println("Renter["+ name +"]send message to mediator：" + msg);
//        sendBool=true;
//        mediator.operation(this, msg);
//    }
//
//    @Override
//    protected void getMessage(String msg) {
//        System.out.println("Renter[" + name + "]receive message from mediator： " + msg);
//    }
//
//}


package huangduValley.house.Rent;

import huangduValley.Stdout;

public class Renter extends Person {
    public boolean sendBool=false;

    public Renter(String name, Mediator mediator) {
        super(name, mediator);
    }
    public boolean getsendBool() {
        return sendBool;
    }


    @Override
    public void sendMessage(String msg) {
        Stdout.print(this, "租客["+ name +"]向房产中介发送消息：" + msg);
//        System.out.println("Renter["+ name +"]send message to mediator：" + msg);
        sendBool=true;
        mediator.operation(this, msg);
    }

    @Override
    protected void getMessage(String msg) {
        Stdout.print(this,"租客["+ name +"]收到了来自房产中介的消息：" + msg);
//        System.out.println("Renter[" + name + "]receive message from mediator： " + msg);
    }

}