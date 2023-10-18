package item.menu.entity;

import item.Item;

public class Menu implements Item {

    private String name;
    private String description;

    private Menu(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }


    public static class Builder {
        private String name;
        private String description;

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}

