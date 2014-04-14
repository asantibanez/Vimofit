package com.andressantibanez.vimofit.model.responses;

import com.andressantibanez.vimofit.model.Err;
import com.andressantibanez.vimofit.model.Videos;
import com.google.gson.annotations.SerializedName;

public class AlbumsResponses {

    public static class GetWatchLaterResponse extends BaseResponse {
        @SerializedName("generated_in") public float generatedIn;
        public String stat;
        public Videos videos;
        public Err err;
    }

    public static class AddToWatchLaterResponse extends BaseResponse{
        @SerializedName("generated_in") public float generatedIn;
        public String stat;
        public Err err;
    }
}
