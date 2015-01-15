package net.zaim.pairproapp.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private UserInfo me;

    public UserInfo getMe() {
        return me;
    }

    public class UserInfo {
        @SerializedName("id") private int userId;
        @SerializedName("login") private String loginName;
        @SerializedName("input_count") private int inputCount;
        @SerializedName("day_count") private int dayCount;
        @SerializedName("repeat_count") private int repeatCount;
        @SerializedName("currency_code") private String currencyCode;
        private int month;
        private int week;
        private int day;
        private int active;
        private int diff;

        private String name;
        @SerializedName("family_id") private int familyId;
        @SerializedName("gender_id") private int genderId;
        @SerializedName("birth_date") private String birthDate;
        @SerializedName("job_id") private int jobId;
        private String prefecture;
        private String city;
        private String charge;

        @SerializedName("profile_image_flag") private int profileImageFlag;
        @SerializedName("cover_image_flag") private int coverImageFlag;
        @SerializedName("pc_flag") private int pcFlag;
        @SerializedName("account_flag") private int accountFlag;
        @SerializedName("asset_flag") private int assetFlag;
        @SerializedName("budget_flag") private int budgetFlag;

        @SerializedName("profile_image_url") private String profileImageUrl;
        @SerializedName("cover_image_url") private String coverImageUrl;

        @SerializedName("profile_modified") private String lastProfileModified;
        @SerializedName("data_modified") private String lastDataModified;
        @SerializedName("modified") private String lastModified;
        private String created;

        public int getUserId() {
            return userId;
        }

        public String getLoginName() {
            return loginName;
        }

        public int getInputCount() {
            return inputCount;
        }

        public int getDayCount() {
            return dayCount;
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public int getMonth() {
            return month;
        }

        public int getWeek() {
            return week;
        }

        public int getDay() {
            return day;
        }

        public int getActive() {
            return active;
        }

        public int getDiff() {
            return diff;
        }

        public String getName() {
            return name;
        }

        public int getFamilyId() {
            return familyId;
        }

        public int getGenderId() {
            return genderId;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public int getJobId() {
            return jobId;
        }

        public String getPrefecture() {
            return prefecture;
        }

        public String getCity() {
            return city;
        }

        public String getCharge() {
            return charge;
        }

        public int getProfileImageFlag() {
            return profileImageFlag;
        }

        public int getCoverImageFlag() {
            return coverImageFlag;
        }

        public int getPcFlag() {
            return pcFlag;
        }

        public int getAccountFlag() {
            return accountFlag;
        }

        public int getAssetFlag() {
            return assetFlag;
        }

        public int getBudgetFlag() {
            return budgetFlag;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public String getLastProfileModified() {
            return lastProfileModified;
        }

        public String getLastDataModified() {
            return lastDataModified;
        }

        public String getLastModified() {
            return lastModified;
        }

        public String getCreated() {
            return created;
        }
    }
}
