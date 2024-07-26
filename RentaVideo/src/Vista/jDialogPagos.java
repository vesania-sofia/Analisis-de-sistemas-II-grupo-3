
package Vista;
import Controlador.clsPagos;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author sofia
 */
public class jDialogPagos extends javax.swing.JDialog {
    
    
    public void llenadoDeComboAlquiler() {/*
        clsCliente cliente = new clsCliente();
        List<clsCliente> listadoClientes = cliente.getListadoClientes();
        Cbo_cliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        Cbo_cliente.addItem("Seleccionar...");
        for (int i = 0; i < listadoClientes.size(); i++) {
            clsCliente Cliente = listadoClientes.get(i);
            String item = Cliente.getIdCliente() + " - " + Cliente.getNombreCliente();
            Cbo_cliente.addItem(item);
        } */
    }
        
      public void llenadoDeComboMetodoPago() {/*
        clsVideo video = new clsVideo();
        List<clsVideo> listadoVideos = video.getListadoVideos();
        Cbo_video.setAlignmentX(Component.CENTER_ALIGNMENT);
        Cbo_video.addItem("Seleccionar...");
        for (int i = 0; i < listadoVideos.size(); i++) {
            clsVideo Banco = listadoVideos.get(i);
            String item = Video.getIdVideo() + " - " + Video.getNombreVideo();
            Cbo_video.addItem(item);
        }*/
    }
        
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Recibo");
        modelo.addColumn("ID Alquiler");
        modelo.addColumn("Pago");
        modelo.addColumn("Tipo de Pago");
        modelo.addColumn("Descuento");
        modelo.addColumn("Mora");
        
        clsPagos Spago = new clsPagos();
        
