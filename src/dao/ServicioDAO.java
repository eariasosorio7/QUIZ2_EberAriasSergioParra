package dao;

import model.Conexion;
import java.sql.*;
import model.Servicio;

public class ServicioDAO {

    // ================= INSERTAR =================
    public void insertar(Servicio s) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "INSERT INTO SERVICIOS (ID, NOMBRE) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getNombre());

            ps.executeUpdate();
            System.out.println("Servicio insertado");
        } catch (Exception e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    // ================= LISTAR =================
    public void listar() {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "SELECT * FROM SERVICIOS";
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

    // ================= ACTUALIZAR =================
    public void actualizar(Servicio s) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "UPDATE SERVICIOS SET NOMBRE=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, s.getNombre());
            ps.setInt(2, s.getId());

            ps.executeUpdate();
            System.out.println("Servicio actualizado");
        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    // ================= ELIMINAR =================
    public void eliminar(int id) {
        try {
            Connection conn = Conexion.getConnection();
            String sql = "DELETE FROM SERVICIOS WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Servicio eliminado");
        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }
}