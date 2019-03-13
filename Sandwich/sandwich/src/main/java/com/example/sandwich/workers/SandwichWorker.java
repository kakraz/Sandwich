package com.example.sandwich.worker;


public class SandwichWorker{
    public void createSandwich(Connection connection, Integer id, String name, String type, Integer minutes, String bread, String comment){
        String sql = "INSERT INTO Sandwiches (id, name, type, minutes, bread, comment) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id)
        pstm.setString(2, name);
        pstm.setString(3, type);
        pstm.setInt(4, minutes);
        pstm.setString(5, bread);
        pstm.setString(6, comment);
        pstm.Update();
    }

    public void updateSandwich(Connection connection, Integer id, String name, String type, Integer minutes, String bread, String comment){
        String sql = "UPDATE Sandwiches SET name = ?, type = ?, minutes = ?, bread = ?, comment = ? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id)
        pstm.setString(2, name);
        pstm.setString(3, type);
        pstm.setInt(4, minutes);
        pstm.setString(5, bread);
        pstm.setString(6, comment);
        pstm.Update();
    }

    public void deleteSandwich(Connection connection, Integer id){
        String sql = "DELETE FROM Sandwiches WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id)
        pstm.Update();
    }

    public List getAllSandwiches(Connection connection){
        List ll = new LinkedList();
        String SQL = "SELECT * FROM Sandwiches";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
            ll.add(sandwich);
        }
        return ll;
    }

    public Sandwiches getSandwichById(Connection connection, Integer id){
        String sql = "SELECT * FROM Sandwiches WHERE id = ?"
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
        return sandwich;
    }

    public Sandwiches getSandwichByType(Connection connection, String type){
        String sql = "SELECT * FROM Sandwiches WHERE type = ?"
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, type);
        ResultSet rs = preparedStatement.executeQuery();
        Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
        return sandwich;
    }

    public Sandwiches getSandwichByIdAndType(Connection connection, Integer id, String type){
        String sql = "SELECT * FROM Sandwiches WHERE id = ? AND type = ?"
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, type);
        ResultSet rs = preparedStatement.executeQuery();
        Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
        return sandwich;
    }

    public List getSandwichByIngredient(Connection connection, Integer comp_id){
        List ll = new LinkedList();
        String sql = "select Sandwiches.* from Sandwiches where id IN (Select Sandwiches_id from Composition where Ingredients_comp_id = ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, comp_id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
            ll.add(sandwich);
        }
        return ll;
    }
}