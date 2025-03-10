
package vista;

import conexion.Conexion;
import controlador.CtrlRegistrosDiarios;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterGestionarCategorias extends javax.swing.JInternalFrame {

    public InterGestionarCategorias() {
        initComponents();
        this.setSize(new Dimension(640, 360));
        this.setTitle("Gestionar Categorias");
        this.CargarTablaCategorias();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCategoria = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(542, 157));
        jPanel1.setPreferredSize(new java.awt.Dimension(542, 157));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCategorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 510, 190));

        jLabel2.setText("Nombre de la Categoria: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 20));
        jPanel1.add(jTextFieldCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 150, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 90, -1));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 570, 270));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 640, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        String nombre = jTextFieldCategoria.getText().trim();
        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para la categoria.");
            return;
        }
        
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
       
        try (Connection con = Conexion.conectar(); PreparedStatement pst = con.prepareStatement(sql)){
            pst.setString(1, nombre);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria agregada exitosamente.");
            CargarTablaCategorias();
            InterGestionarTransacciones.actualizarDesdeOtraVentana();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la categoria: " + e);
        }  
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        
        int fila = jTableCategorias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione la categoria a eliminar.");
        }
        
        
        String nombreCategoria = jTableCategorias.getValueAt(fila, 1).toString();
        
        Connection con = Conexion.conectar();
        
        try {
            
            String sqlVerificar = "SELECT COUNT(*) FROM transacciones WHERE categoria = ?";
            PreparedStatement pstVerificar = con.prepareCall(sqlVerificar);
            pstVerificar.setString(1, nombreCategoria);
            ResultSet rs = pstVerificar.executeQuery();
            rs.next();
            
            int count = rs.getInt(1);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar la categoria ya que esta en " + count + " transaccion(es)");
                return;
            }
            
            String sqlEliminar = "DELETE FROM categorias WHERE nombre = ?";
            PreparedStatement pstEliminar = con.prepareStatement(sqlEliminar);
            pstEliminar.setString(1, nombreCategoria);
            int resultado = pstEliminar.executeUpdate();
            
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Categoria eliminada exitosamente.");
                CargarTablaCategorias();
                InterGestionarTransacciones.actualizarDesdeOtraVentana();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la categoria.");
            }
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableCategorias;
    private javax.swing.JTextField jTextFieldCategoria;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaCategorias(){
        
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT * FROM categorias ORDER BY nombre";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            jTableCategorias.setModel(model);

            model.addColumn("ID");
            model.addColumn("Nombre");

            while (rs.next()) {
                Object fila[] = new Object[2];

                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla: " + e);
        }
        
    }

}
