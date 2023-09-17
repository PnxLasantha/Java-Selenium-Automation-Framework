package com.testUtil;

import java.sql.Timestamp;

public class TestDataGenerator {

    public Long generatTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
}
