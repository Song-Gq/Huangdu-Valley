package huangduVally.house.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: memento
 * @description: CareTaker 存储Memento到mementoList
 **/

public class CareTaker {
    private List<huangduVally.house.memento.Memento> mementoList = new ArrayList<huangduVally.house.memento.Memento>(); //用List来存储memento

    public int length(){ // mementoList的长度
        return  mementoList.size();
    }
    public void addMemento(huangduVally.house.memento.Memento houseName){ // mementoList中增加新的memento,一个memento是Memento类型的houseName
        mementoList.add(houseName);
    }
    public huangduVally.house.memento.Memento getMemento(int index){ // 获取memento
        return mementoList.get(index);
    }
}
