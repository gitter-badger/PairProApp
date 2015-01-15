package net.zaim.pairproapp.model;

import com.google.gson.annotations.SerializedName;

public class Genre {
    private GenreInfo[] genres;

    public GenreInfo[] getGenres() {
        return genres;
    }
    
    public class GenreInfo {
        private long id;
        @SerializedName("parent_genre_id") private long parentId;
        private String name;
        private Category category;
        @SerializedName("category_id") private long categoryId;
        private int active;
        @SerializedName("edit_flag") private int editFlag;
        @SerializedName("modified") private String lastModified;
        private int sort;

        public long getId() {
            return id;
        }

        public long getParentId() {
            return parentId;
        }

        public String getName() {
            return name;
        }

        public Category getCategory() {
            return category;
        }

        public long getCategoryId() {
            return categoryId;
        }

        public int getActive() {
            return active;
        }

        public int getEditFlag() {
            return editFlag;
        }

        public String getLastModified() {
            return lastModified;
        }

        public int getSort() {
            return sort;
        }
    }
}
