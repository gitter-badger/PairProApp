package net.zaim.pairproapp.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    private AccountInfo[] accounts;

    public AccountInfo[] getAccounts() {
        return accounts;
    }
    
    public class AccountInfo {
        private long id;
        private String name;
        @SerializedName("color") private String labelColorCode;
        @SerializedName("image") private String imageName;
        @SerializedName("modified") private String lastModified;
        @SerializedName("currency_code") private String currencyCode;
        @SerializedName("calc_flag") private int calcFlag;
        @SerializedName("local_id") private int localId;
        private int sort;
        private int active;
        @SerializedName("account_group") private String accountGroup;
        @SerializedName("online_account_id") private int onlineAccountId;
        @SerializedName("original_name") private String originalName;
        @SerializedName("parent_account_id") private int parentAccountId;
        @SerializedName("to_account_id") private int toAccountId;
        @SerializedName("from_account_id") private int fromAccountId;
        @SerializedName("icon_url") private String iconUrl;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLabelColorCode() {
            return labelColorCode;
        }

        public String getImageName() {
            return imageName;
        }

        public String getLastModified() {
            return lastModified;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public int getCalcFlag() {
            return calcFlag;
        }

        public int getLocalId() {
            return localId;
        }

        public int getSort() {
            return sort;
        }

        public int getActive() {
            return active;
        }

        public String getAccountGroup() {
            return accountGroup;
        }

        public int getOnlineAccountId() {
            return onlineAccountId;
        }

        public String getOriginalName() {
            return originalName;
        }

        public int getParentAccountId() {
            return parentAccountId;
        }

        public int getToAccountId() {
            return toAccountId;
        }

        public int getFromAccountId() {
            return fromAccountId;
        }

        public String getIconUrl() {
            return iconUrl;
        }
    }
}
