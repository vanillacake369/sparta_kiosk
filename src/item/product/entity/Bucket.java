package item.product.entity;

import utils.RoundDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 장바구니 */
public class Bucket {

    private final static List<Product> bucket = new ArrayList<>();

    private static Bucket instance;

    private Bucket() {

    }

    // 장바구니 싱글톤 객체 반환
    public static Bucket getInstance() {
        if (instance == null) {
            instance = new Bucket();
        }
        return instance;
    }

    // 장바구니에 제품 추가하기
    public static void addProduct(Product product) {
        bucket.add(product);
    }

    // 장바구니 비우기
    public static void removeAll() {
        bucket.clear();
    }

    // 장바구니에 있는 모든 제품의 가격의 총합 반환
    public static Double calculateAllPrice() {
        Double sum = bucket.stream()
                .map(product -> product.getPrice())
                .reduce(0D, Double::sum);
        return RoundDouble.round(sum, 2); // 소수점 2자리 반올림 :: utils 패키지 의존
    }

    // 장바구니 상태 문자열 반환
    public static String showBucket() {
        return bucket.stream().map(product -> product.toString()).collect(Collectors.joining("\n"));
    }
}
