package huangduValley.house.test;

import huangduValley.house.command.Context;
import huangduValley.house.command.Node;
import huangduValley.house.command.ProgramNode;

public class InterpreterTest {
    public static void main(String[] args) {
    	try {
		System.out.println("****************************  Test Interpreter  ****************************");

    	String command="build repeat 4 repeat 3 Desk Chair Sofa Desk Cabinet Bed end end end";
    	System.out.println("text = \"" + command + "\"");
        Node node = new ProgramNode();
//        FurnitureRoom furnitureroom = new FurnitureRoom(4);
//        furnitureroom.primitiveCommandNode.parse(new Context(command));
        node.parse(new Context(command));
        System.out.println("node = " + node);
    	}
    	catch(Exception e)
    	{
    		 e.printStackTrace();
    	}
		System.out.println("****************************************************************************");
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
//            String text;
//            while ((text = reader.readLine()) != null) {
//                System.out.println("text = \"" + text + "\"");
//                Node node = new ProgramNode();
//                node.parse(new Context(text));
//                System.out.println("node = " + node);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
