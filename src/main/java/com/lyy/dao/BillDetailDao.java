package com.lyy.dao;

import com.lyy.domain.BillDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailDao {
    public int setBillDetail(BillDetail billDetail);

    public List<BillDetail> getBillDetailByUserId(int userId);

    public List<BillDetail> getBillDetailByUserIdAndTimeArea(
            @Param("userId") int id,
            @Param("startTime")String aa,
            @Param("endTime")String bb);
}
