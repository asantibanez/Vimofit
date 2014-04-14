package com.andressantibanez.vimofit.endpoints;

import com.andressantibanez.vimofit.model.Video;

import oauth.signpost.OAuthConsumer;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class VideosEndpoint extends BaseEndpoint {

    private VideosService service;

    public static interface VideosService{

        //GetInfo
        @GET("/v2?format=json&method=vimeo.videos.getInfo")
        public Video getInfo(
          @Query("video_id") int videoId
        );
    }

    public VideosEndpoint(OAuthConsumer consumer, RestAdapter.LogLevel logLevel) {
        super(consumer, logLevel);
        service = restAdapter.create(VideosService.class);
    }

    public Video getInfo(int videoId){
        return service.getInfo(videoId);
    }
}
