package com.maven.Maven_Cart_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mysql_connection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/cart";
        String username = "root";
        String password = "bangbang@1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            while (true) {
                System.out.println("1: for adding sfa team details");
                System.out.println("2: for adding distributors team details");

                Scanner scanner = new Scanner(System.in);

                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("employee name");
                        String name = scanner.next();
                        System.out.println("employee age");
                        int age = scanner.nextInt();
                        System.out.println("employee experience");
                        String experience = scanner.next();
                        System.out.println("employee salary");
                        double salary = scanner.nextDouble();
                        Cart data = new Cart(name, age, experience, salary);
                        insertCartTeamData(connection, data);
                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.println("distributors details");
                        System.out.println("employee name");
                        String name1 = scanner.next();
                        System.out.println("employee age");
                        int age1 = scanner.nextInt();
                        System.out.println("employee experience");
                        String experience1 = scanner.next();
                        System.out.println("employee salary");
                        double salary1 = scanner.nextDouble();
                        Cart data1 = new Cart(name1, age1, experience1, salary1);
                        insertCartTeamData(connection, data1);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCartTeamData(Connection connection, Cart data) throws SQLException {
        String sql = "INSERT INTO cart_team (name, age, experience, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, data.getName());
            preparedStatement.setInt(2, data.getAge());
            preparedStatement.setString(3, data.getExperience());
            preparedStatement.setDouble(4, data.getSalary());
            preparedStatement.executeUpdate();
        }
        System.out.println("DATA ADDED SUCCESSFULLY");
    }

    public static void retrieveCartTeamData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM cart_team";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String experience = resultSet.getString("experience");
                double salary = resultSet.getDouble("salary");
                System.out.println("Name: " + name + ", Age: " + age + ", Experience: " + experience + ", Salary: " + salary);
            }
        }
    }
}
