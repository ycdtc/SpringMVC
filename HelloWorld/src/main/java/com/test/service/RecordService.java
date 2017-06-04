package com.test.service;

import com.test.model.Data;
import com.test.model.Record;

/**
 * Created by Administrator on 2017/5/31.
 */
public interface RecordService {
    int findRecordCountByUsername(String username);
    int findRecordCountByDate(String date);
    void saveRecord(Record record);
    Data getRecordData(String prefix);
}
