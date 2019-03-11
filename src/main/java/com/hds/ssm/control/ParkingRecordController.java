package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.model.PortRQ;
import com.hds.ssm.model.Project;
import com.hds.ssm.service.parkingrecord.ParkingRecordService;
import com.hds.ssm.service.project.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;
    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/get-parkingRecord", method = RequestMethod.GET)
    public PageInfo<ParkingRecord> getParkingRecord(@RequestParam("state") Integer state, @RequestParam("pageNum") Integer pageNum, @RequestParam(value = "start_Date",required = false) String startDate, @RequestParam(value = "end_Date",required = false) String endDate){
        PageInfo <ParkingRecord> parkingRecords = parkingRecordService.getParkingRecord(state,pageNum,startDate,endDate);
        return parkingRecords;
    }

    @ResponseBody
    @RequestMapping(value="/get-port-record",method = RequestMethod.GET)
    public PortRQ getPortRecord(@RequestParam(value = "projectId", required = false) Integer projectId){
        PortRQ portRQ = parkingRecordService.getPortRecord(projectId);
        int processFlag = 0;
        Date readInTime = portRQ.getRead_in_time();
        Date readOutTime = portRQ.getRead_out_time();
        Date inTime = portRQ.getOut_time();
        Date outTime = portRQ.getOut_time();
        if(projectId != null) {
            Project project = projectService.findProjectById(portRQ.getId());
            portRQ.setProjectName(project.getName());
        }
        if(outTime == null)
        {
            if(readOutTime == null){
                if(inTime == null){
                    processFlag = 0;
                }else {
                    processFlag = 1;
                }
            }else{
                processFlag = 2;
            }
        }else{
            processFlag = 3;
        }
        portRQ.setProcessFlag(processFlag);
        return portRQ;
    }

    @ResponseBody
    @RequestMapping(value = "/alter-port-record-plateNum",method = RequestMethod.POST)
    public void alterPortPlateNum(@RequestParam("plateNum")String plateNum, @RequestParam("id") Integer id){
        parkingRecordService.alterPortPlateNum(plateNum,id);
    }

    @ResponseBody
    @RequestMapping(value = "/get-free-parking", method = RequestMethod.GET)
    public Map<String, Object> getFreeParking(@RequestParam("projectId") Integer projectId){
        Map<String, Object> map = new HashMap<>();
        Integer freeParkingNum = parkingRecordService.getFreeParking(projectId);
        Project project = projectService.findProjectById(projectId);
        Double percent = (double)freeParkingNum/project.getManage_num();
        map.put("freeParkingNum",freeParkingNum);
        map.put("percent",percent);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/open-port", method = RequestMethod.POST)
    public void openPort(@RequestParam("id") Integer id, @RequestParam("managerId") Integer managerId , @RequestParam("reason") String reason){
        parkingRecordService.openPort(id,managerId,reason);
    }
}
