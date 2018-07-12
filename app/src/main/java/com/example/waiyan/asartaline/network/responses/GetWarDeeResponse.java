package com.example.waiyan.asartaline.network.responses;

import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetWarDeeResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<GetWarDeeVO> getWarDeeVOList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<GetWarDeeVO> getGetWarDeeVOList() {
        return getWarDeeVOList;
    }

    public boolean isResponseOk() {
        return (code==200 && getWarDeeVOList!=null);
    }
}
