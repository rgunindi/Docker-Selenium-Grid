package starter.Model;

import net.thucydides.core.annotations.Step;

public class FavouritesField {
        public String id;
        public String user_id;
        public String image_id;
        public String sub_id;
        public String created_at;
        public Image image;

        public String getUserId() {
            return user_id;
        }

        public String getId() {
            return id;
        }

        public String getImage_id() {
            return image_id;
        }
        public String getCreated_at() {
            return created_at;
        }
        public String getSub_id() {
            return sub_id;
        }

        public class Image{
            public String id;
            public String url;
        }
    }


