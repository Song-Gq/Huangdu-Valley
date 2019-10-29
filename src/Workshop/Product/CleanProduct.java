package Workshop.Product;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/28
 */
public class CleanProduct extends Product {
    private String name;

    public CleanProduct(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
