package com.hds.ssm.service.parkingrecord.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ParkingRecordDao;
import com.hds.ssm.model.ParkingRecord;
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
}
