package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.ParkingRecord;
import com.hds.ssm.service.parkingrecord.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;

    @ResponseBody
    @RequestMapping(value = "/get-parkingRecord", method = RequestMethod.GET)
    public PageInfo<ParkingRecord> getParkingRecord(@RequestParam("state") Integer state, @RequestParam("pageNum") Integer pageNum, @RequestParam("start_Date") String startDate, @RequestParam("end_Date") String endDate){
        PageInfo <ParkingRecord> parkingRecords = parkingRecordService.getParkingRecord(state,pageNum);
        return parkingRecords;
    }
}
