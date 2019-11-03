package huangduValley.house.memento;

/**
 * @project: memento
 * @description: 操作Memento的Object，用于返回上一个houseName
 * @designPatter: Memento
 **/

public class Originator {
    private String houseName; // state是houseName

    public void setHouseName(String houseName){ // 设置state
        this.houseName=houseName;
    }
    public String getHouseName(){ // 获取状态
        return houseName;
    }
    public Memento saveHouseNameToMemento(){ // 把状态增加到Memento
        return new Memento(houseName);
    }

}
