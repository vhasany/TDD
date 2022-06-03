package com.example.tdd.repository.impl;

import com.example.tdd.Passenger;
import com.example.tdd.repository.PassengerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public record PassengerDaoImpl(Connection connection) implements PassengerDao {
  @Override
  public void insert(Passenger passenger) {
      String sql="INSERT INTO PASSENGERS (ID,NAME) VALUES (?,?)";
      try(PreparedStatement statement=connection.prepareStatement(sql)){
        statement.setString(1,passenger.getId());
        statement.setString(2,passenger.getName());
        statement.executeUpdate();
      } catch (SQLException ex) {
        throw  new RuntimeException(ex);
      }

  }

  @Override
  public void update(String id, String name) {
    String sql="UPDATE PASSENGERS SET NAME = ? WHERE ID = ?";
    try(PreparedStatement statement=connection.prepareStatement(sql)){
      statement.setString(1,name);
      statement.setString(2,id);
      statement.executeUpdate();
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void delete(Passenger passenger) {
    String sql="DELETE FROM PASSENGERS WHERE ID = ?";
    try(PreparedStatement statement=connection.prepareStatement(sql)){
      statement.setString(1,passenger.getId());
      statement.executeUpdate();
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public Passenger getById(String id) {
    String sql="SELECT * FROM PASSENGERS WHERE ID = ?";
    Passenger passenger=null;
    try(PreparedStatement statement=connection.prepareStatement(sql)){
      statement.setString(1,id);
      ResultSet resultSet=statement.executeQuery();
      if (resultSet.next()){
        passenger=new Passenger(resultSet.getString(1),resultSet.getString(2));
      }
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return passenger;
  }
}
