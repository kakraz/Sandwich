package com.example.sandwich.workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;

//import com.example.sandwich.model.Composition;

import java.sql.Connection;

public class CompositionWorker {
    public void createComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "INSERT INTO Composition (Sandwiches_id, Ingredients_comp_id) VALUES (?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public void deleteComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "DELETE FROM Composition WHERE Sandwiches_id = ? and Ingredients_comp_id  = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public void updateComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id, Integer ing_numb) throws SQLException {
        String sql = "UPDATE Composition SET ing_numb = ? WHERE Sandwiches_id = ? and Ingredients_comp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, ing_numb);
        pstm.setInt(2, Sandwiches_id);
        pstm.setInt(3, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public Integer getNumbForSandwich(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "select * from  Composition where Sandwiches_id = ? and Ingredients_comp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        ResultSet rs = pstm.executeQuery();
        return rs.getInt("ing_numb");
    }
}