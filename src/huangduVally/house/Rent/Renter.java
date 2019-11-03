package huangduVally.house.Rent;

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
        
        System.out.println("Renter["+ name +"]send message to mediator：" + msg);
        sendBool=true;
        mediator.operation(this, msg);
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("Renter[" + name + "]receive message from mediator： " + msg);
    }

}