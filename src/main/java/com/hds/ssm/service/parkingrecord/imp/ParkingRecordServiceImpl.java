package com.hds.ssm.service.parkingrecord.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ParkingRecordDao;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;
import com.hds.ssm.service.parkingrecord.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ParkingRecordService")
public class ParkingRecordServiceImpl implements ParkingRecordService {

    @Autowired
    ParkingRecordDao parkingRecordDao;
    @Override
    public PageInfo<ParkingRecord> getParkingRecord(Integer state,Integer pageNum, String start_Date, String end_Date) {
        PageHelper.startPage(pageNum,8);
        List<ParkingRecord> parkingRecords = parkingRecordDao.getParkingRecord(state,start_Date,end_Date);
        PageInfo<ParkingRecord> pageInfo = new PageInfo<>(parkingRecords);
        return pageInfo;
    }

    @Override
    public PortRQ getPortRecord(Integer projectId) {
        PortRQ inPort = parkingRecordDao.getPortRecordIn(projectId);//最后入场识别
        PortRQ outPort = parkingRecordDao.getPortRecordOut(projectId);//最后出场识别
        if(outPort.getRead_out_time().getTime() >inPort.getRead_in_time().getTime()){
            return outPort;
        }else{
            return inPort;
        }
    }

    @Override
    public void alterPortPlateNum(String plateNum) {

    }
}
