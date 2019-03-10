package com.hds.ssm.service.parkingrecord;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;

public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecord(Integer state,Integer pageNum,String startDate,String endDate);
    PortRQ getPortRecord (Integer projectId);
    void alterPortPlateNum(String plateNum);
}
