package huangduVally.house.memento;

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
    public huangduVally.house.memento.Memento saveHouseNameToMemento(){ // 把状态增加到Memento
        return new huangduVally.house.memento.Memento(houseName);
    }

}
