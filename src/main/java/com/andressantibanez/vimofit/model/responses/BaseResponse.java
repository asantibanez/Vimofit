package com.andressantibanez.vimofit.model.responses;

import com.google.gson.Gson;

public class BaseResponse {

    public String toJson() {
        String json = new Gson().toJson(this);
        return json;
    }

}
