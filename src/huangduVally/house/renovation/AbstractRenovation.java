package huangduVally.house.renovation;

import java.io.Serializable;

public abstract class AbstractRenovation implements Serializable {

    private String name;

    private Double price;

    private String pattern;

    /**
     * Checks whether the object is empty
     * @return boolean
     */
    public abstract boolean isNil();

    /**
     * Clones the product and returns a new one
     * @return A new furniture
     */
    public abstract AbstractRenovation clone();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPattern(){
        return pattern;
    }

    public void setPattern(String pattern){
        this.pattern= pattern;
    }


}
