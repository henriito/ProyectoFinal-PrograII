/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import datos.ActoresDao;
import datos.ActoresDaoJDBC;
import datos.Conexion;
import domain.ActoresDTO;
import java.awt.Image;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10
 */
public class VentanaActores extends javax.swing.JFrame {

    /**
     * Creates new form VentanaActores
     */
    public VentanaActores() {
        initComponents();
        setLocationRelativeTo(null);setLocationRelativeTo(null);SetImageLabel(jLabel6,"C:\\Users\\Windows 10\\Desktop\\ejemploPatronSqlServer\\src\\main\\java\\Imagenes\\actores.png");
    }
    private void SetImageLabel(JLabel labelName, String root){
            ImageIcon image = new ImageIcon(root);
            Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_DEFAULT));
            labelName.setIcon(icon);
            this.repaint();
        }    public void eliminar() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }

            ActoresDTO usr = new ActoresDTO();
            usr.setId_actor(Integer.parseInt(txtId_actor.getText()));

            ActoresDao ActorDao = new ActoresDaoJDBC(conexion);
            ActorDao.delete(usr);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
                System.out.println(ex1.getMessage());
            }
        }
        JOptionPane.showMessageDialog(this, "Se elimino correctamente el actor");
        System.out.println("Fin del programa");
    }

    public void actualizar() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }

            ActoresDTO cambioPersona = new ActoresDTO();
            cambioPersona.setId_actor(Integer.parseInt(txtId_actor.getText()));
            cambioPersona.setNombre("" + txtNombreActor.getText());
            cambioPersona.setApellido("" + txtApellidoActor.getText());
            cambioPersona.setEdad(Integer.parseInt(txtEdadActor.getText()));

            ActoresDaoJDBC personaJdbc = new ActoresDaoJDBC(conexion);
            personaJdbc.update(cambioPersona);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public void guardar() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }

            ActoresDaoJDBC personaJdbc = new ActoresDaoJDBC(conexion);

            ActoresDTO nuevaPersona = new ActoresDTO();
            nuevaPersona.setNombre("" + txtNombreActor.getText());
            nuevaPersona.setApellido("" + txtApellidoActor.getText());
            nuevaPersona.setEdad(Integer.parseInt(txtEdadActor.getText()));
            personaJdbc.insert(nuevaPersona);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
       JOptionPane.showMessageDialog(this, "Se guardo correctamente el actor");
    }
    public void mostrar(){
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Actor");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Edad");
            visor.setModel(model);
       model.setRowCount(0);
       
       PreparedStatement ps;
       ResultSet rs;
       ResultSetMetaData rsmd;
       int columnas;
       
       
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        ps = conexion.prepareStatement("SELECT id_actor, nombre, apellido, edad FROM actor");
        
        rs = ps.executeQuery();
        rsmd = rs.getMetaData();
        columnas = rsmd.getColumnCount();
        
        while(rs.next()){
            Object [] fila = new Object[columnas];
            for(int ind=0; ind<columnas; ind++){
                fila[ind] = rs.getObject(ind +1);   
            }
            model.addRow(fila);
        }
        
        } catch (SQLException ex1) {
             ex1.printStackTrace(System.out);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId_actor = new javax.swing.JTextField();
        txtNombreActor = new javax.swing.JTextField();
        txtApellidoActor = new javax.swing.JTextField();
        txtEdadActor = new javax.swing.JTextField();
        btnGuardarAct = new javax.swing.JButton();
        btnActuActor = new javax.swing.JButton();
        btnEliminarActor = new javax.swing.JButton();
        btnCancelarActor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Actores");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Id del actor");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre del actor");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Apellido del actor");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Edad del actor");

        txtNombreActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActorActionPerformed(evt);
            }
        });

        btnGuardarAct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarAct.setText("Guardar");
        btnGuardarAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActActionPerformed(evt);
            }
        });

        btnActuActor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActuActor.setText("Actualizar");
        btnActuActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuActorActionPerformed(evt);
            }
        });

        btnEliminarActor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarActor.setText("Eliminar");
        btnEliminarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActorActionPerformed(evt);
            }
        });

        btnCancelarActor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelarActor.setText("Cancelar");
        btnCancelarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActorActionPerformed(evt);
            }
        });

        visor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(visor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );

        btnMostrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardarAct)
                                .addGap(18, 18, 18)
                                .addComponent(btnActuActor)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarActor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarActor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMostrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtEdadActor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(108, 108, 108))
                                                .addComponent(txtApellidoActor, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtId_actor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNombreActor))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(249, 249, 249)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId_actor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreActor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoActor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEdadActor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarAct)
                    .addComponent(btnActuActor)
                    .addComponent(btnEliminarActor)
                    .addComponent(btnCancelarActor)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActorActionPerformed

    private void btnGuardarActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActActionPerformed
        guardar();
        txtId_actor.setText(null);
       txtNombreActor.setText(null);
       txtApellidoActor.setText(null);
       txtEdadActor.setText(null);

    }//GEN-LAST:event_btnGuardarActActionPerformed

    private void btnActuActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuActorActionPerformed
        actualizar();
        txtId_actor.setText(null);
       txtNombreActor.setText(null);
       txtApellidoActor.setText(null);
       txtEdadActor.setText(null);
    }//GEN-LAST:event_btnActuActorActionPerformed

    private void btnEliminarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActorActionPerformed
        eliminar();
        txtId_actor.setText(null);
    }//GEN-LAST:event_btnEliminarActorActionPerformed

    private void btnCancelarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActorActionPerformed
        VentanaPrincipal frm = new VentanaPrincipal();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActorActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mostrar();
    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaActores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaActores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaActores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaActores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaActores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActuActor;
    private javax.swing.JButton btnCancelarActor;
    private javax.swing.JButton btnEliminarActor;
    private javax.swing.JButton btnGuardarAct;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidoActor;
    private javax.swing.JTextField txtEdadActor;
    private javax.swing.JTextField txtId_actor;
    private javax.swing.JTextField txtNombreActor;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
