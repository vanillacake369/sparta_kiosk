package common;

import item.Item;

import java.util.List;

public interface View {
    String getView(List<Item> menus, Long productMenuSize, Long orderMenuSize);
}
