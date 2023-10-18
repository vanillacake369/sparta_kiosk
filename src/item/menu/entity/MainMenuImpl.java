package item.menu.entity;

public class MainMenuImpl implements Menu {

    private String name;
    private String description;

    private MainMenuImpl(Builder builder) {
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

        public MainMenuImpl build() {
            return new MainMenuImpl(this);
        }
    }
}

