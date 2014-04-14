
package com.andressantibanez.vimofit.endpoints;

import com.andressantibanez.vimofit.model.responses.ChannelsGetInfoResponse;
import com.andressantibanez.vimofit.model.responses.ChannelsGetVideosResponse;

import oauth.signpost.OAuthConsumer;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class ChannelsEndpoint extends BaseEndpoint{

    private ChannelsService service;

    private static interface ChannelsService {

        //GetVideos
        @GET("/v2?format=json&method=vimeo.channels.getVideos")
        public ChannelsGetVideosResponse getVideos(
                @Query("channel_id") String channelId,
                @Query("page") int page,
                @Query("per_page") int perPage,
                @Query("summary_response") int summaryResponse
        );

        @GET("/v2?format=json&method=vimeo.channels.getInfo")
        public ChannelsGetInfoResponse getInfo(
            @Query("channel_id") String channelId
        );

    }

    public ChannelsEndpoint(OAuthConsumer consumer, RestAdapter.LogLevel logLevel) {
        super(consumer, logLevel);
        service = restAdapter.create(ChannelsService.class);
    }

    public ChannelsGetVideosResponse getVideos(String channelId, int page, int perPage, int summaryResponse){
        return service.getVideos(channelId, page, perPage, summaryResponse);
    }

    public ChannelsGetInfoResponse getInfo(String channelId){
        return service.getInfo(channelId);
    }
}
