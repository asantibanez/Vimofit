
package com.andressantibanez.vimofit.endpoints;

import com.andressantibanez.vimofit.clients.SignpostClient;

import oauth.signpost.OAuthConsumer;
import retrofit.RestAdapter;

public abstract class BaseEndpoint {

    public static final String BASE_ENDPOINT = "http://vimeo.com/api/rest";

    protected final OAuthConsumer consumer;
    protected RestAdapter restAdapter;
    protected final RestAdapter.LogLevel logLevel;

    public BaseEndpoint(final OAuthConsumer consumer, final RestAdapter.LogLevel logLevel) {
        this.consumer = consumer;
        this.logLevel = logLevel;

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_ENDPOINT)
                .setClient(new SignpostClient(this.consumer))
                .setLogLevel(this.logLevel)
                .build();
    }

}
