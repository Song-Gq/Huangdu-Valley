package huangduVally.house.iterator;

public class Furniture {
    private String name;
    private int price;
    private String color;
    private String texture;
    public Furniture(String name,int price,String color,String texture) {
        this.name = name;
        this.price=price;
        this.color=color;
        this.texture=texture;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getColor() {
        return color;
    }
    public String getTexture() {
        return texture;
    }
    
}
