package buckets.withoutSync;

import buckets.Bucket;

public class SimpleBucket<T> implements Bucket<T> {
    private T item;
    @Override
    public T getItem() throws Exception {
        T result = item;
        item = null;
        return result;
    }

    @Override
    public void setItem(T item) throws Exception {
        this.item = item;
    }
}
