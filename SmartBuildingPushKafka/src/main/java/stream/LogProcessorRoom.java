package stream;

import com.alibaba.fastjson.JSONObject;
import entity.humidity.Humidity;
import entity.humidity.RoomData;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 *
 * Take data for each room
 */


public class LogProcessorRoom implements Processor<byte[], byte[]> {

    private ProcessorContext context;


    @Override
    public void init(ProcessorContext processorContext) {
        context=processorContext;
    }

    @Override
    public void process(byte[] bytes, byte[] bytes2) {
        String line = new String(bytes2);
        //Process data as new data type

        Humidity jsonObject = (Humidity) JSONObject.parseObject(line, Humidity.class);
        JSONObject data = jsonObject.getJSONObject("data");
        RoomData roomData=new RoomData();

        String roomNo = "buildingPlantRoom和roomNumber都为空！";
        roomNo = (String) data.getJSONObject("brokerage").getJSONObject("meta").get("buildingPlantRoom");
        if (StringUtils.isEmpty(roomNo)) {
            roomNo = (String) data.getJSONObject("entity").getJSONObject("meta").get("roomNumber");
        }
        BigDecimal value = (BigDecimal) data.getJSONObject("timeseries").getJSONObject("value").get("data");

        roomData.setRoomNo(roomNo);
        roomData.setValue(value);

        //save new data to a new topic
        bytes2= String.valueOf(JSONObject.toJSON(roomData)).getBytes();
        context.forward(bytes,bytes2);
    }


    @Override
    public void close() {

    }

    public ProcessorContext getContext() {
        return context;
    }

    public void setContext(ProcessorContext context) {
        this.context = context;
    }
}
