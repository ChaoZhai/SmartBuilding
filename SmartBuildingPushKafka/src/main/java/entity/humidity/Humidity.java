package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class Humidity extends JSONObject {

    private int signal;
    private HumidityData data;
    private int recipients;


    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public HumidityData getData() {
        return data;
    }

    public void setData(HumidityData data) {
        this.data = data;
    }

    public int getRecipients() {
        return recipients;
    }

    public void setRecipients(int recipients) {
        this.recipients = recipients;
    }
}
