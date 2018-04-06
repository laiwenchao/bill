package com.lyy.service.impl;

import com.lyy.dao.BillDetailDao;
import com.lyy.domain.BillDetail;
import com.lyy.domain.DealBillDetail;
import com.lyy.service.BillDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BillDetailServiceImpl implements BillDetailService {
    @Resource
    BillDetailDao billDetailDao;

    public int setBillDetail(BillDetail billDetail) {
        return billDetailDao.setBillDetail(billDetail);
    }

    public List<BillDetail> getBillDetailByUserId(int userId) {
        return billDetailDao.getBillDetailByUserId(userId);
    }

    public DealBillDetail getBillDetailByUserIdAndTimeArea(
            int userId, String startTime, String endTime) {
        List<BillDetail> listBillDetail = billDetailDao
                .getBillDetailByUserIdAndTimeArea(userId, startTime, endTime);
        return getDealBillDetail(listBillDetail);
    }

    public List<DealBillDetail> getBillDetailByUserIdAndEveryDay(int userId, String startTime, String endTime) {
        List<BillDetail> listBillDetail = billDetailDao
                .getBillDetailByUserIdAndTimeArea(userId, startTime, endTime);
        Map<String,List<BillDetail>> mapBill = new HashMap<String,List<BillDetail>>();
        for (BillDetail billDetail : listBillDetail){
            String dt = billDetail.getCustomTime().split(" ")[0];
            List<BillDetail> billDetails = mapBill.get(dt);
            if(billDetails==null){
                billDetails = new ArrayList<BillDetail>();
                mapBill.put(dt,billDetails);
            }
            billDetails.add(billDetail);
        }
        List<DealBillDetail> listdeal = new ArrayList<DealBillDetail>();
        Set<String> keySet = mapBill.keySet();
        for (String dt : keySet){
            List<BillDetail> list = mapBill.get(dt);
            DealBillDetail dealBillDetail = getDealBillDetail(list);
            dealBillDetail.setDt(dt);
            listdeal.add(dealBillDetail);
        }
        return listdeal;
    }
    private DealBillDetail getDealBillDetail(List<BillDetail> list){
        DealBillDetail dealBillDetail = new DealBillDetail();
        double max = 0, sum = 0, avg;
        double min = Double.MAX_VALUE;
        for (BillDetail billDetail : list) {
            double payAccount = billDetail.getPayAccount();
            if (payAccount > max) {
                max = payAccount;
            }
            if (payAccount < min) {
                min = payAccount;
            }
            sum += payAccount;
        }
        avg = sum / list.size();
        dealBillDetail.setMaxPay(max);
        dealBillDetail.setAvgPay(avg);
        dealBillDetail.setMinPay(min);
        return dealBillDetail;
    }



}
