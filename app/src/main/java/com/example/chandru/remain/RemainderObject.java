package com.example.chandru.remain;

import io.realm.RealmObject;

/**
 * Created by chandru on 1/4/2018.
 */

public class RemainderObject extends RealmObject {

    public String getOccation_detail() {
        return Occation_detail;
    }

    public void setOccation_detail(String occation_detail) {
        Occation_detail = occation_detail;
    }

    public String getDate_detail() {
        return Date_detail;
    }

    public void setDate_detail(String date_detail) {
        Date_detail = date_detail;
    }

    public String getTime_detail() {
        return Time_detail;
    }

    public void setTime_detail(String time_detail) {
        Time_detail = time_detail;
    }

    private String Occation_detail;
    private String Date_detail;
    private String Time_detail;

}
