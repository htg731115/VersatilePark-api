package com.hds.ssm.service.parkingrecord;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;

import java.util.Map;

public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecord(Integer state,Integer pageNum,String startDate,String endDate);
    PortRQ getPortRecord (Integer projectId);
    void alterPortPlateNum(String plateNum,Integer id);
    Integer getFreeParking(Integer projectId);
    void openPort(Integer id,Integer managerId,String reason);
}
