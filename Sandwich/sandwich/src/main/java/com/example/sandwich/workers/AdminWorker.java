package com.example.sandwich.workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.sandwich.model.Admin;

import java.sql.Connection;

public class AdminWorker {
    public void createAdmin(Connection connection, Integer adm_id, String login, String password) throws SQLException {
        String sql = "INSERT INTO Admin (id, login, password) VALUES (?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, adm_id);
        pstm.setString(2, login);
        pstm.setString(3, password);
        pstm.executeUpdate();
    }

    public void updateAdmin(Connection connection, Integer adm_id, String login, String password) throws SQLException {
        String sql = "UPDATE Admin SET login = ?, password = ? WHERE adm_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, password);
        pstm.setInt(3, adm_id);
        pstm.executeUpdate();
    }

    public void deleteAdmin(Connection connection, Integer adm_id) throws SQLException {
        String sql = "DELETE FROM Admin WHERE adm_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, adm_id);
        pstm.executeUpdate();
    }

    public List <Admin> getAllAdmins(Connection connection) throws SQLException {
        List<Admin> ll = new LinkedList<Admin>();
        String sql = "SELECT * FROM Admin";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Admin Admin = new Admin(rs.getInt("adm_id"), rs.getString("login"), rs.getString("password"));
            ll.add(Admin);
        }
        return ll;
    }

}