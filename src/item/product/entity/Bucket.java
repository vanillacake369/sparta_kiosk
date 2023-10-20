package item.product.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 장바구니 */
public class Bucket {

    private final static List<Product> bucket = new ArrayList<>();

    private static Bucket instance;

    private Bucket() {

    }

    public static Bucket getInstance() {
        if (instance == null) {
            instance = new Bucket();
        }
        return instance;
    }

    public static List<Product> getBucket() {
        return bucket;
    }

    public static void addProduct(Product product) {
        bucket.add(product);
    }

    public static void removeAll() {
        bucket.clear();
    }


    public static String showBucket() {
        return bucket.stream().map(product -> product.toString()).collect(Collectors.joining());
    }
}
