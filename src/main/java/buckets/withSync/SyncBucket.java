package buckets.withSync;

import buckets.Bucket;

public class SyncBucket<T> implements Bucket<T> {
    private T item;
    private volatile boolean isFull;
    private final Object LOCK = new Object();
    @Override
    public T getItem() throws Exception {
        synchronized (LOCK){
            while (!isFull){
                LOCK.wait();
            }
            var result = item;
            item = null;
            isFull = false;
            LOCK.notifyAll();
            return result;
        }
    }

    @Override
    public void setItem(T item) throws Exception {
        synchronized (LOCK){
            while (isFull){
                LOCK.wait();
            }
            this.item = item;
            isFull = true;
            LOCK.notifyAll();
        }
    }
}
