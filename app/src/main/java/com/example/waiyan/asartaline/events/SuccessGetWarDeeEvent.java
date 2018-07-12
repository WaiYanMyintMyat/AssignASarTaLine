package com.example.waiyan.asartaline.events;

import com.example.waiyan.asartaline.data.vos.GetWarDeeVO;

import java.util.List;

public class SuccessGetWarDeeEvent {
    private List<GetWarDeeVO> getWarDeeVOList;

    public SuccessGetWarDeeEvent(List<GetWarDeeVO> getWarDeeVOList) {
        this.getWarDeeVOList = getWarDeeVOList;
    }

    public List<GetWarDeeVO> getGetWarDeeVOList() {
        return getWarDeeVOList;
    }
}