        List<clsPagos> listadoPagos = Spago.getListadoPagos();
        Tbl_Pagos.setModel(modelo);
        String[] dato = new String[5];
        for (int i = 0; i < listadoPagos.size(); i++) {
            dato[0] = Integer.toString(listadoPagos.get(i).getId_recibo());
            dato[1] = Integer.toString(listadoPagos.get(i).getId_alquiler());;
            dato[2] = Float.toString(listadoPagos.get(i).getPago());
            dato[3] = listadoPagos.get(i).getTipo_pago();
            dato[4] = Integer.toString(listadoPagos.get(i).getDescuento_pago());
            dato[5] = Integer.toString(listadoPagos.get(i).getMora_pago());
            modelo.addRow(dato);
        }   
    }


    /**
     * Creates new form Registro_Pago
     */
    public jDialogPagos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenadoDeTablas();
        llenadoDeComboAlquiler();
        llenadoDeComboMetodoPago();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboMpago = new javax.swing.JComboBox<>();
        lbl_cantidad2 = new javax.swing.JLabel();
        lbl_cantidad3 = new javax.swing.JLabel();
        lbl_cantidad6 = new javax.swing.JLabel();
        Cbo_Alquiler = new javax.swing.JComboBox<>();
        txtId_Recibo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbl_RentaTotal1 = new javax.swing.JLabel();
        txt_Pago = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Pagos = new javax.swing.JTable();
        lbl_cantidad7 = new javax.swing.JLabel();
        lbl_cantidad8 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        Btn_registrarP = new javax.swing.JButton();
        Btn_eliminarP = new javax.swing.JButton();
        Btn_modificarP = new javax.swing.JButton();
        Btn_limpiarP = new javax.swing.JButton();
        lbl_cantidad4 = new javax.swing.JLabel();
        Txt_buscadoP = new javax.swing.JTextField();
        Btn_buscarP = new javax.swing.JButton();
        Btn_actualizarP = new javax.swing.JButton();
        Btn_ayudaP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        cboMpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMpagoActionPerformed(evt);
            }
        });

        lbl_cantidad2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad2.setText("Métodos de Pago:");

        lbl_cantidad3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad3.setText("Id Recibo:");

        lbl_cantidad6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad6.setText("Id Alquiler:");

        Cbo_Alquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbo_AlquilerActionPerformed(evt);
            }
        });

        txtId_Recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_ReciboActionPerformed(evt);
            }
        });

        lbl_RentaTotal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_RentaTotal1.setText("Total:");

        txt_Pago.setEditable(false);
        txt_Pago.setBackground(new java.awt.Color(255, 0, 0));
        txt_Pago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Pago.setForeground(new java.awt.Color(255, 255, 255));
        txt_Pago.setText("Q.\n");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_RentaTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_Pago, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lbl_RentaTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txt_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Tbl_Pagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Recibo", "Id Alquiler", "Pago Total", "Tipo Pago", "Descuento", "Mora"
            }
        ));
        jScrollPane1.setViewportView(Tbl_Pagos);

        lbl_cantidad7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad7.setText("Descuento:");

        lbl_cantidad8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad8.setText("Mora ");

        txtMora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoraActionPerformed(evt);
            }
        });

        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });

        Btn_registrarP.setBackground(new java.awt.Color(0, 102, 255));
        Btn_registrarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        Btn_registrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_registrarPActionPerformed(evt);
            }
        });

        Btn_eliminarP.setBackground(new java.awt.Color(0, 102, 255));
        Btn_eliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        Btn_eliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarPActionPerformed(evt);
            }
        });

        Btn_modificarP.setBackground(new java.awt.Color(0, 102, 255));
        Btn_modificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        Btn_modificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_modificarPActionPerformed(evt);
            }
        });

        Btn_limpiarP.setBackground(new java.awt.Color(0, 102, 255));
        Btn_limpiarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        Btn_limpiarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_limpiarPActionPerformed(evt);
            }
        });

        lbl_cantidad4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_cantidad4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cantidad4.setText(" Id a Buscar");

        Txt_buscadoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_buscadoPActionPerformed(evt);
            }
        });

        Btn_buscarP.setText("BUSCAR");
        Btn_buscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarPActionPerformed(evt);
            }
        });

        Btn_actualizarP.setText("ACTUALIZAR");
        Btn_actualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_actualizarPActionPerformed(evt);
            }
        });

        Btn_ayudaP.setText("Ayuda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lbl_cantidad8)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(lbl_cantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(35, 35, 35)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_cantidad3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lbl_cantidad6, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addGap(34, 34, 34))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lbl_cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboMpago, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtId_Recibo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Cbo_Alquiler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(Btn_registrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(Btn_eliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(Btn_modificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(Btn_limpiarP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btn_buscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lbl_cantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Txt_buscadoP, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Btn_ayudaP, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_actualizarP, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboMpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtId_Recibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Cbo_Alquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_cantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_limpiarP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_modificarP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_eliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_registrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn_actualizarP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_ayudaP))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_cantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_buscadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_buscarP)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nombre.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("PAGOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMpagoActionPerformed

    private void Cbo_AlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbo_AlquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbo_AlquilerActionPerformed

    private void txtId_ReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_ReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_ReciboActionPerformed

    private void txtMoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoraActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void Btn_registrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_registrarPActionPerformed
        // TODO add your handling code here:
        /*clsPagos Spagos = new clsPagos();
        String selectedItem = Cbo_Alquiler.getSelectedItem().toString();
            int itemId = Integer.parseInt(selectedItem.split(" - ")[0]);
            Spagos.setId_alquiler(itemId);
        Spagos.setPago(Float.parseFloat(txtValor.getText()));
        String selectedItem = cboMpago.getSelectedItem().toString();
            int itemId = Integer.parseInt(selectedItem.split(" - ")[0]);
            Spagos.setTipo_pago(itemId);
        Spagos.setDescuento_pago(Integer.parseInt(txtid.getText()));
        Spagos.setMora_pago(Integer.parseInt(txtid.getText()));*/
              // TODO add your handling code here:
        String id_alquiler = Cbo_Alquiler.getSelectedItem().toString();
        String pago =txt_Pago.toString();
        String tipo_pago = cboMpago.getSelectedItem().toString();
        String descuento_pago= txtDescuento.toString();
        String mora_pago = txtMora.toString();
      
 if (id_alquiler.equals("Seleccionar...")|| tipo_pago.equals("Seleccionar...")){
   JOptionPane.showMessageDialog(null, "Error! Debe seleccionar todos los Id", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
}else{
        clsPagos Spagos = new clsPagos();
        Spagos.setId_alquiler(Integer.parseInt(Cbo_Alquiler.getSelectedItem().toString()));
        Spagos.setPago(Integer.parseInt(txt_Pago.getText()));
        Spagos.setTipo_pago(cboMpago.getSelectedItem().toString());
        Spagos.setDescuento_pago(Integer.parseInt(txtDescuento.getText()));
        Spagos.setMora_pago(Integer.parseInt(txtMora.getText()));

        Spagos.setIngresarPago(Spagos);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
 
        llenadoDeTablas();
        //BusquedaComp();
        //limpiarTextos();
  
 }     

    }//GEN-LAST:event_Btn_registrarPActionPerformed

    private void Btn_eliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarPActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsPagos Spagos = new clsPagos();
        Spagos.setId_recibo(Integer.parseInt(Txt_buscadoP.getText()));
        registrosBorrados=Spagos.setBorrarPago(Spagos);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;

        llenadoDeTablas();
        //limpiarTextos();
    }//GEN-LAST:event_Btn_eliminarPActionPerformed

    private void Btn_modificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_modificarPActionPerformed
        // TODO add your handling code here:
        clsPagos Spagos = new clsPagos();
        Spagos.setId_alquiler(Integer.parseInt(Cbo_Alquiler.getSelectedItem().toString()));
        Spagos.setPago(Integer.parseInt(txt_Pago.getText()));
        Spagos.setTipo_pago(cboMpago.getSelectedItem().toString());
        Spagos.setDescuento_pago(Integer.parseInt(txtDescuento.getText()));
        Spagos.setMora_pago(Integer.parseInt(txtMora.getText()));
        JOptionPane.showMessageDialog(null, "Registro Modificado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);

        llenadoDeTablas();
        //limpiarTextos();
    }//GEN-LAST:event_Btn_modificarPActionPerformed

    private void Btn_limpiarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_limpiarPActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        //habilitarBotones();
    }//GEN-LAST:event_Btn_limpiarPActionPerformed

    private void Txt_buscadoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_buscadoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_buscadoPActionPerformed

    private void Btn_buscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarPActionPerformed
        // TODO add your handling code here:
        clsPagos Spagos = new clsPagos();
        Spagos.setId_recibo(Integer.parseInt(Txt_buscadoP.getText()));
        Spagos = Spagos.getBuscarInformacionPagoPorId(Spagos);
        System.out.println("Pago retornada:" + Spagos);
        txt_Pago.setText(String.valueOf(Spagos.getPago()));
        txtMora.setText(String.valueOf(Spagos.getMora_pago()));
        txtDescuento.setText(String.valueOf(Spagos.getDescuento_pago()));

        int Alquiler = Spagos.getId_alquiler();
        for (int i = 1; i < Cbo_Alquiler.getItemCount(); i++) {
            int item = Integer.parseInt(Cbo_Alquiler.getItemAt(i).toString());
            if (item == Alquiler) {
                Cbo_Alquiler.setSelectedIndex(i);
                break;
            }
        }

        String Mpago = Spagos.getTipo_pago();
        for (int i = 1; i < cboMpago.getItemCount(); i++) {
            String item = cboMpago.getItemAt(i).toString();
            if (item.equals(Mpago)) {
                cboMpago.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_Btn_buscarPActionPerformed

    private void Btn_actualizarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_actualizarPActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_Btn_actualizarPActionPerformed
   public void limpiarTextos()
    {
        txtId_Recibo.setText("");
        Cbo_Alquiler.setSelectedIndex(0);
        cboMpago.setSelectedIndex(0);
        txt_Pago.setText("");
        txtMora.setText("");
        txtDescuento.setText("");
        Txt_buscadoP.setText("");
    }
    public void habilitarBotones()
    {
        Btn_registrarP.setEnabled(true);
        Btn_modificarP.setEnabled(true);
        Btn_eliminarP.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        Btn_registrarP.setEnabled(true);
        Btn_modificarP.setEnabled(true);
        Btn_eliminarP.setEnabled(true);
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
            java.util.logging.Logger.getLogger(jDialogPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDialogPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDialogPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDialogPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDialogPagos dialog = new jDialogPagos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btn_actualizarP;
    private javax.swing.JButton Btn_ayudaP;
    private javax.swing.JButton Btn_buscarP;
    private javax.swing.JButton Btn_eliminarP;
    private javax.swing.JButton Btn_limpiarP;
    private javax.swing.JButton Btn_modificarP;
    private javax.swing.JButton Btn_registrarP;
    private javax.swing.JComboBox<String> Cbo_Alquiler;
    private javax.swing.JTable Tbl_Pagos;
    private javax.swing.JTextField Txt_buscadoP;
    private javax.swing.JComboBox<String> cboMpago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_RentaTotal1;
    private javax.swing.JLabel lbl_cantidad2;
    private javax.swing.JLabel lbl_cantidad3;
    private javax.swing.JLabel lbl_cantidad4;
    private javax.swing.JLabel lbl_cantidad6;
    private javax.swing.JLabel lbl_cantidad7;
    private javax.swing.JLabel lbl_cantidad8;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtId_Recibo;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txt_Pago;
    // End of variables declaration//GEN-END:variables
}