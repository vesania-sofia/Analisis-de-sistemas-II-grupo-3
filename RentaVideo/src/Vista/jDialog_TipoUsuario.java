/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.clsTipUsu;
import Modelo.daoTipUsu;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class jDialog_TipoUsuario extends javax.swing.JDialog {
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("estatus");
      
        clsTipUsu usuario = new clsTipUsu();
        //VendedorDAO vendedorDAO = new VendedorDAO();

        List<clsTipUsu> ListadoUsuario = usuario.getListadoUsuarios();
        Tbl_tipoUsuario.setModel(modelo);
        String[] dato = new String[3];
        for (int i = 0; i < ListadoUsuario.size(); i++) {
            dato[0] = Integer.toString(ListadoUsuario.get(i).getId_tipo_usuario());
            dato[1] = ListadoUsuario.get(i).getNombre_Tusuario();
            dato[2] = ListadoUsuario.get(i).getStatus_Tusuario();
            modelo.addRow(dato);
        }       
    }

    /**
     * Creates new form jDialog_TipoUsuario
     */
    public jDialog_TipoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenadoDeTablas();  
        
        this.setLocationRelativeTo(null);
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("activo");
        model.addElement("inactivo");
        Cbo_estatusTipoUsu.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Label_tipoDeUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_tipoUsuario = new javax.swing.JTable();
        Btn_actualizar = new javax.swing.JButton();
        Btn_buscar = new javax.swing.JButton();
        Label_IdAbuscar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Btn_registrar = new javax.swing.JButton();
        Btn_modificar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_limpiar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Txt_nombreTipoUsu = new javax.swing.JTextField();
        Txt_idTipoUsu = new javax.swing.JTextField();
        Cbo_estatusTipoUsu = new javax.swing.JComboBox<>();
        Btn_ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 0));

        jPanel2.setBackground(new java.awt.Color(106, 135, 191));

        Label_tipoDeUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Label_tipoDeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        Label_tipoDeUsuario.setText("REGISTRO TIPO DE USUARIO ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(Label_tipoDeUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(Label_tipoDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel1.setBackground(new java.awt.Color(201, 217, 242));

        Txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_buscarActionPerformed(evt);
            }
        });

        Tbl_tipoUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Tipo de Usuario", "Estatus"
            }
        ));
        jScrollPane2.setViewportView(Tbl_tipoUsuario);

        Btn_actualizar.setText("Actualizar");

        Btn_buscar.setText("Buscar");
        Btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarActionPerformed(evt);
            }
        });

        Label_IdAbuscar.setBackground(new java.awt.Color(255, 255, 255));
        Label_IdAbuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label_IdAbuscar.setForeground(new java.awt.Color(69, 84, 108));
        Label_IdAbuscar.setText("ID a Buscar");

        jPanel3.setBackground(new java.awt.Color(106, 135, 191));

        Btn_registrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\progra3\\Analisis-de-sistemas-II-grupo-3\\RentaVideo\\src\\Imagenes\\guardar.png")); // NOI18N
        Btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarActionPerformed(evt);
            }
        });

        Btn_modificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\progra3\\Analisis-de-sistemas-II-grupo-3\\RentaVideo\\src\\Imagenes\\editar.png")); // NOI18N
        Btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_modificarActionPerformed(evt);
            }
        });

        Btn_eliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\progra3\\Analisis-de-sistemas-II-grupo-3\\RentaVideo\\src\\Imagenes\\eliminar.png")); // NOI18N
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });

        Btn_limpiar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\progra3\\Analisis-de-sistemas-II-grupo-3\\RentaVideo\\src\\Imagenes\\limpiar.png")); // NOI18N
        Btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_limpiarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("   Limpiar");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("    Editar    ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("   Eliminar ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("  Agregar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(Btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(201, 217, 242));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(69, 84, 108))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(69, 84, 100));
        jPanel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(69, 84, 108));
        jLabel3.setText("Id");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(69, 84, 108));
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 84, 108));
        jLabel2.setText("Estatus");

        Txt_nombreTipoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_nombreTipoUsuActionPerformed(evt);
            }
        });

        Txt_idTipoUsu.setEditable(false);
        Txt_idTipoUsu.setBackground(new java.awt.Color(102, 102, 102));
        Txt_idTipoUsu.setForeground(new java.awt.Color(255, 255, 255));
        Txt_idTipoUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Txt_idTipoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_idTipoUsuActionPerformed(evt);
            }
        });

        Cbo_estatusTipoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbo_estatusTipoUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_nombreTipoUsu)
                    .addComponent(Txt_idTipoUsu)
                    .addComponent(Cbo_estatusTipoUsu, 0, 207, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txt_idTipoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Txt_nombreTipoUsu)))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Cbo_estatusTipoUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Btn_ayuda.setText("Ayuda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(Btn_actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Label_IdAbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_actualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_IdAbuscar)
                            .addComponent(Txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_buscar)
                            .addComponent(Btn_ayuda))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarActionPerformed
        // TODO add your handling code here:
        clsTipUsu usuario = new clsTipUsu();
        //usuario.setId_tipo_usuario(Integer.parseInt(Txt_idTipoUsu.getText()));
        usuario.setNombre_Tusuario(Txt_nombreTipoUsu.getText());
        
        // estado del tipo usuario
        String estadoSeleccionado = (String) Cbo_estatusTipoUsu.getSelectedItem();
        usuario.setStatus_Tusuario(estadoSeleccionado.equalsIgnoreCase("activo") ? "activo" : "inactivo");

        JOptionPane.showMessageDialog(null, "Registro Ingresado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();
    }//GEN-LAST:event_Btn_registrarActionPerformed

    private void Btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_modificarActionPerformed
        // TODO add your handling code here:
        clsTipUsu usuario = new clsTipUsu();
        //usuario.setId_tipo_usuario(Integer.parseInt(Txt_idTipoUsu.getText()));
        usuario.setNombre_Tusuario(Txt_nombreTipoUsu.getText());
        
        // Estatus Tipo Usuario
        String estadoSeleccionado = (String) Cbo_estatusTipoUsu.getSelectedItem();
        System.out.println("Estado seleccionado:" + estadoSeleccionado);
        usuario.setStatus_Tusuario(estadoSeleccionado.equalsIgnoreCase("activo") ? "activo" : "inactivo");
        
        daoTipUsu dao = new daoTipUsu();
        int result = dao.actualizausuarios(usuario);

         if (result > 0) {
        JOptionPane.showMessageDialog(null, "Datos Modificados\n", 
                "Información del Sistema", JOptionPane.INFORMATION_MESSAGE); 
        llenadoDeTablas();
        limpiarTextos();
        } else {
        JOptionPane.showMessageDialog(null, "Error al modificar datos\n", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Btn_modificarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsTipUsu Usuario = new clsTipUsu();
        Usuario.setId_tipo_usuario(Integer.parseInt(Txt_buscar.getText()));
        registrosBorrados=Usuario.setBorrarUsuario(Usuario);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void Btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_limpiarActionPerformed
        // TODO add your handling code here:

        limpiarTextos();
        
    }//GEN-LAST:event_Btn_limpiarActionPerformed

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        // TODO add your handling code here:
        clsTipUsu usuario = new clsTipUsu();
        //usuario.setNombreUsuario(txtbuscado.getText());
        usuario.setId_tipo_usuario(Integer.parseInt(Txt_buscar.getText()));
        usuario = usuario.getBuscarInformacionUsuarioPorId(usuario);
        
        if (usuario != null) {
            
            JOptionPane.showMessageDialog(this, "Tipo Usuario encontrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE); 
        
            Txt_idTipoUsu.setText(Integer.toString(usuario.getId_tipo_usuario()));
            Txt_nombreTipoUsu.setText(usuario.getNombre_Tusuario());
            
            // estado del tipo usuario
            String estadoSeleccionado = (String) Cbo_estatusTipoUsu.getSelectedItem();
            usuario.setStatus_Tusuario(estadoSeleccionado.equalsIgnoreCase("activo") ? "activo" : "inactivo");
            } else {
            JOptionPane.showMessageDialog(this, "Tipo Usuario no encontrado");
            } 
    }//GEN-LAST:event_Btn_buscarActionPerformed

    private void Txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_buscarActionPerformed

    private void Txt_idTipoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_idTipoUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_idTipoUsuActionPerformed

    private void Txt_nombreTipoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_nombreTipoUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_nombreTipoUsuActionPerformed

    private void Cbo_estatusTipoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbo_estatusTipoUsuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_Cbo_estatusTipoUsuActionPerformed
    
     public void limpiarTextos()
    {
        Txt_idTipoUsu.setText("");
        Txt_nombreTipoUsu.setText("");
        Cbo_estatusTipoUsu.setSelectedIndex(0);
        Txt_buscar.setText("");
    }
    public void habilitarBotones()
    {
        Btn_registrar.setEnabled(true);
        Btn_modificar.setEnabled(true);
        Btn_eliminar.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        Btn_registrar.setEnabled(true);
        Btn_modificar.setEnabled(true);
        Btn_eliminar.setEnabled(true);
    }    
    
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
            java.util.logging.Logger.getLogger(jDialog_TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDialog_TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDialog_TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDialog_TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDialog_TipoUsuario dialog = new jDialog_TipoUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_actualizar;
    private javax.swing.JButton Btn_ayuda;
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_limpiar;
    private javax.swing.JButton Btn_modificar;
    private javax.swing.JButton Btn_registrar;
    private javax.swing.JComboBox<String> Cbo_estatusTipoUsu;
    private javax.swing.JLabel Label_IdAbuscar;
    private javax.swing.JLabel Label_tipoDeUsuario;
    private javax.swing.JTable Tbl_tipoUsuario;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JTextField Txt_idTipoUsu;
    private javax.swing.JTextField Txt_nombreTipoUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
