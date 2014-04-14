package com.andressantibanez.vimofit.extras;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.andressantibanez.vimofit.R;
import com.andressantibanez.vimofit.endpoints.AlbumsEndpoint;

import retrofit.RestAdapter;

public class AlbumsTests extends Activity {

    public static final String tag = "AlbumsTests";

    public AlbumsEndpoint endpoint;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums_tests);

        new GetWatchLaterTask().execute();
    }

    private class GetWatchLaterTask extends AsyncTask<Void, Void, Void>{
        protected Void doInBackground(Void... voids) {
            Log.i(tag, "--- Unsigned Request ---");
            endpoint = new AlbumsEndpoint(
                Utils.getUnsignedOAuthConsumer(),
                RestAdapter.LogLevel.FULL
            );
            Log.e(tag, "Response: " + endpoint.getWatchLater(1, 25, 1).toJson());

            Log.i(tag, "--- Signed Request --- ");
            endpoint = new AlbumsEndpoint(
                Utils.getSignedOAuthConsumer(),
                RestAdapter.LogLevel.FULL
            );
            Log.e(tag, "Response: " + endpoint.getWatchLater(1, 25, 1).toJson());

            return null;
        }
    }
}
