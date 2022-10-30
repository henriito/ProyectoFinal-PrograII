/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;


import datos.Conexion;
import datos.PeliculasDaoJDBC;
import domain.PeliculasDTO;
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
public class VentanaPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPeliculas
     */
    public VentanaPeliculas() {
        initComponents();
        setLocationRelativeTo(null);SetImageLabel(jLabel7,"C:\\Users\\Windows 10\\Desktop\\ejemploPatronSqlServer\\src\\main\\java\\Imagenes\\pelis.png");
    }
    private void SetImageLabel(JLabel labelName, String root){
            ImageIcon image = new ImageIcon(root);
            Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_DEFAULT));
            labelName.setIcon(icon);
            this.repaint();
        }
   public void mostrar(){
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Pelicula");
            model.addColumn("Titulo");
            model.addColumn("Estreno");
            model.addColumn("Genero");
            model.addColumn("Valoracion");
            visor.setModel(model);
       model.setRowCount(0);
       
       PreparedStatement ps;
       ResultSet rs;
       ResultSetMetaData rsmd;
       int columnas;
       
       
        Connection conexion = null;
        try {
        conexion = Conexion.getConnection();
        ps = conexion.prepareStatement("SELECT id_pelicula, titulo, estreno, genero, valoracion FROM pelicula");
        
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
     public void eliminar() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }

            PeliculasDTO usr = new PeliculasDTO();
            usr.setId_pelicula(Integer.parseInt(txtIdPeli.getText()));

            PeliculasDaoJDBC pelisDao = new PeliculasDaoJDBC(conexion);
            pelisDao.delete(usr);

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
        System.out.println("Fin del programa");
         JOptionPane.showMessageDialog(this, "Se elimino correctamente la película");
    }
     
    public void guardar(){
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }
                       
            PeliculasDaoJDBC pelijdbc = new PeliculasDaoJDBC(conexion);

            PeliculasDTO nuevaPelicula = new PeliculasDTO();
            nuevaPelicula.setTitulo(""+txtTitulo.getText());
            nuevaPelicula.setEstreno(Integer.parseInt(txtEstreno.getText()));
            nuevaPelicula.setGenero(""+txtGenero.getText());
            nuevaPelicula.setValoracion(Float.parseFloat(txtValor.getText()));
            pelijdbc.insert(nuevaPelicula);

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
        JOptionPane.showMessageDialog(this, "Se guardo correctamente la película");
    }
    
      public void actualizar() {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("Se establecio conexion");
            }

            PeliculasDTO cambioPelicula = new PeliculasDTO();
            cambioPelicula.setId_pelicula(Integer.parseInt(txtIdPeli.getText()));
            cambioPelicula.setTitulo("" + txtTitulo.getText());
            cambioPelicula.setEstreno(Integer.parseInt(txtEstreno.getText()));
            cambioPelicula.setGenero(""+txtGenero.getText());
            cambioPelicula.setValoracion(Float.parseFloat(txtValor.getText()));

            PeliculasDaoJDBC PeliculaJdbc = new PeliculasDaoJDBC(conexion);
            PeliculaJdbc.update(cambioPelicula);

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
        jLabel6 = new javax.swing.JLabel();
        txtIdPeli = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtEstreno = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnGuardarPeli = new javax.swing.JButton();
        btnActuPeli = new javax.swing.JButton();
        btnEliminarPeli = new javax.swing.JButton();
        btnCancelarPeli = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Películas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Id Película :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Título :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Estreno :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Género :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Valoración :");

        btnGuardarPeli.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        btnGuardarPeli.setText("Guardar");
        btnGuardarPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPeliActionPerformed(evt);
            }
        });

        btnActuPeli.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        btnActuPeli.setText("Actualizar");
        btnActuPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActuPeliActionPerformed(evt);
            }
        });

        btnEliminarPeli.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        btnEliminarPeli.setText("Eliminar");
        btnEliminarPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliActionPerformed(evt);
            }
        });

        btnCancelarPeli.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        btnCancelarPeli.setText("Cancelar");
        btnCancelarPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPeliActionPerformed(evt);
            }
        });

        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        visor.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(visor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );

        btnMostrar.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        btnMostrar.setText("Mostrar Tabla");
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
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnGuardarPeli)
                .addGap(18, 18, 18)
                .addComponent(btnActuPeli)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPeli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnMostrar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarPeli)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitulo)
                    .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(txtIdPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdPeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarPeli)
                    .addComponent(btnActuPeli)
                    .addComponent(btnEliminarPeli)
                    .addComponent(btnCancelarPeli)
                    .addComponent(btnMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPeliActionPerformed
       guardar(); 
        txtIdPeli.setText(null);
       txtTitulo.setText(null);
       txtEstreno.setText(null);
       txtGenero.setText(null);
       txtValor.setText(null);
    }//GEN-LAST:event_btnGuardarPeliActionPerformed

    private void btnCancelarPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPeliActionPerformed
        VentanaPrincipal frm = new VentanaPrincipal();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarPeliActionPerformed

    private void btnActuPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActuPeliActionPerformed
       actualizar();
       txtIdPeli.setText(null);
       txtTitulo.setText(null);
       txtEstreno.setText(null);
       txtGenero.setText(null);
       txtValor.setText(null);
    }//GEN-LAST:event_btnActuPeliActionPerformed

    private void btnEliminarPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliActionPerformed
        eliminar();
        txtIdPeli.setText(null);
    }//GEN-LAST:event_btnEliminarPeliActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActuPeli;
    private javax.swing.JButton btnCancelarPeli;
    private javax.swing.JButton btnEliminarPeli;
    private javax.swing.JButton btnGuardarPeli;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEstreno;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIdPeli;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
