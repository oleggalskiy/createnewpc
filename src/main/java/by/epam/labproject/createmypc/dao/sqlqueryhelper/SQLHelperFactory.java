package by.epam.labproject.createmypc.dao.sqlqueryhelper;

import by.epam.labproject.createmypc.dao.sqlqueryhelper.impl.SqlQueryHelperImpl;

public class SQLHelperFactory {

        private static final SQLHelperFactory instance = new SQLHelperFactory();

        private final SqlQueryHelper  sqlQueryHelper = new SqlQueryHelperImpl();

        private SQLHelperFactory() {
        }

        public static SQLHelperFactory getInstance() {
            return instance;
        }


        public SqlQueryHelper getSQLHelper() {
            return  sqlQueryHelper;
        }

        }
