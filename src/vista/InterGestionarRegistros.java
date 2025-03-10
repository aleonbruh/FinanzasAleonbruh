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

public class InterGestionarRegistros extends javax.swing.JInternalFrame {

    private int id;
    
    public static InterGestionarRegistros instancia;
    
    public static void actualizarDesdeOtraVentana(){
        if (instancia != null) {
            instancia.CargarTablaRegistros();
        }
    }

    public InterGestionarRegistros() {
        initComponents();
        instancia = this;
        this.setSize(new Dimension(640, 360));
        this.setTitle("Gestionar Registros");

        this.CargarTablaRegistros();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistros = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSaldoFisico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSaldoDigital = new javax.swing.JTextField();
        jButtonActualizarDatos = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSaldoTotal = new javax.swing.JTextField();
        jButtonActualizarTabla = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRegistros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, 520, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 570, 180));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Saldo Fisico:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 80, 20));
        jPanel2.add(jTextFieldSaldoFisico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 125, -1));

        jLabel3.setText("Saldo Digital:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 20));
        jPanel2.add(jTextFieldSaldoDigital, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 125, -1));

        jButtonActualizarDatos.setText("Actualizar Datos");
        jButtonActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarDatosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 83, -1));

        jLabel4.setText("Saldo Total:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));
        jPanel2.add(jTextFieldSaldoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 125, -1));

        jButtonActualizarTabla.setText("Actualizar Tabla");
        jButtonActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarTablaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 570, 80));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 640, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarTablaActionPerformed

        this.CargarTablaRegistros();

    }//GEN-LAST:event_jButtonActualizarTablaActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        CtrlRegistrosDiarios ctrlRegistrosDiarios = new CtrlRegistrosDiarios();

        if (!jTextFieldSaldoTotal.getText().isEmpty()) {

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estar seguro de eliminar este registro y sus transacciones?");

            if (confirmacion == JOptionPane.YES_OPTION) {

                if (ctrlRegistrosDiarios.eliminarRegistro(id)) {
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro antes de eliminar");
        }

        this.CargarTablaRegistros();
        InterGestionarTransacciones.actualizarDesdeOtraVentana();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarDatosActionPerformed

        if (!jTextFieldSaldoFisico.getText().isEmpty() || !jTextFieldSaldoDigital.getText().isEmpty() ) {
            
            CtrlRegistrosDiarios ctrlRegistrosDiarios = new CtrlRegistrosDiarios();

            try {
                double saldoFisico = Double.parseDouble(jTextFieldSaldoFisico.getText().trim());
                if (ctrlRegistrosDiarios.actualizarSaldo("saldo_fisico", saldoFisico, id)) {
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar saldo físico");
                    jTextFieldSaldoFisico.setText("");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido en Saldo Físico");
            }

            try {
                double saldoDigital = Double.parseDouble(jTextFieldSaldoDigital.getText().trim());
                if (ctrlRegistrosDiarios.actualizarSaldo("saldo_digital", saldoDigital, id)) {
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar saldo digital");
                    jTextFieldSaldoDigital.setText("");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido en Saldo Digital");
            }

            try {
                double saldoTotal = Double.parseDouble(jTextFieldSaldoTotal.getText().trim());
                if (ctrlRegistrosDiarios.actualizarSaldo("saldo_total", saldoTotal, id)) {
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar saldo total");
                    jTextFieldSaldoFisico.setText("");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido en Saldo Total");
            }

            JOptionPane.showMessageDialog(null, "Saldos actualizados");

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }

        this.CargarTablaRegistros();
    }//GEN-LAST:event_jButtonActualizarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarDatos;
    private javax.swing.JButton jButtonActualizarTabla;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableRegistros;
    private javax.swing.JTextField jTextFieldSaldoDigital;
    private javax.swing.JTextField jTextFieldSaldoFisico;
    private javax.swing.JTextField jTextFieldSaldoTotal;
    // End of variables declaration//GEN-END:variables

    //Metodo para mostrar los registros
    private void CargarTablaRegistros() {

        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT id, fecha, saldo_fisico, saldo_digital, saldo_total FROM registrosdiarios ORDER BY id DESC";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarRegistros.jTableRegistros = new JTable(model);
            InterGestionarRegistros.jScrollPane1.setViewportView(InterGestionarRegistros.jTableRegistros);

            model.addColumn("ID");
            model.addColumn("Fecha");
            model.addColumn("Saldo Fisico");
            model.addColumn("Saldo Digital");
            model.addColumn("Saldo Total");

            while (rs.next()) {
                Object fila[] = new Object[5];

                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("fecha");
                fila[2] = String.format("%.2f", rs.getDouble("saldo_fisico"));
                fila[3] = String.format("%.2f", rs.getDouble("saldo_digital"));
                fila[4] = String.format("%.2f", rs.getDouble("saldo_total"));
                
                model.addRow(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla: " + e);
        }

        jTableRegistros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaPoint = jTableRegistros.rowAtPoint(e.getPoint());
                int columnaPoint = 0;

                if (filaPoint > -1) {
                    id = (int) model.getValueAt(filaPoint, columnaPoint);
                    EnviarDatosCategoriasSeleccionadas(id);
                }
            }
        });

    }

    private void EnviarDatosCategoriasSeleccionadas(int id) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select * from registrosdiarios where id = '" + id + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                jTextFieldSaldoFisico.setText(String.format("%.2f", rs.getDouble("saldo_fisico")));
                jTextFieldSaldoDigital.setText(String.format("%.2f", rs.getDouble("saldo_digital")));
                jTextFieldSaldoTotal.setText(String.format("%.2f", rs.getDouble("saldo_total")));
                
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la categoria: " + e);
        }

    }

}
