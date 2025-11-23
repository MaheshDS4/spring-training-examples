package com.example.jdbc;

import java.sql.*;

public class JdbcH2Demo {

    public static void main(String[] args) {

        String url = "jdbc:h2:~/testdb";  // file-based DB (creates testdb.mv.db)
        String user = "sa";
        String pass = "";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            System.out.println("Connected to H2 database!");

            // 1. CREATE TABLE
            String createTableSql = """
                    CREATE TABLE IF NOT EXISTS student (
                        id INT PRIMARY KEY,
                        name VARCHAR(50),
                        email VARCHAR(50)
                    )
                    """;
            conn.createStatement().execute(createTableSql);
            System.out.println("Table created.");

            // 2. INSERT
            String insertSql = "INSERT INTO student (id, name, email) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setInt(1, 1);
                ps.setString(2, "Mahesh");
                ps.setString(3, "mahesh@example.com");
                ps.executeUpdate();
                System.out.println("Inserted record.");
            }

            // 3. READ (SELECT)
            String selectSql = "SELECT * FROM student";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSql)) {

                System.out.println("\n--- Student Table Data ---");
                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("email")
                    );
                }
            }

            // 4. UPDATE
            String updateSql = "UPDATE student SET email = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setString(1, "mahesh_updated@example.com");
                ps.setInt(2, 1);
                ps.executeUpdate();
                System.out.println("\nRecord updated.");
            }

            // 5. DELETE
            String deleteSql = "DELETE FROM student WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, 1);
                ps.executeUpdate();
                System.out.println("Record deleted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
