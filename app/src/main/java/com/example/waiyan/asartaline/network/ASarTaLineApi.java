package com.example.waiyan.asartaline.network;

import com.example.waiyan.asartaline.network.responses.GetWarDeeResponse;
import com.example.waiyan.asartaline.utils.ASarTaLineConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ASarTaLineApi {
    @FormUrlEncoded
    @POST(ASarTaLineConstants.GET_ASTL_WAR_DEE)
    Call<GetWarDeeResponse> loadAstlWarDeeList(
            @Field(ASarTaLineConstants.PARAM_ACCESS_TOKEN) String accessToken);
}
