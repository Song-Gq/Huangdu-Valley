package huangduVally.house.memento;

import huangduVally.house.House;

import java.util.Scanner;

import static huangduVally.house.House.showHouseName;

public class UndoOrRedo {

    public static void undoOrRedo(int index, Originator originator, CareTaker careTaker) {
        System.out.println("是否需要[1]撤回Undo [2]取消撤回Redo [3]不需要");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {// 判断输入的是否是整数 
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Undo");
                Undo undo = new Undo();

                System.out.println(" .we are in careTaker[" + index + "] ");
                undo.Undo(careTaker, index);
                if (index > 0)
                    index--;
                showHouseName();
                undoOrRedo(index, originator, careTaker);
            } else if (command == 2) {
                System.out.println("Redo");
                Redo redo = new Redo();

                System.out.println(" .we are in careTaker[" + index + "] ");
                redo.Redo(careTaker, index);
                if (index < careTaker.length() - 1)
                    index++;
                showHouseName();
                undoOrRedo(index, originator, careTaker);
            } else if (command == 3) {
                System.out.println("退出修改房屋名称");
            } else { // 输入错误正数
                System.out.println("请按要求正确输入!");
                undoOrRedo(index, originator, careTaker);
            }
        } else { // 如果输入错误的信息 
            System.out.println("输入的不是整数！请按要求正确输入!");
            undoOrRedo(index, originator, careTaker);
        }
    }


    private static class Undo {
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

    private static class Redo {
        public void Redo(huangduVally.house.memento.CareTaker careTaker, int index) {
            if (index >= 0 && index < careTaker.length() - 1) {
                House.getInstance().setHouseName(careTaker.getMemento(++index).getHouseName());
                System.out.print("MementoPattern:Redo:Redo:we are in careTaker[" + index + "].The current HouseName are \"" + House.getHouseName() + "\"");
            } else {
                System.out.println("MementoPattern:Redo:Redo:redo fail,you can do redo operation because index is equal to careTaker.length()-1 ");
                System.out.print("MementoPattern:Redo:Redo:we are in careTaker[" + index + "].The current HouseName are " + House.getHouseName());

            }
        }
    }

}










