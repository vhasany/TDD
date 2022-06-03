package com.example.tdd.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableManager {
  public static void createTable(Connection connection) {
    var sql = "CREATE TABLE IF NOT EXISTS PASSENGERS (ID VARCHAR(50),NAME VARCHAR(50));";
    executeStatement(connection, sql);
  }

  public static void dropTable(Connection connection) {
    String sql = "DROP TABLE IF EXISTS PASSENGERS;";
    executeStatement(connection, sql);
  }

  private static void executeStatement(Connection connection, String sql) {
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.executeUpdate();
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }
}
