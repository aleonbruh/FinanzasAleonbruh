
package vista;

import conexion.Conexion;
import controlador.CtrlRegistrosDiarios;
import controlador.CtrlTransacciones;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
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

public class InterGestionarTransacciones extends javax.swing.JInternalFrame {

    private int id;
    
    public static InterGestionarTransacciones instancia;
    
    public static void actualizarDesdeOtraVentana(){
        if (instancia != null) {
            instancia.CargarTablaTransacciones();
            instancia.cargarCategorias();
        }
    }
    
    public InterGestionarTransacciones() {
        initComponents();
        instancia = this;
        this.setSize(new Dimension(640, 380));
        this.setTitle("Gestionar Transacciones");
        
        this.CargarTablaTransacciones();
        this.cargarCategorias();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransacciones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFuente = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jButtonActualizarDatos = new javax.swing.JButton();
        jComboBoxFiltro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(640, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableTransacciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTransacciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 550, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 570, 180));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Fuente:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 20));

        jLabel2.setText("Tipo: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        jTextFieldFuente.setEditable(false);
        jPanel2.add(jTextFieldFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, -1));

        jTextFieldTipo.setEditable(false);
        jPanel2.add(jTextFieldTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 120, -1));
        jPanel2.add(jTextFieldMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, -1));

        jLabel3.setText("Categoria:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 70, 20));

        jLabel4.setText("Descripcion:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));
        jPanel2.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 330, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 90, -1));

        jButtonActualizarDatos.setText("Actualizar Datos");
        jButtonActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarDatosActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 120, -1));

        jComboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione filtro..." }));
        jComboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFiltroActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 120, -1));

        jLabel5.setText("Monto:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 70, 20));

        jPanel2.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 570, 110));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 640, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarDatosActionPerformed
        
        if (id == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una transaccion para actualizar.");
            return;
        }
        
        String nuevaDescripcion = jTextFieldDescripcion.getText().trim();
        String nuevaCategoeria = jComboBoxCategoria.getSelectedItem().toString();
        double nuevoMonto = 0;
        
        try {
            nuevoMonto = Double.parseDouble(jTextFieldMonto.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El monto debe ser un numero valido: " + e);
        }
        
        Connection con = Conexion.conectar();
        
        //Obtener datos de la transaccion
        try {
            String sql = "SELECT monto, tipo, fuente, registro_id FROM transacciones WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            double montoAnterior = 0;
            String tipo = "";
            String fuente = "";
            int registroID = 0;
            
            if (rs.next()) {
                montoAnterior = rs.getDouble("monto");
                tipo = rs.getString("tipo");
                fuente = rs.getString("fuente");
                registroID = rs.getInt("registro_id");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la transaccion.");
                return;
            }
            
            CtrlTransacciones.ajustarSaldoRegistro(registroID, montoAnterior, nuevoMonto, tipo, fuente);
            
        } catch (SQLException e) {
        }
        
        //Actualizar datos en Registros
        try {
            String sql = "UPDATE transacciones SET monto = ?, descripcion = ?, categoria = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, nuevoMonto);
            pst.setString(2, nuevaDescripcion);
            pst.setString(3, nuevaCategoeria);
            pst.setInt(4, id);
            int resultado = pst.executeUpdate();
            
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Transaccion actualizada exitosamente.");
                this.CargarTablaTransacciones();
                InterGestionarRegistros.actualizarDesdeOtraVentana();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la transaccion.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e);
        }
        
    }//GEN-LAST:event_jButtonActualizarDatosActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
                                       
        Connection con = Conexion.conectar();

        try {
            if (id == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione una transacción para eliminar.");
                return;
            }

            // Obtener datos de la transacción antes de eliminarla
            String sqlSelect = "SELECT monto, tipo, fuente, registro_id FROM transacciones WHERE id = ?";
            PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
            pstSelect.setInt(1, id);
            ResultSet rs = pstSelect.executeQuery();

            double monto = 0;
            String tipo = "";
            String fuente = "";
            int registroID = 0;

            if (rs.next()) {
                monto = rs.getDouble("monto");
                tipo = rs.getString("tipo");
                fuente = rs.getString("fuente");
                registroID = rs.getInt("registro_id");
            } else {
                JOptionPane.showMessageDialog(null, "Error: No se encontró la transacción.");
                return;
            }

            // Ajustar saldo en registros diarios antes de eliminar la transacción
            CtrlTransacciones.ajustarSaldoRegistro(registroID, monto, 0, tipo, fuente);

            // Eliminar la transacción
            String sqlDelete = "DELETE FROM transacciones WHERE id = ?";
            PreparedStatement pstDelete = con.prepareStatement(sqlDelete);
            pstDelete.setInt(1, id);
            int resultado = pstDelete.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Transacción eliminada correctamente.");
                CargarTablaTransacciones();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la transacción.");
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
        this.CargarTablaTransacciones();
        InterGestionarRegistros.actualizarDesdeOtraVentana();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jComboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFiltroActionPerformed

        String seleccion = (String) jComboBoxFiltro.getSelectedItem();
        
        if (seleccion == "Seleccione filtro...") {
            this.CargarTablaTransacciones();
        } else {
            String sql = "SELECT id, registro_id, tipo, fuente, monto, descripcion, categoria FROM transacciones WHERE categoria = '" + seleccion + "' ORDER BY id DESC";

            //Cargar los datos
            Connection con = Conexion.conectar();
            DefaultTableModel model = new DefaultTableModel();
            Statement st;

            try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                jTableTransacciones.setModel(model);

                model.addColumn("ID");
                model.addColumn("Registro ID");
                model.addColumn("Tipo");
                model.addColumn("Fuente");
                model.addColumn("Monto");
                model.addColumn("Descripcion");
                model.addColumn("Categoria");

                while (rs.next()) {
                    Object fila[] = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i+1);
                    }
                    model.addRow(fila);
                }
                con.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro al filtrar la tabla: " + e);
            }
        }
    }//GEN-LAST:event_jComboBoxFiltroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarDatos;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableTransacciones;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldFuente;
    private javax.swing.JTextField jTextFieldMonto;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables

    //Mostrar las transacciones
    private void CargarTablaTransacciones(){
    
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT id, registro_id, tipo, fuente, monto, descripcion, categoria FROM transacciones ORDER BY id DESC";
        Statement st;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            jTableTransacciones.setModel(model);
        
            model.addColumn("ID");
            model.addColumn("Registro ID");
            model.addColumn("Tipo");
            model.addColumn("Fuente");
            model.addColumn("Monto");
            model.addColumn("Descripcion");
            model.addColumn("Categoria");
            
            while (rs.next()) {
                Object fila[] = new Object[7];
                
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                model.addRow(fila);
            }
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla: " + e);
        }
        
        jTableTransacciones.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                int filaPoint = jTableTransacciones.rowAtPoint(e.getPoint());
                
                if (filaPoint > -1) {
                    
                    id = (int) jTableTransacciones.getValueAt(filaPoint, 0);
                    EnviarDatosCategoriasSeleccionadas(id);
                    
                }
            }
        });
        
        jTableTransacciones.addKeyListener(new KeyAdapter() {
            @Override
            public  void keyReleased(java.awt.event.KeyEvent evt){
                
                int filaSeleccionada = jTableTransacciones.getSelectedRow();
                
                if (filaSeleccionada != -1) {
                    
                    id = (int) jTableTransacciones.getValueAt(filaSeleccionada, 0);
                    EnviarDatosCategoriasSeleccionadas(id);
                    
                }
            }
        });
    }
    
    private void EnviarDatosCategoriasSeleccionadas(int id){
        try {
            
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM transacciones WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                jTextFieldFuente.setText(rs.getString("fuente"));
                jTextFieldTipo.setText(rs.getString("tipo"));
                jTextFieldMonto.setText(String.valueOf(rs.getDouble("monto")));
                jTextFieldDescripcion.setText(rs.getString("descripcion"));
                jComboBoxCategoria.setSelectedItem(rs.getString("categoria"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la transaccion");
            }
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar la categoria: " + e);
        }
    }
    
    private void cargarCategorias(){
        
        Connection con = Conexion.conectar();
        
        String sql = "SELECT nombre FROM categorias ORDER BY nombre";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {                
                jComboBoxCategoria.addItem(rs.getString("nombre"));
                jComboBoxFiltro.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar categorias: " + e);
        }
    }

}
