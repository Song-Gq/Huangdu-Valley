//package huangduValley.house.memento;
//
//import huangduValley.Stdout;
//import huangduValley.house.House;
//
//import java.util.Scanner;
//
//public class UndoOrRedo {
//
//    public static void undoOrRedo(int index, Originator originator, CareTaker careTaker) {
//        System.out.println("可以在这里选择:\n" +
//                "   [1]Undo,撤销并恢复成上一个小屋名字 [2]Redo，取消撤回 [3]不需要,谢谢～");
//        Scanner scanner = new Scanner(System.in);
//
//        if (scanner.hasNextInt()) {// 判断输入的是否是整数 
//            int command = scanner.nextInt();
//            if (command == 1) {
//                System.out.println("Undo");
//                Undo undo = new Undo();
//
//                System.out.println(" .we are in careTaker[" + index + "] ");
//                undo.Undo(careTaker, index);
//                if (index > 0)
//                    index--;
//                House.showHouseName();
//                undoOrRedo(index, originator, careTaker);
//            } else if (command == 2) {
//                System.out.println("Redo");
//                Redo redo = new Redo();
//                System.out.println(" .we are in careTaker[" + index + "] ");
//                redo.Redo(careTaker, index);
//                if (index < careTaker.length() - 1)
//                    index++;
//                House.showHouseName();
//                undoOrRedo(index, originator, careTaker);
//            } else if (command == 3) {
//                System.out.println("退出修改房屋名称");
//            } else { // 输入错误正数
//                System.out.println("请按要求正确输入!");
//                undoOrRedo(index, originator, careTaker);
//            }
//        } else { // 如果输入错误的信息 
//            System.out.println("输入的不是整数！请按要求正确输入!");
//            undoOrRedo(index, originator, careTaker);
//        }
//    }
//
//
//    private static class Undo {
//        public void Undo(CareTaker careTaker, int index){
//            if(index>0&&index<careTaker.length()){
//                House.getInstance().setHouseName(careTaker.getMemento(--index).getHouseName());
////                System.out.print("MementoPattern:Uedo:Uedo:we are in careTaker["+index+"].The current HouseName are \""+ House.getHouseName()+"\"");
//                Stdout.print(this,"careTaker["+index+"],成功撤回到上一个houseName啦！现在您小屋的名字是："+House.getHouseName()+"!");
//                House.showHouseName();
//            }
//            else{
////                System.out.println("MementoPattern:Uedo:Uedo:MementoPattern:Uedo:undo fail,you can do redo operation because index is equal to 0");
//                System.out.println("-----------------------------------------------------------------------------");
//                System.out.println("QAQ,撤销失败，\""+House.getInstance().getHouseName()+"\"为小屋的第一个名字，您还不能进行撤销和取消撤销的操作");
//                System.out.println("-----------------------------------------------------------------------------");
////                System.out.print("we are in careTaker["+index+"].The current HouseName are "+ House.getInstance().getHouseName());
//            }
//        }
//    }
//
//    private static class Redo {
//        public void Redo(CareTaker careTaker, int index) {
//            if (index > 0 && index < careTaker.length() - 1) {
//                House.getInstance().setHouseName(careTaker.getMemento(++index).getHouseName());
//                System.out.print("MementoPattern:Redo:Redo:we are in careTaker[" + index + "].The current HouseName are \"" + House.getHouseName() + "\"");
//            } else {
////                System.out.println("MementoPattern:Redo:Redo:redo fail,you can do redo operation because index is equal to careTaker.length()-1 ");
////                System.out.print("MementoPattern:Redo:Redo:we are in careTaker[" + index + "].The current HouseName are " + House.getHouseName());
//
//                System.out.println("QAQ,取消撤回失败，\""+House.getInstance().getHouseName()+"\"为第一个小屋名字，您还不能进行撤销和取消撤销的操作");
//            }
//        }
//    }
//
//}


package huangduValley.house.memento;

import huangduValley.Stdout;
import huangduValley.house.House;

import java.util.Scanner;

import static huangduValley.house.House.showHouseName;

public class UndoOrRedo {

    public static void undoOrRedo(int index, Originator originator, CareTaker careTaker) {
        for(;;) {
            System.out.println("----------------------------------");
            System.out.println("是否需要[1]Undo,撤销并恢复成上一个小屋名字 [2]Redo，取消撤回 [3]不需要,谢谢～");
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {// 判断输入的是否是整数 
                int command = scanner.nextInt();
                if (command == 1) {
                    Undo undo = new Undo();
                    undo.Undo(careTaker, index);
                    if (index > 0)
                        index--;
                } else if (command == 2) {
                    Redo redo = new Redo();
                    redo.Redo(careTaker, index);
                    if (index < careTaker.length() - 1)
                        index++;
                } else if (command == 3) {
                    System.out.println("退出修改房屋名称");
                    break;
                } else { // 输入错误正数
                    System.out.println("请按要求正确输入!");
                    undoOrRedo(index, originator, careTaker);
                }
            } else { // 如果输入错误的信息 
                System.out.println("输入的不是整数！请按要求正确输入!");
                undoOrRedo(index, originator, careTaker);
            }
        }
    }


    public static class Undo {
        public void Undo(huangduValley.house.memento.CareTaker careTaker, int index){
            if(index>0&&index<careTaker.length()){
                Stdout.print(this,"Undo！乌拉！成功撤回到上一个名字");
                House.getInstance().setHouseName(careTaker.getMemento(--index).getHouseName());
            }
            else{
                Stdout.print(this,"撤销失败，此处已经是Memento中最初始的地方惹，可以试试Redo。");}
        }
    }

    public static class Redo {
        public void Redo(huangduValley.house.memento.CareTaker careTaker, int index) {
            if (index >= 0 && index < careTaker.length() - 1) {
                Stdout.print(this,"Redo!乌拉！成功取消撤回！");
                House.getInstance().setHouseName(careTaker.getMemento(++index).getHouseName());
            } else {
                Stdout.print(this,"取消撤销失败，此处已经是Memento中最终保存的地方惹，可以试试Undo。");
            }
        }
    }

}



