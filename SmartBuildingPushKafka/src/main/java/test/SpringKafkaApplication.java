package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;

@SpringBootApplication
@Slf4j
public class SpringKafkaApplication {

    public static void main(String[] args) {
        //读取文件路径（是否做成可配置？？？）
        String dataPath = "C:\\newcastle\\data.txt";
        //初始化kafka
        ConfigurableApplicationContext context = SpringApplication.run(SpringKafkaApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);
        readLine(dataPath,sender);

    }

    //读取文件 并且根据主题写入kafka
    public static void readLine(String fileName,KafkaSender sender) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));//构造一个BufferedReader类来读取文件
            // PrintWriter out = new PrintWriter(new File("C:\\result.txt"));
            //将处理后的文件output.txt创建到该地址下
            String str=null;
            while ((str=br.readLine())!=null) {
                //按行读取，遇到换行符停止。将读取到的内容赋值到str中
                 String[] ss = str.split(" b'");//按照指定字符将字符串分割，并将分割后的字符串放入数组中

                for (String s : ss) {
                    if (s.length() > 36) {
                        s = s.substring(0 , s.length() - 36);
                        if (s.toLowerCase().contains("temperature")) {
                            sender.send("TEMPERATURE",s);
                            log.info("topic temperature add success");
                        } else if (s.toLowerCase().contains("humidity")) {
                            sender.send("HUMIDITY",s);
                            log.info("topic humidity add success");
                        } else if (s.toLowerCase().contains("co2")) {
                            sender.send("CO2",s);
                            log.info("topic co2 add success");
                        } else if (s.toLowerCase().contains("lighting")) {
                            sender.send("LIGHTING",s);
                            log.info("topic lighting add success");
                        }
                    }

                }
                log.info("add data end......");
            }

        } catch (Exception e) {
            log.error("push data to kafka error",e);
        }
    }

}
