package by.epam.labproject.createmypc.dao.sqlqueryhelper;

import java.sql.ResultSet;

public interface SqlQueryHelper {

    void connectDb();
    void disconnectDb();
    void setTable(String tableName);
    ResultSet displayAllRecords();
    void setColumns(String columnName, String typeName, Integer typeLenght);
    ResultSet displaySelectiveRecord(int id);

    }
