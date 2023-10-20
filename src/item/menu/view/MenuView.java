package item.menu.view;

import item.product.entity.ProductType;
import item.product.entity.Product;
import order.entity.OrderState;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MenuView {
    // 환영 메세지
    private final static String welcomeText = "\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n" +
            "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n";


    public String getWholeMenuView() {
        // 전체 메뉴판 문자열
        StringBuilder wholeMenu = new StringBuilder(welcomeText);
        AtomicInteger orderOptionStartSeq = new AtomicInteger(ProductType.values().length + 1);

        // 상품 메뉴들 추가
        wholeMenu.append("\n[ SHAKESHACK MENU ]\n");
        String productMenus = Arrays.stream(ProductType.values())
                .map(p -> p.getSeq() + ". " + p.getName() + "       |   " + p.getDescription() + "\n")
                .collect(Collectors.joining());
        wholeMenu.append(productMenus);

        // 주문 옵션 메뉴들 추가
        wholeMenu.append("\n[ ORDER MENU ]\n");
        String orderMenus = Arrays.stream(OrderState.values())
                .map(o -> (orderOptionStartSeq.getAndIncrement()) + ". " + o.getText() + "       |   " + o.getDescription() + "\n") // 주문 상태에는 seq가 없으므로 상품 메뉴 옵션번호를 사용
                .collect(Collectors.joining());
        wholeMenu.append(orderMenus);

        // 전체 메뉴판 반환
        return wholeMenu.toString();
    }

    public String getProductMenusView(int menuInput) throws Exception {
        ProductType productMenus = Arrays.stream(ProductType.values())
                .filter(productMenuType -> productMenuType.getSeq() == menuInput)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴는 메뉴판에 없는 메뉴입니다."));
        List<Product> items = productMenus.getItems();
        AtomicInteger productOptionStartSeq = new AtomicInteger(1);

        String productMenuStr = items.stream().map(product -> productOptionStartSeq.getAndIncrement() + ". " + product.toString()).collect(Collectors.joining());

        return welcomeText + productMenuStr;
    }
}
