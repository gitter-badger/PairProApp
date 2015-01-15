package net.zaim.pairproapp.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    private CategoryInfo[] categories;

    public CategoryInfo[] getCategories() {
        return categories;
    }

    public class CategoryInfo {
        private long id;
        @SerializedName("name") private String title;
        @SerializedName("image") private String imageName;
        private String mode;
        private int active;
        @SerializedName("color") private String labelColorCode;
        @SerializedName("parent_category_id") private long parentCategoryId;
        @SerializedName("modified") private String lastModified;
        private String calc;
        @SerializedName("edit_flag") private int editFlag;
        private int sort;

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getImageName() {
            return imageName;
        }

        public String getMode() {
            return mode;
        }

        public int getActive() {
            return active;
        }

        public String getLabelColorCode() {
            return labelColorCode;
        }

        public long getParentCategoryId() {
            return parentCategoryId;
        }

        public String getLastModified() {
            return lastModified;
        }

        public String getCalc() {
            return calc;
        }

        public int getEditFlag() {
            return editFlag;
        }

        public int getSort() {
            return sort;
        }
    }
}
