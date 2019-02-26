package com.hds.ssm.service.parkingrecord;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.ParkingRecord;

public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecord(Integer state,Integer pageNum);
}
