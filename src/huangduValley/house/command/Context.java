package huangduValley.house.command;

import java.util.*;

import huangduValley.house.Furniture.FurnitureRoom;

public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;
    public FurnitureRoom froom;
    
//    public void setFurnitureRoom(FurnitureRoom froom) {
//    	this.froom=froom;
//    }
//    public Furniture creatFurniture(Furniture furniture) {
//    	froom.appendFurniture(furniture);
//		return furniture;
//    }
    public Context(String text) {
//    	super(4);
//    	froom=new FurnitureRoom(4);
        tokenizer = new StringTokenizer(text);
        nextToken();
    }
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }
    public String currentToken() {
        return currentToken;
    }
    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }
    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }
}
