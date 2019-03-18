package com.hds.ssm.dao;

import com.hds.ssm.model.OpenPortRecord;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;
import com.hds.ssm.model.carFlowRP;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ParkingRecordDao {
    List<ParkingRecord> getParkingRecord(@Param("state") Integer state, @Param("start_date") String start_Date, @Param("end_date") String end_Date);
    PortRQ getPortRecordOut(@Param("projectId") Integer projectId);
    PortRQ getPortRecordIn(@Param("projectId") Integer projectId);
    void alterPortPlateNum(@Param("plateNum") String plateNum, @Param("id") Integer id);
    Integer getFreeParking(@Param("projectId") Integer projectId);
    void openPort(@Param("id") Integer id,@Param("managerId") Integer managerId,@Param("reason") String reason);
    ParkingRecord getParkingRecordById(@Param("id") Integer id);
    void updateParkingRecord(@Param("id")Integer id, @Param("inTime")Date inTime,@Param("readOutTime") Date readOutTime, @Param("outTime") Date outTime);
    List<OpenPortRecord> getLogOpenRecord(@Param("projectId") Integer projectId);
    Date findOutTimeById(@Param("id")Integer id);
    List<carFlowRP> getCarFlow();

}
