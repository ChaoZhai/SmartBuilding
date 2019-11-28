package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class Feed extends JSONObject {
    private String metric;
    private Meta meta;


    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
