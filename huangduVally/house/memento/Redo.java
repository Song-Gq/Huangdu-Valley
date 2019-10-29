package huangduVally.house.memento;

import huangduVally.house.House;

/**
 * @project: memento
 * @description: 撤销上一次撤销，恢复状态
 * @designPatter: Memento
 **/
public class Redo {
    public void Redo(huangduVally.house.memento.CareTaker careTaker, int index){
        if(index>=0&&index<careTaker.length()-1){
            House.getInstance().setHouseName(careTaker.getMemento(++index).getHouseName());
            System.out.print("MementoPattern:Redo:Redo:we are in careTaker["+index+"].The current HouseName are \""+ House.getHouseName()+"\"");
        }
        else{
            System.out.println("MementoPattern:Redo:Redo:redo fail,you can do redo operation because index is equal to careTaker.length()-1 ");
            System.out.print("MementoPattern:Redo:Redo:we are in careTaker["+index+"].The current HouseName are "+ House.getHouseName());

        }
    }
}
