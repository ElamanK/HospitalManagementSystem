package database.patterns.daofactory;

import database.bankdb.dao.daointerfaces.IBaseDAO;

public abstract class AbstractDAOFactory {

    public abstract IBaseDAO getDAO(String model);
}
