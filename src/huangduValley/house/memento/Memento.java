package huangduValley.house.memento;

/**
 * @project: memento
 * @description: 存储信息的Object
 * @designPatter: Memento
 **/
public class Memento {
    private String houseName="your house"; // state是houseName

    public Memento(String houseName){ // 构造一个Memento，参数为houseName
        this.houseName=houseName;
    }
    public String getHouseName() { //获取状态，即houseName
        return houseName;
    }
}
