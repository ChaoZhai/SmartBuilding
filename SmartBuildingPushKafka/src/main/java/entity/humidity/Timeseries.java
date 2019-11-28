package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class Timeseries extends JSONObject {


    private String unit;
    private Value value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
