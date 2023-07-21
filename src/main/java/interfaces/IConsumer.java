package interfaces;

import buckets.Bucket;
import implementations.Consumer;
import sinks.Sink;

public interface IConsumer<T> extends Runnable {
    static <T> IConsumer<T> of(Bucket<T> bucket, int nItemsToTake, Sink<T> sink){
        return new Consumer<>(bucket, nItemsToTake, sink);
    }
}
