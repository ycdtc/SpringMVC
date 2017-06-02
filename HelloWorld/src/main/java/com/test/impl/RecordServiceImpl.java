package com.test.impl;

import com.test.dao.RecordDAO;
import com.test.model.Record;
import com.test.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Resource
    RecordDAO recordDAO;

    public int findRecordCountByUsername(String username) {
        return recordDAO.findRecordCountByUsername(username);
    }

    public int findRecordCountByDate(String date) {
        return recordDAO.findRecordCountByDate(date);
    }

    public void saveRecord(Record record) {
        recordDAO.saveRecord(record);
    }


}
