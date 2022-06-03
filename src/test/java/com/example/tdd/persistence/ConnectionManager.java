package com.example.tdd.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static Connection connection;

  public static Connection getConnection() {
    return connection;
  }

  public static Connection openConnection() {
    try {
      if (connection == null || connection.isClosed()) {
        try {
          Class.forName("org.h2.Driver");
          connection = DriverManager.getConnection("jdbc:h2:~/passenger", "sa", "");
          return connection;
        } catch (SQLException | ClassNotFoundException ex) {
          throw new RuntimeException(ex);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
