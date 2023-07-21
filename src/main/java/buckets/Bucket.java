package buckets;

public interface Bucket<T> {
    T getItem() throws Exception;
    void setItem(T item) throws Exception;
}
