package by.epam.labproject.createmypc.dao.sqlqueryhelper.impl;

import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.sqlqueryhelper.SqlQueryHelper;
import com.healthmarketscience.sqlbuilder.BinaryCondition;
import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbColumn;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSchema;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbSpec;
import com.healthmarketscience.sqlbuilder.dbspec.basic.DbTable;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class SqlQueryHelperImpl implements SqlQueryHelper {

    private Statement stmtObj;

    private Connection connObj;

    private DbSchema schemaObj;

    private DbSpec specficationObj;

    private DbTable table_name;

    private DbColumn column_1, column_2, column_3, column_4, column_5, column_6, column_7, column_8;

    private final static Logger logger = Logger.getLogger(SqlQueryHelperImpl.class);

    public SqlQueryHelperImpl() {
    }

    private Connection takeConnectionFromPool() throws DAOException {
        ConnectionPool conPool = ConnectionPool.getInstance();
        try {
            return conPool.takeConnection();
        } catch (InterruptedException e) {
            throw new DAOException("Can't take a connection from connPool", e);
        }
    }

    @Override
    public void connectDb() {
        try {
            this.connObj = takeConnectionFromPool();
            logger.info("\n=======Database Connection Open=======\n");
            this.stmtObj = connObj.createStatement();
            logger.info("\n=======Statement Object Created=======\n");
            loadSQLBuilderSchema();
        } catch (DAOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadSQLBuilderSchema() {
        this.specficationObj = new DbSpec();
        this.schemaObj = specficationObj.addSchema("mypcdb");
        logger.info("\n=======Load DBschema: "+ schemaObj.toString()+" Successful=======\n");
    }
    @Override
    public void disconnectDb() {
        try {
            stmtObj.close();
            connObj.close();
            logger.info("\n=======Database Connection Closed=======\n");
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public ResultSet displayAllRecords() {
        String displayRecordsQuery = new SelectQuery().addAllTableColumns(table_name).validate().toString();
        try {
            logger.info("\nGenerated Sql Query?= " + displayRecordsQuery + "\n");
            return stmtObj.executeQuery(displayRecordsQuery);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet displaySelectiveRecord(int id) {
        String selectiveSelectiveQuery;
        try {
            selectiveSelectiveQuery = new SelectQuery().addAllTableColumns(table_name).addCondition(BinaryCondition.equalTo(column_1, id)).validate().toString();
            logger.info("\nGenerated Sql Query?= "+ selectiveSelectiveQuery + "\n");
            return stmtObj.executeQuery(selectiveSelectiveQuery);

        } catch(Exception sqlException) {

            sqlException.printStackTrace();

        }

        logger.info("\n=======Specific Record Displayed From The '" + table_name.getTableNameSQL() + "'=======\n");
        return null;
    }

    @Override
    public void setTable(String tableName) {
        this.table_name = this.schemaObj.addTable(tableName);
    }
    @Override
    public void setColumns(String columnName, String typeName, Integer typeLenght) {
        this.table_name.addColumn(columnName, typeName, typeLenght);
           }

    public void setColumn_1(String column_1) {
        this.column_1 = this.table_name.findColumn(column_1);;
    }
    public void setColumn_2(String column_2) {
        this.column_2 = this.table_name.findColumn(column_2);;
    }
    public void setColumn_3(String column_3) {
        this.column_3 = this.table_name.findColumn(column_3);;
    }
    public void setColumn_4(String column_4) {
        this.column_4 = this.table_name.findColumn(column_4);;
    }
    public void setColumn_5(String column_5) {
        this.column_5 = this.table_name.findColumn(column_5);;
    }
    public void setColumn_6(String column_6) {
        this.column_6 = this.table_name.findColumn(column_6);;
    }
    public void setColumn_7(String column_7) {
        this.column_7 = this.table_name.findColumn(column_7);;
    }
    public void setColumn_8(String column_8) {
        this.column_8 = this.table_name.findColumn(column_8);;
    }


}
