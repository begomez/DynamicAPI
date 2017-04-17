package com.myapps.data;

/**
 * Created by bernatgomez on 17/4/17.
 */

public class KeyValue<K, V> extends BaseModel {
    private K key;
    private V value;


    public KeyValue() {

    }

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean validate() {
        return this.key != null && this.value != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyValue)) return false;

        KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;

        if (!key.equals(keyValue.key)) return false;
        return value.equals(keyValue.value);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
