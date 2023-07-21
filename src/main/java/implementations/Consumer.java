package implementations;

import buckets.Bucket;
import interfaces.IConsumer;
import sinks.Sink;

public class Consumer<T> implements IConsumer<T> {
    private Bucket<T> bucket;
    private int nItemsToTake;
    private Sink<T> sink;

    public Consumer(Bucket<T> bucket, int nItemsToTake, Sink<T> sink) {
        this.bucket = bucket;
        this.nItemsToTake = nItemsToTake;
        this.sink = sink;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < nItemsToTake; i++) {
                var item = bucket.getItem();
                sink.add(item);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
