package interfaces;


import buckets.Bucket;
import implementations.Supplier;

public interface ISupplier<T> extends Runnable {
    static <T> ISupplier<T> of(Source<T> source, Bucket<T> bucket){
        return new Supplier<>(source, bucket);
    }
}
