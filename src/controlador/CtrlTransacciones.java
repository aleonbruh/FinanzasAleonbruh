
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CtrlTransacciones {
    
    public static boolean registrarTransaccion(String tipo, String fuente, double monto, String descripcion, String categoria){
        
        Connection con = Conexion.conectar();
        PreparedStatement ps;
        ResultSet rs;
        int registroId = 0;
        
        try {
            //Obtener datos del dia actual
            String sqlRegistroActual = "SELECT id, saldo_fisico, saldo_digital FROM registrosdiarios WHERE fecha = CURDATE()";
            ps = con.prepareStatement(sqlRegistroActual);
            rs = ps.executeQuery();
            
            double saldoFisico = 0, saldoDigital = 0;
            
            if (rs.next()) {
                registroId = rs.getInt("id");
                saldoFisico = rs.getDouble("saldo_fisico");
                saldoDigital = rs.getDouble("saldo_digital");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun registro para el dia actual, creando un nuevo registro para el dia actual");
                CtrlRegistrosDiarios ctrlRegistrosDiarios = new CtrlRegistrosDiarios();
                ctrlRegistrosDiarios.crearNuevoRegistro();
            }
            
            //Obtener id de la ultima transaccion
            String sqlUltimaTransaccion = "SELECT id FROM transacciones ORDER BY id DESC LIMIT 1";
            ps = con.prepareStatement(sqlUltimaTransaccion);
            rs = ps.executeQuery();
            
            int nuevoId = 1;
            
            if (rs.next()) {
                int transaccionId = rs.getInt("id");
                nuevoId = transaccionId + 1;
            }
            
            //Insertar la transaccion en tabla transacciones
            String sqlInsertar = "INSERT INTO transacciones (id, registro_id, tipo, fuente, monto, descripcion, categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sqlInsertar);
            ps.setInt(1, nuevoId);
            ps.setInt(2, registroId);
            ps.setString(3, tipo);
            ps.setString(4, fuente);
            ps.setDouble(5, monto);
            ps.setString(6, descripcion);
            ps.setString(7, categoria);
            
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                
                //Calcular los saldos
                if (tipo.equalsIgnoreCase("Ingreso")) {
                    if (fuente.equalsIgnoreCase("Fisico")) {
                        saldoFisico += monto;
                    } else if (fuente.equalsIgnoreCase("Digital")) {
                        saldoDigital += monto;
                    }  
                } else if (tipo.equalsIgnoreCase("Salida")) {
                    if (fuente.equalsIgnoreCase("Fisico")) {
                        saldoFisico -= monto;
                    } else if (fuente.equalsIgnoreCase("Digital")) {
                        saldoDigital -= monto;
                    }
                }
            }
            
            double saldoTotal = saldoFisico + saldoDigital;
            
            //Actualizar los saldos
            String sqlActualizar = "UPDATE registrosdiarios SET saldo_fisico = ?, saldo_digital = ?, saldo_total = ? WHERE id = ?";
            ps = con.prepareStatement(sqlActualizar);
            ps.setDouble(1, saldoFisico);
            ps.setDouble(2, saldoDigital);
            ps.setDouble(3, saldoTotal);
            ps.setInt(4, registroId);
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la transaccion: " + e.getMessage());
        }
        return false;
    }
    
    public static void ajustarSaldoRegistro (int registroID, double montoAnterior, double montoNuevo, String tipo, String fuente){
        
        Connection con = Conexion.conectar();
        
        try {
            double ajusteSaldo = montoNuevo - montoAnterior;
        
            String sql = "UPDATE registrosdiarios SET " + 
                    (fuente.equalsIgnoreCase("Fisico") ? "saldo_fisico = saldo_fisico + ?" : "saldo_digital = saldo_digital + ?") + 
                    ", saldo_total = saldo_fisico + saldo_digital WHERE id = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, tipo.equalsIgnoreCase("Ingreso") ? ajusteSaldo : -ajusteSaldo);
            pst.setInt(2, registroID);
            pst.executeUpdate();
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el saldo en registros: " + e);
        }
    }
}
