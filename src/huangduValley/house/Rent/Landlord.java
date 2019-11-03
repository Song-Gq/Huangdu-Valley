package huangduValley.house.Rent;

public class Landlord extends Person {

	public boolean sendBool=false;
    public Landlord(String name, Mediator mediator) {
        super(name,mediator);
    }

    @Override
	public void sendMessage(String msg) {
        System.out.println("Landlord["+ name +"]send message to mediator：" + msg);
        sendBool=true;
        mediator.operation(this, msg);
        
    }

    @Override
    protected void getMessage(String msg) {
        System.out.println("Landlord["+ name +"]receive message from mediator：" + msg);
    }

	@Override
	public boolean getsendBool() {
		// TODO 自动生成的方法存根
		return sendBool;
	}

}