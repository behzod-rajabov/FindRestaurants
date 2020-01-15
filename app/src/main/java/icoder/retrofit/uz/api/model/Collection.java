package icoder.retrofit.uz.api.model;

import java.util.List;

public class Collection {

    private List<CollectionClass> collections;

    public Collection(List<CollectionClass> collections) {
        this.collections = collections;
    }

    public List<CollectionClass> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionClass> collections) {
        this.collections = collections;
    }

    public class CollectionClass {

        private CollectionData collection;

        public CollectionClass(CollectionData collection) {
            this.collection = collection;
        }

        public CollectionData getCollection() {
            return collection;
        }

        public void setCollection(CollectionData collection) {
            this.collection = collection;
        }

        public class CollectionData {
            private int collection_id;
            private int res_count;
            private String image_url;
            private String url;
            private String title;
            private String description;
            private String share_url;

            public CollectionData(int collection_id, int res_count, String image_url, String url, String title, String description, String share_url) {
                this.collection_id = collection_id;
                this.res_count = res_count;
                this.image_url = image_url;
                this.url = url;
                this.title = title;
                this.description = description;
                this.share_url = share_url;
            }

            public int getCollection_id() {
                return collection_id;
            }

            public void setCollection_id(int collection_id) {
                this.collection_id = collection_id;
            }

            public int getRes_count() {
                return res_count;
            }

            public void setRes_count(int res_count) {
                this.res_count = res_count;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }
        }
    }

}
