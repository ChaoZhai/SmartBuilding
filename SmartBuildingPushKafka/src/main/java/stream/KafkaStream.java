
package stream;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.Topology;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaStream {

    public static void main(String[] args) {

        //1,Remove dirty data (variance) from each topic
        //2, Consume each topic, transfer the json data to the entity, take the maximum value of each floor, each room data, and so on
        //3，New topic data structure redefinition (easy operation and calculation)
        Properties properties=new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("application.id","myGroup");
        List<String> list=new ArrayList<>();
        list.add("TEMPERATURE");
        list.add("HUMIDITY");
        list.add("CO2");
        list.add("LIGHTING");
        //clean up dirty data-CLEAN
        List<String> strings = processKafkaStreams(list, properties);
        //Step 3 Take out the data of each room-ROOM
        processKafkaStreams3(strings,properties);


    }

    //clean up dirty data-CLEAN
    private static List<String> processKafkaStreams(List<String> list, Properties properties){
        //The topic name where this step is saved
        List<String> lists=new ArrayList<>();
        //li is the original topic name，li-CLEAN,li-floor,li-room,li-top-room,li-max,li-common
        for (String li:list) {
            //Create topology objects
            Topology builder=new Topology();
            //  properties.put("group-id","myGroup");
            //Building the topology
            builder.addSource("first",li)
                    .addProcessor("PROCESSOR"+li, () -> new LogProcessor(),"first")
                    .addSink("SINK1",li+"-CLEAN","PROCESSOR"+li);
            lists.add(li+"-CLEAN");
            KafkaStreams kafkaStreams=new KafkaStreams(builder,properties);
            kafkaStreams.start();
        }
        return lists;

    }

    // Calculate the data of each layer-FLOOR
    private static void processKafkaStreams3(List<String> list, Properties properties){
        for (String li:list) {
            Topology builder=new Topology();
            //  properties.put("group-id","myGroup");
            builder.addSource("second",li)
                    .addProcessor("PROCESSOR2", () -> new LogProcessorRoom(),"second")
                    .addSink("SINK2",li.replace("CLEAN","FLOOR"),"PROCESSOR2");

            KafkaStreams kafkaStreams=new KafkaStreams(builder,properties);
            kafkaStreams.start();
        }

    }

}
