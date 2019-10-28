package house.interpreter;
import java.util.*;
import java.io.*;
import house.iterator.FurnitureRoom;

public class TestInterpreter {
    public static void main(String[] args) {
    	try {
    	String command="build repeat 4 repeat 3 desk chair sofa desk cabinet bed end end end";
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
