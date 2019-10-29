package huangduVally.house.memento;

import static huangduVally.house.House.showHouseName;

import huangduVally.house.House;

/**
 * @project: memento
 * @description: 撤销上一命令
 * @designPatter: Memento
 **/

public class Undo {
    public void Undo(huangduVally.house.memento.CareTaker careTaker, int index){
        if(index>0&&index<careTaker.length()){
            House.getInstance().setHouseName(careTaker.getMemento(--index).getHouseName());
            System.out.print("MementoPattern:Uedo:Uedo:we are in careTaker["+index+"].The current HouseName are \""+ House.getHouseName()+"\"");
            showHouseName();
        }
        else{
            System.out.println("MementoPattern:Uedo:Uedo:MementoPattern:Uedo:undo fail,you can do redo operation because index is equal to 0");
            System.out.print("we are in careTaker["+index+"].The current HouseName are "+ House.getInstance().getHouseName());
        }
    }

}
