package house.interpreter;
import house.iterator.*;
// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
//        FurnitureRoom furnitureroom = new FurnitureRoom(4);
        context.skipToken(name);
        if (!name.equals("bed") && !name.equals("desk") && !name.equals("chair")&& !name.equals("sofa")&& !name.equals("cabinet")) {
            throw new ParseException(name + " is undefined");
        }
        System.out.println(name);
    }
    public String toString() {
        return name;
    }
}
