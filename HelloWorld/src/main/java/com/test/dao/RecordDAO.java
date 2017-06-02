package com.test.dao;

import com.test.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RecordDAO {
    private static final String RECORD_COLLECTION = "record_info";

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;

    public int findRecordCountByUsername(String username){
        Query query = new Query();
        query.addCriteria(new Criteria("username").is(username));
        return mongoTemplate.find(query, Record.class, RECORD_COLLECTION).size();

    }

    public int findRecordCountByDate(String date){
        Query query = new Query();
        query.addCriteria(new Criteria("date").is(date));
        return mongoTemplate.find(query, Record.class, RECORD_COLLECTION).size();
    }

    public void saveRecord(Record record) {
        mongoTemplate.save(record, RECORD_COLLECTION);
    }

}
