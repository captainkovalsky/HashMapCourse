package main;
public class HashableObject {

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

    private Integer key;
    private Long value;

    public HashableObject(Long value, Integer key) {
        this.value = value;
        this.key = key;
    }
}
