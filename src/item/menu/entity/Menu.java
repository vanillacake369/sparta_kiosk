package item.menu.entity;

import item.Item;

public class Menu implements Item {

    private String name;
    private String description;

    /* make constructor "private" */
    private Menu() {
    }

    private Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /* Use Builder to construct */
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

    @Override
    public void close() throws Exception {
        System.out.println("close Menu");
        close();
    }


    /* Builder */
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

