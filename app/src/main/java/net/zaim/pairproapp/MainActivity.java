package net.zaim.pairproapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;


public class MainActivity extends ActionBarActivity {

    private OAuthConsumer mConsumer;
    private OAuthProvider mProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new OAuthRequestTask().execute();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null && uri.toString().startsWith(Constants.CALLBACK_URL)) {
            new OAuthGetTokenTask().execute(uri);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
     * 認証ページを表示するためのタスク
     */
    private class OAuthRequestTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                mConsumer = new CommonsHttpOAuthConsumer(
                        BuildConfig.ZAIM_CONSUMER_KEY, BuildConfig.ZAIM_CONSUMER_SECRET);
                mProvider = new CommonsHttpOAuthProvider(
                        Constants.REQUEST_TOKEN_URL, Constants.ACCESS_TOKEN_URL, Constants.AUTHORIZE_URL);
                return mProvider.retrieveRequestToken(mConsumer, Constants.CALLBACK_URL);
            }
            catch (OAuthMessageSignerException | OAuthCommunicationException |
                    OAuthExpectationFailedException | OAuthNotAuthorizedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String url) {
            super.onPostExecute(url);
            if (!TextUtils.isEmpty(url)) startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        }
    }

    /*
     * アクセストークンを取得するためのタスク
     */
    private class OAuthGetTokenTask extends AsyncTask<Uri, Void, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Constants.PREF_KEY_CONSUMER, mConsumer.getToken());
            editor.putString(Constants.PREF_KEY_CONSUMER_SECRET, mConsumer.getTokenSecret());
            editor.commit();
        }

        @Override
        protected Void doInBackground(Uri... params) {
            Uri uri = params[0];
            Log.d("MainActivity", "callback url: " + uri.toString());
            final String oauthVerifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);
            try {
                // AccessToken取得
                mProvider.retrieveAccessToken(mConsumer, oauthVerifier);
            }
            catch (OAuthMessageSignerException | OAuthCommunicationException |
                    OAuthExpectationFailedException | OAuthNotAuthorizedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
