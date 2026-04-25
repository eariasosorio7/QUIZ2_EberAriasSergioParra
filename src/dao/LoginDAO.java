package dao;

import model.Conexion;
import java.sql.*;
import model.Cliente;

public class LoginDAO {

    public boolean login(String nombre, int id) {

        try {
            Connection conn = Conexion.getConnection();

            String sql = "SELECT * FROM CLIENTE WHERE NOMBRE = ? AND ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, id);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // si hay datos = login correcto

        } catch (Exception e) {
            System.out.println("Error login: " + e.getMessage());
        }

        return false;
    }
}