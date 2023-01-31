package database.bankdb.dao.daointerfaces;


import java.util.List;

public interface IBaseDAO <T>{
    void insertEntity(T entity);
    T getEntityById(int id);
    void updateEntity(int id, T entity);
    void removeEntity(int id);
    List<T> getAllEntities();
}
