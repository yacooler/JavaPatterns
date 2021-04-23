package memento;

public interface Memento {
    String serializeObject();
    void deserializeObject(String serialized);
}
