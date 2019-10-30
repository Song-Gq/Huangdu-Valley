package Workshop;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/30
 */
public  class Ingredients {
    /**
     *
     * @param count
     * Number of Ingredients
     * @param name
     * Name of Ingredients
     */
    public Ingredients(int count, String name){
        this.count = count;
        this.name = name;
    }
    private int count;

    private String name;

    public int getCount(){
        return this.count;
    }

    public String getName(){
        return this.name;
    }
}
