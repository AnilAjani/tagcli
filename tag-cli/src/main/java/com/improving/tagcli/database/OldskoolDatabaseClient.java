package com.improving.tagcli.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Result;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class OldskoolDatabaseClient {
    private static final Logger logger = LoggerFactory.getLogger(OldskoolDatabaseClient.class);

    public void readRecordIntoDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            logger.info("Connection + Statement Made");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM weapon LIMIT 10");
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columns = "";
            for (int i=1; i<= metaData.getColumnCount(); i++) {
                columns = columns + "(" + i + ")" + metaData.getCatalogName(i) + ",";
            }
            logger.info("Table Column: " + columns);
            resultSet.beforeFirst();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(3);
                String area = resultSet.getString(17);
                logger.info("Id {}, Name {}, Area {}", id, name, area);

            }

            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }



    public void insertRecordIntoDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            logger.info("Connection + Statement Made");
    } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tag?serverTimezone=UTC",
                "ANIL",
                "impr0ving");
        connection.setAutoCommit(false);
        return connection;
    }
}
