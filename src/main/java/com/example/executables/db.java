package com.example.executables;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class db{

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javadb";
    private static final String USER = "root";
    private static final String PASSWORD = "Rishab@1110";

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void AddData(String username, String email, String password, String confirm_pass, String gender) throws SQLException {
        String query = "INSERT INTO users (username,email,password,confirm_pass,gender) VALUES (?, ?,?,?,?)";

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, confirm_pass);
            preparedStatement.setString(5, String.valueOf(gender));

            preparedStatement.executeUpdate();
        }
    }
    boolean CheckCredentials(String username, String password){
        try (Connection connection = db.getConnection()) {
            String query = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        // Compare storedPassword with enteredPassword
                        return storedPassword.equals(password);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int GetUserId(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.getConnection();
            String query = "SELECT userid FROM users WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("userid");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return -1; //no match for argument username
    }

    public void UserLog(){

    }
}
