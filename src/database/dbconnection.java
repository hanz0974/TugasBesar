/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author MyPC One Pro K
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class dbconnection {
    Connection conn;
    public dbconnection(){ 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
            
        } catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Connection getConnection (){
        return conn;
    }
    public boolean validateLogin(String username, String password) {
        boolean isValid = false;
        
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","");
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                isValid = true; // Username dan password ditemukan
            }
        } catch (SQLException e) {
            System.out.println("Error saat validasi login: " + e.getMessage());
        }
        
        return isValid;
    }
    public boolean searchUser(String username) {
        String query = "SELECT * FROM login WHERE username = ?";
        StringBuilder resultMessage = new StringBuilder();
        boolean ada = false;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/market", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ada = true;
            }
        } catch (SQLException e) {
            resultMessage.append("Error saat koneksi ke database: ").append(e.getMessage());
        }
        
        return ada;    
    }
    public void insertData(String name, String userName, String password){
        
        // Koneksi dan penyisipan data
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/market","root","")) {
            String sql = "INSERT INTO login (name, username, password) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, userName);
                pstmt.setString(3, password);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Akun berhasil dibuat!\nSilahkan masuk!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    // Main method dan lainnya ...
}