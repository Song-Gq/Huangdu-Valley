package huangduValley.house.command;
// <repeat command> ::= repeat <number> <command list>

import huangduValley.house.command.*;
public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
//        this.settime(time*number);
//        System.out.println(time);
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
        return "repeat " + number + " " + commandListNode + "";
    }
}
