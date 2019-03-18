package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.*;
import com.hds.ssm.service.manage.ManagerService;
import com.hds.ssm.service.parkingrecord.ParkingRecordService;
import com.hds.ssm.service.project.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.*;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ManagerService managerService;

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
        Date inTime = portRQ.getIn_time();
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
        ParkingRecord parkingRecord = parkingRecordService.getParkingRecordById(id);
        Date readOutTime = parkingRecord.getRead_out_time();
        Date inTime = parkingRecord.getIn_time();
        Date outTime = parkingRecord.getOut_time();
        Date now = new Date();
        if(inTime == null){
            inTime = now;
            readOutTime = now;
            outTime = now;
            parkingRecordService.updateParkingRecord(id,inTime,readOutTime,outTime);
        } else if(readOutTime ==null){
            readOutTime = now;
            outTime = now;
            parkingRecordService.updateParkingRecord(id,null,readOutTime,outTime);
        } else if(outTime == null){
            outTime = now;
            parkingRecordService.updateParkingRecord(id,null,null,outTime);
        }
        parkingRecordService.openPort(id,managerId,reason);
    }

    @ResponseBody
    @RequestMapping(value = "/get-log-open-record", method = RequestMethod.GET)
    public PageInfo<OpenPortRecord> getLogOpenRecord(@RequestParam("projectId") Integer projectId,@RequestParam("pageNum") Integer pageNum){
        PageInfo<OpenPortRecord>logOpenRecord = parkingRecordService.getLogOpenRecord(projectId, pageNum);
        String projectName,managerName;
        Date outTime;
        for (OpenPortRecord record:logOpenRecord.getList()) {
            managerName = managerService.FindManage(record.getManager_id()).getName();
            projectName = projectService.findProjectById(projectId).getName();
            outTime = parkingRecordService.findOutTimeById(record.getId());
            record.setManager_name(managerName);
            record.setProject_name(projectName);
            record.setOut_time(outTime);
        }
        return logOpenRecord;
    }

    @ResponseBody
    @RequestMapping(value = "/get-carFlow",method = RequestMethod.GET)
    public List<carFlowRP> getCarFlow(){
        Calendar cal =  Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        int tempYear = cal.get(Calendar.YEAR)-1;
        boolean flag = false;
        int temp[] =new int[6];
        String[] str= new String[6];
        Map<String,Integer> map = new TreeMap<>(new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                // 降序排序
                return obj2.compareTo(obj1);
            }
        });;
        for (int i=0;i<6;i++){
            temp[i] = month-i;
            if (temp[i]<=0 ){
                temp[i] = 12+temp[i];
                flag = true;
            }
            if(flag){
                year = tempYear;
            }
            if(temp[i]<10){
                str[i] = String.valueOf(year) +'0'+temp[i]+"";
            }else{
                str[i] = String.valueOf(year) +temp[i]+"";
            }
            map.put(str[i],0);
        }
        List<carFlowRP> list;
        list = parkingRecordService.getCarFlow();
        for (carFlowRP carFlowRP1:list) {
            map.put(carFlowRP1.getTime(),carFlowRP1.getCarNum());
        }

        list.clear();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            carFlowRP carFlowRP2 = new carFlowRP();
            carFlowRP2.setCarNum(entry.getValue());
            carFlowRP2.setTime(entry.getKey());
            list.add(carFlowRP2);
        }
        return list;

    }

}
