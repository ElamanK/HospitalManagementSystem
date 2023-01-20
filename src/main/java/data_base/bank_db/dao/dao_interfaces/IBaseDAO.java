package data_base.bank_db.dao.dao_interfaces;

import java.util.List;

public interface IBaseDAO <T>{
    T getEntityById(int id);
    void updateEntity(int id, T entity);
    T createEntity(T entity);
    void removeEntity(int id);
    List<T> getAllEntities();
}
