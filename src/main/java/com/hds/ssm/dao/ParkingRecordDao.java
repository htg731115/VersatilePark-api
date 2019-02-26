package com.hds.ssm.dao;

import com.hds.ssm.model.ParkingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingRecordDao {
    List<ParkingRecord> getParkingRecord(@Param("state") Integer state);
}
