package vista;

import controlador.CtrlRegistrosDiarios;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import javax.swing.JDesktopPane;

public class FrmMenu extends javax.swing.JFrame {

    public static JDesktopPane JDesktopPaneMenu;

    public FrmMenu() {
        initComponents();
        this.setSize(new Dimension(854, 480));
        this.setResizable(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema de Finanzas");
        this.setLayout(null);

        JDesktopPaneMenu = new JDesktopPane();

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        FrmMenu.JDesktopPaneMenu.setBounds(0, 0, ancho, (alto - 90));
        this.add(JDesktopPaneMenu);
        
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt){
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_F1) {
                      
                    InterGestionarRegistros interGestionarRegistros = new InterGestionarRegistros();
                    JDesktopPaneMenu.add(interGestionarRegistros);
                    interGestionarRegistros.setVisible(true);  
                    interGestionarRegistros.setLocation(10, 10);
                    
                    InterRegistrarTransaccion interRegistrarTransaccion = new InterRegistrarTransaccion();
                    JDesktopPaneMenu.add(interRegistrarTransaccion);
                    interRegistrarTransaccion.setVisible(true);
                    interRegistrarTransaccion.setLocation(665, 10);
                    
                    InterGestionarTransacciones interGestionarTransacciones = new InterGestionarTransacciones();
                    JDesktopPaneMenu.add(interGestionarTransacciones);
                    interGestionarTransacciones.setVisible(true);
                    interGestionarTransacciones.setLocation(665, 290);

                }
            } 
        });
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/icon.jpg"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuRegistrosDiarios = new javax.swing.JMenu();
        jMenuItemNuevoRegistro = new javax.swing.JMenuItem();
        jMenuItemGestionarRegistros = new javax.swing.JMenuItem();
        jMenuTransacciones = new javax.swing.JMenu();
        jMenuItemRegistrarTransaccion = new javax.swing.JMenuItem();
        jMenuItemGestionarTransacciones = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemGestionarCategorias = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuRegistrosDiarios.setText("Registros Diarios");

        jMenuItemNuevoRegistro.setText("Nuevo Registro");
        jMenuItemNuevoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoRegistroActionPerformed(evt);
            }
        });
        jMenuRegistrosDiarios.add(jMenuItemNuevoRegistro);

        jMenuItemGestionarRegistros.setText("Gestionar Registros");
        jMenuItemGestionarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionarRegistrosActionPerformed(evt);
            }
        });
        jMenuRegistrosDiarios.add(jMenuItemGestionarRegistros);

        jMenuBar1.add(jMenuRegistrosDiarios);

        jMenuTransacciones.setText("Transacciones");

        jMenuItemRegistrarTransaccion.setText("Registrar Transaccion");
        jMenuItemRegistrarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarTransaccionActionPerformed(evt);
            }
        });
        jMenuTransacciones.add(jMenuItemRegistrarTransaccion);

        jMenuItemGestionarTransacciones.setText("Gestionar Transacciones");
        jMenuItemGestionarTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionarTransaccionesActionPerformed(evt);
            }
        });
        jMenuTransacciones.add(jMenuItemGestionarTransacciones);

        jMenuBar1.add(jMenuTransacciones);

        jMenu1.setText("Categorias");

        jMenuItemGestionarCategorias.setText("Gestionar Categorias");
        jMenuItemGestionarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionarCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGestionarCategorias);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGestionarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionarRegistrosActionPerformed

        InterGestionarRegistros interGestionarRegistros = new InterGestionarRegistros();
        JDesktopPaneMenu.add(interGestionarRegistros);
        interGestionarRegistros.setVisible(true);

    }//GEN-LAST:event_jMenuItemGestionarRegistrosActionPerformed

    private void jMenuItemRegistrarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarTransaccionActionPerformed
        
        InterRegistrarTransaccion interRegistrarTransaccion = new InterRegistrarTransaccion();
        JDesktopPaneMenu.add(interRegistrarTransaccion);
        interRegistrarTransaccion.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistrarTransaccionActionPerformed

    private void jMenuItemGestionarTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionarTransaccionesActionPerformed
        
        InterGestionarTransacciones interGestionarTransacciones = new InterGestionarTransacciones();
        JDesktopPaneMenu.add(interGestionarTransacciones);
        interGestionarTransacciones.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemGestionarTransaccionesActionPerformed

    private void jMenuItemNuevoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoRegistroActionPerformed
        
        CtrlRegistrosDiarios ctrlRegistrosDiarios = new CtrlRegistrosDiarios();
        ctrlRegistrosDiarios.crearNuevoRegistro();
        
        InterGestionarRegistros.actualizarDesdeOtraVentana();
        
    }//GEN-LAST:event_jMenuItemNuevoRegistroActionPerformed

    private void jMenuItemGestionarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionarCategoriasActionPerformed
        
        InterGestionarCategorias interGestionarCategorias = new InterGestionarCategorias();
        JDesktopPaneMenu.add(interGestionarCategorias);
        interGestionarCategorias.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemGestionarCategoriasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemGestionarCategorias;
    private javax.swing.JMenuItem jMenuItemGestionarRegistros;
    private javax.swing.JMenuItem jMenuItemGestionarTransacciones;
    private javax.swing.JMenuItem jMenuItemNuevoRegistro;
    private javax.swing.JMenuItem jMenuItemRegistrarTransaccion;
    private javax.swing.JMenu jMenuRegistrosDiarios;
    private javax.swing.JMenu jMenuTransacciones;
    // End of variables declaration//GEN-END:variables
}
