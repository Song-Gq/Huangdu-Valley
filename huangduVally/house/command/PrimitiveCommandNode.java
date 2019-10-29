package huangduVally.house.command;
import huangduVally.house.Furniture.*;
// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    private Furniture froom;
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        
//        if (name=="Chair") {
//        	froom = context.creatFurniture(new Furniture("Chair",143,"Red","Aluminum"));
//        } else if (name=="Desk") {
//        	froom = context.creatFurniture(new Furniture("Desk",382,"Black","Wood"));
//        } else if (name=="Bed") {
//        	froom = context.creatFurniture(new Furniture("Bed",521,"Pink","Wood"));
//        } else if (name=="Sofa") {
//        	froom = context.creatFurniture(new Furniture("Sofa",532,"Blue","Leather"));
//        }else if (name=="Cabinet") {
//        	froom = context.creatFurniture(new Furniture("Cabinet",225,"Yellow","Wood"));
//        }
//        else {
//        	throw new ParseException(name + " is undefined");
//        }

//        froom = context.creatFurniture(new Furniture("Chair",143,"Red","Aluminum"));
        if (!name.equals("Bed") && !name.equals("Desk") && !name.equals("Chair")&& !name.equals("Sofa")&& !name.equals("Cabinet")) {
            throw new ParseException(name + " is undefined");
        }
//        for(int i=0;i<time;i++) {
//        System.out.println(name);}
    }
    public String toString() {
        return name;
    }
}
