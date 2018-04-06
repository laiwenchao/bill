package com.lyy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyy.domain.BillDetail;
import com.lyy.domain.DealBillDetail;
import com.lyy.service.BillDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping(value = "/billdetail")
public class BillDetailController {
    @Resource
    BillDetailService billDetailService;
    @RequestMapping(value = "/geURL",method =RequestMethod.GET )
    public String geURL(){
        return "billdetail";
    }


    @RequestMapping(value = "/billdetailsuccess",method = RequestMethod.POST)
    public String setBillDetailService(long user_id, String puduct_name, String description,double pay, String pay_time,
                                       HttpServletResponse response, HttpServletRequest request){
        BillDetail billDetail = new BillDetail();
        billDetail.setUserId(user_id);
        billDetail.setProductName(puduct_name);
        billDetail.setDescription(description);
        billDetail.setPayAccount(pay);
        billDetail.setCustomTime(pay_time);
        billDetailService.setBillDetail(billDetail);
        return "insertsunccess";
    }
    @ResponseBody
    @RequestMapping(value = "/getBillDetailByUserIdService",method = RequestMethod.POST)
    public JSONObject getBillDetailByUserIdService(int userId){
        JSONObject jsonObject= new JSONObject();
        List<BillDetail> listBillDetail = billDetailService.getBillDetailByUserId(userId);
        jsonObject.put("BillDetail",listBillDetail);
        return jsonObject;
    }
    @ResponseBody
    @RequestMapping(value = "getBillDetailByUserIdAndTimeAreaService",method = RequestMethod.POST)
    public JSONObject getBillDetailByUserIdAndTimeAreaService(int userId,String startTime,String endTime){
        JSONObject jsonObject = new JSONObject();
        DealBillDetail dealBillDetail = billDetailService.getBillDetailByUserIdAndTimeArea(userId,startTime,endTime);
        jsonObject.put("data",dealBillDetail);
        return  jsonObject;
    }
    @ResponseBody
    @RequestMapping(value = "getBillDetailGroupByDt",method = RequestMethod.POST)
    public JSONObject getBillDetailGroupByDt(int userId,String startTime,String endTime){
        JSONObject jsonObject = new JSONObject();
        List<DealBillDetail> listdealBillDetail = billDetailService.getBillDetailByUserIdAndEveryDay(userId,startTime,endTime);
        jsonObject.put("data",listdealBillDetail);
        return  jsonObject;
    }




}
