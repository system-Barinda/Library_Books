package dao;

import model.Fan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FanDAO {

    public void insertFan(Fan fan) throws Exception {
        String sql = "INSERT INTO fans(name, team, p1, p2, p3) VALUES (?,?,?,?,?)";
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, fan.getName());
        ps.setString(2, fan.getTeam());
        ps.setInt(3, fan.getPlayerOneGoals());
        ps.setInt(4, fan.getPlayerTwoGoals());
        ps.setInt(5, fan.getPlayerThreeGoals());

        ps.executeUpdate();
        con.close();
    }

    public List<Fan> getAllFans() throws Exception {
        List<Fan> fans = new ArrayList<>();
        String sql = "SELECT * FROM fans";
        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Fan fan = new Fan(
                rs.getString("name"),
                rs.getString("team"),
                rs.getInt("p1"),
                rs.getInt("p2"),
                rs.getInt("p3")
            );
            fans.add(fan);
        }
        con.close();
        return fans;
    }
}
