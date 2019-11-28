package stream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

/**
 * step2 clean data -CLEAN

 */

public class LogProcessor implements Processor<byte[], byte[]> {

    private ProcessorContext context;


    @Override
    public void init(ProcessorContext processorContext) {
        context=processorContext;
    }

    @Override
    public void process(byte[] bytes, byte[] bytes2) {
     //read line data
        String line = new String(bytes2);
        //Calculate variance(need to do)


        bytes2=line.getBytes();
        context.forward(bytes,bytes2);

        System.out.println(new String(bytes2));
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
