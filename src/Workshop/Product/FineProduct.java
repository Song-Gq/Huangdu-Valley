package Workshop.Product;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/28
 */
public class FineProduct extends Product {
    private String name;

    private int count;

    public FineProduct(String name, int count){
        this.name = name;
        this.count = count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }
}
