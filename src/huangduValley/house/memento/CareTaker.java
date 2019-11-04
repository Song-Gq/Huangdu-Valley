package huangduValley.house.memento;

import huangduValley.Stdout;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: memento
 * @description: CareTaker 存储Memento到mementoList
 **/

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>(); //用List来存储memento

    public int length(){ // mementoList的长度
        return  mementoList.size();
    }
    public void addMemento(Memento houseName){ // mementoList中增加新的memento,一个memento是Memento类型的houseName
        mementoList.add(houseName);
        Stdout.print(this,"把"+houseName.getHouseName()+"增加到Memento中");
    }
    public Memento getMemento(int index){ // 获取memento
        Stdout.print(this,"获取存储在MementoList中的\""+mementoList.get(index).getHouseName()+"\"");
        return mementoList.get(index);
    }
}
