package mapper;

public interface BaseMapper <T, C>{
    T getById(C id);
    T saveOrUpdate(T t);
    void deleteById(C c);
    default T getByName(String name){throw new UnsupportedOperationException("Operation getByName is unavailable");}
}
