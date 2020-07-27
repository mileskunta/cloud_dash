package com.ezhupai.service.admin;

import com.ezhupai.vo.BiddingInfoVo;

import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
public interface AdminService {

    List<String> generatePins(int sequence, int amount);

    BiddingInfoVo getBiddingInfo();

    void setBiddingInfo(BiddingInfoVo vo);
}
