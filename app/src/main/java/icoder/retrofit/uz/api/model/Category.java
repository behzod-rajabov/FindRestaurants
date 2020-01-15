package icoder.retrofit.uz.api.model;

import java.util.List;

public class Category {

    private List<Categories> categories;

    public Category(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public class Categories {
        private CategoryData categories;

        public Categories(CategoryData categories) {
            this.categories = categories;
        }

        public CategoryData getCategories() {
            return categories;
        }

        public void setCategories(CategoryData categories) {
            this.categories = categories;
        }

        public class CategoryData {
            private int id;
            private String name;

            public CategoryData(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
