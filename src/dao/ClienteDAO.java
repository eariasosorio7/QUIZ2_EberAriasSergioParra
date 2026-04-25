package dao;

import model.Conexion;
import java.sql.*;
import model.Cliente;

public class ClienteDAO {

    // INSERT
    public void insertar(Cliente c) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "INSERT INTO CLIENTE (ID, NOMBRE) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getNombre());
            ps.executeUpdate();
            System.out.println("Cliente insertado");
        } catch (Exception e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    // LISTAR
    public void listar() {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "SELECT * FROM CLIENTE";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + " - " +
                    rs.getString("NOMBRE")
                );
            }
        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(Cliente c) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "UPDATE CLIENTE SET NOMBRE=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getId());
            ps.executeUpdate();
            System.out.println("Cliente actualizado");
        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "DELETE FROM CLIENTE WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cliente eliminado");
        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }
}