package com.hds.ssm.service.parkingrecord;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.OpenPortRecord;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;
import com.hds.ssm.model.carFlowRP;

import java.util.Date;
import java.util.List;


public interface ParkingRecordService {
    PageInfo<ParkingRecord> getParkingRecord(Integer state,Integer pageNum,String startDate,String endDate);
    PortRQ getPortRecord (Integer projectId);
    void alterPortPlateNum(String plateNum,Integer id);
    Integer getFreeParking(Integer projectId);
    void openPort(Integer id,Integer managerId,String reason);
    ParkingRecord getParkingRecordById(Integer id);
    void updateParkingRecord(Integer id, Date inTime, Date readOutTime, Date outTime);
    PageInfo<OpenPortRecord> getLogOpenRecord(Integer projectId,Integer pageNum);
    Date findOutTimeById(Integer id);
    List<carFlowRP> getCarFlow();
}
