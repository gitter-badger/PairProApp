package net.zaim.pairproapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import net.zaim.pairproapp.signpostRetrofit.RetrofitHttpOAuthConsumer;
import net.zaim.pairproapp.signpostRetrofit.SigningOkClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class ApiHelper {
    private static ApiHelper ourInstance = new ApiHelper();

    private static ZaimEndpointInterface mEndpointInterface;

    public static ApiHelper getInstance(Context context) {
        return getInstance(context, false);
    }

    public static ApiHelper getInstance(Context context, boolean isRefreshToken) {
        if (mEndpointInterface == null || isRefreshToken) {
            mEndpointInterface = createInterface(context);
        }
        return ourInstance;
    }

    private static ZaimEndpointInterface createInterface(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String token = preferences.getString(Constants.PREF_KEY_CONSUMER, "");
        String tokenSecret = preferences.getString(Constants.PREF_KEY_CONSUMER_SECRET, "");
        RetrofitHttpOAuthConsumer oAuthConsumer =
                new RetrofitHttpOAuthConsumer(BuildConfig.ZAIM_CONSUMER_KEY, BuildConfig.ZAIM_CONSUMER_SECRET);
        oAuthConsumer.setTokenWithSecret(token, tokenSecret);
        OkClient client = new SigningOkClient(oAuthConsumer);
        return new RestAdapter.Builder()
                .setEndpoint(Constants.URL_API_HOST)
                .setClient(client)
                .build()
                .create(ZaimEndpointInterface.class);
    }

    private ApiHelper() {
    }

    public ZaimEndpointInterface apiService() {
        return mEndpointInterface;
    }
}
