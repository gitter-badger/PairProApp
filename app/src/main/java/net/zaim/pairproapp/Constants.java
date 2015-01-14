package net.zaim.pairproapp;

public class Constants {

    public static final String URL_HOST = "https://www.zaim.net";
    public static final String URL_API_HOST = "https://api.zaim.net/v2";

    public static final String PATH_AUTH = "/users/auth";

    public static final String PATH_API_AUTH_REQUEST = "/auth/request";
    public static final String PATH_API_AUTH_ACCESS = "/auth/access";

    public static final String REQUEST_TOKEN_URL = URL_API_HOST + PATH_API_AUTH_REQUEST;
    public static final String ACCESS_TOKEN_URL = URL_API_HOST + PATH_API_AUTH_ACCESS;
    public static final String AUTHORIZE_URL = URL_HOST + PATH_AUTH;
    public static final String CALLBACK_URL = "zaimhistory://callback";

    public static final String PREF_KEY_CONSUMER = "consumer";
    public static final String PREF_KEY_CONSUMER_SECRET = "consumer_secret";
}
