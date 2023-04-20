package org.example;

import java.sql.*;

public class DCommands {
    static final private String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final private String USER_NAME = "postgres";
    static final private String PASSWORD = "asanov2005";

    public static void connectionAndExecutingCommand(String SQL_Query){
        Connection connection;
        Statement statement;
        try{
            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            statement = connection.createStatement();
            if(connection != null) {
                if (SQL_Query.contains("INSERT INTO") || SQL_Query.contains("UPDATE") || SQL_Query.contains("DELETE")) {
                    statement.executeUpdate(SQL_Query);
                    System.out.println("Successfully executed!");
                }else{
                    ResultSet resultSet = statement.executeQuery(SQL_Query);
                    while (resultSet.next()){
                        System.out.print(resultSet.getString("id") + " ");
                        System.out.print(resultSet.getString("login")  + " ");
                        System.out.print(resultSet.getString("password") + "\n");
                    }
                }
            }
        }catch (SQLException e){
            System.out.println("ERROR!!!");
            throw new RuntimeException(e);
        }
    }
  public static void addRecord(String login, String password){
      String SQL_Query = "INSERT INTO mytable (login,password) VALUES('"+login+"','"+password+"')";
      connectionAndExecutingCommand(SQL_Query);
  }
  public static void deleteRecord(String login, String password){
      String SQL_Query = "DELETE FROM mytable WHERE login = '"+login+"' AND password = '"+password+"'";
      connectionAndExecutingCommand(SQL_Query);
  }
  public static void updateRecord(String login, String password, int id){
      String SQL_Query = "UPDATE mytable SET login = '"+login+"', password = '"+password+"' WHERE id = "+id+"";
      connectionAndExecutingCommand(SQL_Query);
  }
  public static void infoRecords(){
        String SQL_Query = "SELECT* FROM mytable";
        connectionAndExecutingCommand(SQL_Query);
  }
}
