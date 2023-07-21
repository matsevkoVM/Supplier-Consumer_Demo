package implementations;

import buckets.Bucket;
import interfaces.ISupplier;
import interfaces.Source;

public class Supplier<T> implements ISupplier<T> {
    private Bucket<T> bucket;
    private Source<T> source;

    public Supplier(Source<T> source, Bucket<T> bucket) {
        this.source = source;
        this.bucket = bucket;
    }


    @Override
    public void run() {
        try {
            for (var item : source) {
                bucket.setItem(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
