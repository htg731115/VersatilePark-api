package com.hds.ssm.service.parkingrecord.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ParkingRecordDao;
import com.hds.ssm.model.*;
import com.hds.ssm.service.parkingrecord.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
        if(null ==outPort.getRead_out_time()){
            return inPort;
        }
        else{
            if(outPort.getRead_out_time().getTime() >inPort.getRead_in_time().getTime()){
                return outPort;
            }else{
                return inPort;
            }
        }
    }

    @Override
    public void alterPortPlateNum(String plateNum, Integer id) {
        parkingRecordDao.alterPortPlateNum(plateNum,id);
    }

    @Override
    public Integer getFreeParking(Integer projectId) {
        return parkingRecordDao.getFreeParking(projectId);
    }

    @Override
    public void openPort(Integer id, Integer managerId, String reason) {
        parkingRecordDao.openPort(id,managerId,reason);
    }

    @Override
    public ParkingRecord getParkingRecordById(Integer id) {
        return parkingRecordDao.getParkingRecordById(id);
    }

    @Override
    public void updateParkingRecord(Integer id, Date inTime, Date readOutTime, Date outTime) {
        parkingRecordDao.updateParkingRecord(id,inTime,readOutTime,outTime);
    }

    @Override
    public PageInfo<OpenPortRecord> getLogOpenRecord(Integer projectId,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<OpenPortRecord> openPortRecords = parkingRecordDao.getLogOpenRecord(projectId);

        PageInfo<OpenPortRecord> openPortRecordPageInfo = new PageInfo<>(openPortRecords);
        return openPortRecordPageInfo;
    }

    @Override
    public Date findOutTimeById(Integer id) {
        return parkingRecordDao.findOutTimeById(id);
    }

    @Override
    public List<carFlowRP> getCarFlow() {
        return parkingRecordDao.getCarFlow();
    }


    @Override
    public PageInfo<ParkingRecord> getParkingRecordByProjectId(Integer pageNum, Integer projectId) {
        PageHelper.startPage(pageNum,10);
        List<ParkingRecord> parkingRecordLits =  parkingRecordDao.getParkingRecordByProjectId(projectId,null,null,null);
        PageInfo<ParkingRecord> pageInfo = new PageInfo<>(parkingRecordLits);
        return pageInfo;
    }

    @Override
    public PageInfo<ParkingRecord> searchParkingRecord(Integer pageNum, Integer projectId,String plateNumber,String inTime, String endDate) {
        if(pageNum ==null)
            pageNum=1;
        PageHelper.startPage(pageNum,10);
        List<ParkingRecord> parkingRecordList = parkingRecordDao.getParkingRecordByProjectId(projectId,plateNumber,inTime,endDate);
        PageInfo<ParkingRecord> pageInfo = new PageInfo<>(parkingRecordList);
        return pageInfo;
    }

    @Override
    public List<ParkingRecordExcel> getParkingRecordExcelByProjectId(Integer projectId, String startData, String endDate) {
        return parkingRecordDao.excelGtParkingRecordByProjectId(projectId,startData,endDate);
    }

    @Override
    public void deleteParkingRecord(Integer parkingRecordId) {
        parkingRecordDao.deleteParkingRecord(parkingRecordId);
    }

    @Override
    public void insertParkingRecord(Integer projectId,String plateNumber, Date inTime) {
        parkingRecordDao.insertParkingRecord(projectId,plateNumber,inTime);
    }

}
