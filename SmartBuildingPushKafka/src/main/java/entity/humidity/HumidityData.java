package entity.humidity;

import com.alibaba.fastjson.JSONObject;

public class HumidityData extends JSONObject {

    private HumidityBrokerage brokerage;
    private HumidityEntity entity;
    private Feed feed;
    private Timeseries timeseries;

    public HumidityBrokerage getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(HumidityBrokerage brokerage) {
        this.brokerage = brokerage;
    }

    public HumidityEntity getEntity() {
        return entity;
    }

    public void setEntity(HumidityEntity entity) {
        this.entity = entity;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Timeseries getTimeseries() {
        return timeseries;
    }

    public void setTimeseries(Timeseries timeseries) {
        this.timeseries = timeseries;
    }
}
