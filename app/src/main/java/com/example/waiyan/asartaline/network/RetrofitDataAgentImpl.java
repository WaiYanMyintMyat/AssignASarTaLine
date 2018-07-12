package com.example.waiyan.asartaline.network;

import android.util.Log;

import com.example.waiyan.asartaline.events.ApiErrorEvent;
import com.example.waiyan.asartaline.events.SuccessGetWarDeeEvent;
import com.example.waiyan.asartaline.network.responses.GetWarDeeResponse;
import com.example.waiyan.asartaline.utils.ASarTaLineConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements ASarTaLineDataAgent {

    private static RetrofitDataAgentImpl objInstance;
    private ASarTaLineApi mApi;

    private RetrofitDataAgentImpl(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ASarTaLineConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mApi=retrofit.create(ASarTaLineApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance() {
        if(objInstance==null){
            objInstance=new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadAstlWarDeeList(String accessToken) {
        Call<GetWarDeeResponse> call=mApi.loadAstlWarDeeList(accessToken);
        call.enqueue(new Callback<GetWarDeeResponse>() {
            @Override
            public void onResponse(Call<GetWarDeeResponse> call, Response<GetWarDeeResponse> response) {
                GetWarDeeResponse warDeeResponse=response.body();
                if(warDeeResponse!=null && warDeeResponse.isResponseOk()){
                    SuccessGetWarDeeEvent event=new SuccessGetWarDeeEvent(warDeeResponse.getGetWarDeeVOList());
                    EventBus.getDefault().post(event);
                }else{
                    if(warDeeResponse==null){
                        ApiErrorEvent errorEvent=new ApiErrorEvent("Empty Response");
                        EventBus.getDefault().post(errorEvent);
                    }else{
                        ApiErrorEvent errorEvent=new ApiErrorEvent(warDeeResponse.getMessage());
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetWarDeeResponse> call, Throwable t) {
                ApiErrorEvent errorEvent=new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
