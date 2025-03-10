
package controlador;

import com.sun.source.tree.DefaultCaseLabelTree;
import modelo.RegistrosDiarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class CtrlRegistrosDiarios {
    
    public boolean actualizarSaldo(String tipoSaldo, double saldo, int id) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();

        try {
            String query = "UPDATE registrosdiarios SET " + tipoSaldo + " = ? WHERE id = ?";
            PreparedStatement consulta = cn.prepareStatement(query);
            consulta.setDouble(1, saldo);
            consulta.setInt(2, id);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el saldo: " + e);
        }

        return respuesta;
    }
    
    public boolean eliminarRegistro(int id){
        Connection cn = conexion.Conexion.conectar();
        
        try {
            //Eliminar transacciones relacionadas al registro
            String sqlEliminarTransacciones = "DELETE FROM transacciones WHERE registro_id = ?";
            PreparedStatement pstRegistros = cn.prepareStatement(sqlEliminarTransacciones);
            pstRegistros.setInt(1, id);
            pstRegistros.executeUpdate();
            
            //Eliminar el registro
            String sql = "DELETE FROM registrosdiarios WHERE id = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            int resultado = pst.executeUpdate();
            
            cn.close();
            return resultado > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro y sus relaciones: " + e);
            return false;
        }
    }
    
    public void crearNuevoRegistro(){
        
        Connection con = conexion.Conexion.conectar();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            
            //Obtener datos de ultimo registro
            String sqlUltimoRegistro = "SELECT id, fecha, saldo_fisico, saldo_digital, saldo_total FROM registrosdiarios ORDER BY fecha DESC LIMIT 1";
            ps = con.prepareStatement(sqlUltimoRegistro);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                Date ultimaFecha = rs.getDate("fecha");
                int id = rs.getInt("id");
                double saldoFisico = rs.getDouble("saldo_fisico");
                double saldoDigital = rs.getDouble("saldo_digital");
                double saldoTotal = rs.getDouble("saldo_total");
                
                //Obtener nueva fecha (dia siguiente)
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(ultimaFecha);
                calendario.add(Calendar.DAY_OF_YEAR, 1);
                java.sql.Date nuevaFecha = new java.sql.Date(calendario.getTimeInMillis());
                
                int nuevoId = id + 1;
                
                //Crear el nuevo registro con la nueva fecha y los ultimos saldos
                String sqlNuevoRegistro = "INSERT INTO registrosdiarios (id, fecha, saldo_fisico, saldo_digital, saldo_total) VALUES (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sqlNuevoRegistro);
                ps.setInt(1, nuevoId);
                ps.setDate(2, nuevaFecha);
                ps.setDouble(3, saldoFisico);
                ps.setDouble(4, saldoDigital);
                ps.setDouble(5, saldoTotal);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Nuevo registro creado con fecha: " + nuevaFecha);
                
            }  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear nuevo registro: " + e);
        }
    }
}
