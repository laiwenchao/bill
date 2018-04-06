package com.lyy.service;

import com.lyy.domain.BillDetail;
import com.lyy.domain.DealBillDetail;

import java.util.List;

public interface BillDetailService {
    public int setBillDetail(BillDetail billDetail);
    public List<BillDetail> getBillDetailByUserId(int userId);
    public DealBillDetail getBillDetailByUserIdAndTimeArea
            (int userId, String startTime, String endTime);

    public List<DealBillDetail> getBillDetailByUserIdAndEveryDay(int userId, String startTime, String endTime);
}
