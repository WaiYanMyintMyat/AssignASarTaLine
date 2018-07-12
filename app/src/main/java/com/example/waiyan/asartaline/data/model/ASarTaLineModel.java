package com.example.waiyan.asartaline.data.model;

import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;
import com.example.waiyan.asartaline.events.SuccessGetWarDeeEvent;
import com.example.waiyan.asartaline.network.ASarTaLineDataAgent;
import com.example.waiyan.asartaline.network.RetrofitDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASarTaLineModel {
    private static ASarTaLineModel objInstance;
    private ASarTaLineDataAgent mDataAgent;
    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    //Data Repository
    private Map<String, GetWarDeeVO> mNewWarDeeMap;

    private ASarTaLineModel() {
        mNewWarDeeMap = new HashMap<>();
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        EventBus.getDefault().register(this);
    }

    public static ASarTaLineModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new ASarTaLineModel();
        }
        return objInstance;
    }

    public GetWarDeeVO getWarDeeById(String warDeeId){
        return mNewWarDeeMap.get(warDeeId);
    }

    public void loadAstlWarDeeList() {
        mDataAgent.loadAstlWarDeeList(DUMMY_ACCESS_TOKEN);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {
        setDataIntoRepo(event.getGetWarDeeVOList());
    }

    private void setDataIntoRepo(List<GetWarDeeVO> getWarDeeVOList) {
        for (GetWarDeeVO getWarDeeVO : getWarDeeVOList) {
            mNewWarDeeMap.put(getWarDeeVO.getWarDeeId(), getWarDeeVO);
        }
    }
}
