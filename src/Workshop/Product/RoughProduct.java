package Workshop.Product;

/**
 *
 * @author Leepaangsang
 * @version 2019/10/28
 */
public class RoughProduct extends Product {
    private String name;

    public RoughProduct(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
