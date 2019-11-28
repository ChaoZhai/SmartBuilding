package entity.humidity;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class Value extends JSONObject {

    private Date time;
    private double timeAccuracy;
    private double data;
    private String type;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTimeAccuracy() {
        return timeAccuracy;
    }

    public void setTimeAccuracy(double timeAccuracy) {
        this.timeAccuracy = timeAccuracy;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
