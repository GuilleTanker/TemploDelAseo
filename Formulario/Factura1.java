/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zTGuilleTankerSz
 */
package Formulario;

import claseConectar.conec;
import claseConectar.conectar;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection; 
import java.sql.SQLException; 
import java.util.Calendar;
import java.util.HashMap; 
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport; 
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;

/**
 *
 * @author Administrador
 */
public class Factura1 extends javax.swing.JInternalFrame {
    public Factura1() {
        initComponents();
        this.setLocation(25,15 );  
        txtfec.setText(fechaactual());
        numeros();
        
      
        
    }
          void descontarstock(String codi,String can)
    {
       int des = Integer.parseInt(can);
       String cap="";
       int desfinal;
       String consul="SELECT * FROM productoespecial WHERE  idproductoespecial='"+codi+"'";
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                cap= rs.getString(3);
            }
            
            
        } catch (Exception e) {
        }
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE productoespecial SET Stock='"+desfinal+"' WHERE idproductoespecial = '"+codi+"'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
       
         
    }
     void numeros()
     {
        int j;
        int cont=1;
        String num="";
        String c="";
         String SQL="select max(idFactEspecial) from facturaespecial";
        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 c=rs.getString(1);
            }
            
           
            if(c==null){
                txtfac.setText("00000001");
            }
            else{
                 j=Integer.parseInt(c);
                 GenerarNumero gen= new GenerarNumero();
                 gen.generar(j);
                 txtfac.setText(gen.serie());
                
            
            }
       
          
                  
           
           
         
        } catch (SQLException ex) {
           Logger.getLogger(Factura1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    void factura(){
       String InsertarSQL="INSERT INTO facturaespecial (idFactEspecial,subtotal,total,fec_fac,cliente_cod_cli,formadepago ) VALUES (?,?,?,?,?,? )";
    String numfac=txtfac.getText();  
    String subtotal=txtsubtotal.getText(); 
    String total=txttotal.getText();
    String fecha=txtfec.getText();
    String cod=txtcodigo.getText();
    String form=txtformadepago.getText();
    try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1,numfac);
            pst.setString(2,subtotal);
            pst.setString(3,total);
            pst.setString(4,fecha);  
            pst.setString(5,cod);
            pst.setString(6,form);
            int n= pst.executeUpdate();
            if(n>0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se guardaron correctamente");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Factura1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void detallefactura(){
        for(int i=0;i<tbdet.getRowCount();i++)
        {
        String InsertarSQL="INSERT INTO detallefactura(des_pro,cant_pro ,pre_unit,pre_tot,ProductoEspecialIdProductoEspecial,FacturaEspecialidFactEspecial) VALUES (?,?,?,?,?,?)";
        String numfac=txtfac.getText();
        String codpro=tbdet.getValueAt(i, 0).toString();
        String despro=tbdet.getValueAt(i, 1).toString();
        String cantpro=tbdet.getValueAt(i, 3).toString();
        String preunit=tbdet.getValueAt(i, 2).toString();
        String importe=tbdet.getValueAt(i, 5).toString();
        String total = txttotal.getText();
        String factnum = txtfac.getText();
    
        try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
             pst.setString(1,despro);
            pst.setString(2,cantpro);
            pst.setString(3,preunit);
            pst.setString(4,total);
            pst.setString(5,codpro);
            pst.setString(6,factnum);  
            pst.executeUpdate();
          
           
        } catch (SQLException ex) {
            Logger.getLogger(Factura1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
 
  

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtbarrio = new javax.swing.JTextField();
        txttienda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtcolgadera = new javax.swing.JTextField();
        txtdir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtvendedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtformadepago = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        tbdetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdet = new javax.swing.JTable();
        btnimprimir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtotrosarea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        btnproductos = new javax.swing.JButton();
        centro = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        datos1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtfac = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfec = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Señor(a):");

        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(0, 51, 204));
        txtnombre.setEnabled(false);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtbarrio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtbarrio.setEnabled(false);

        txttienda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txttienda.setEnabled(false);
        txttienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttiendaActionPerformed(evt);
            }
        });

        jLabel11.setText("Tienda:");

        txtcolgadera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcolgadera.setForeground(new java.awt.Color(51, 51, 255));
        txtcolgadera.setEnabled(false);

        txtdir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdir.setEnabled(false);

        jLabel10.setText("Direccion:");

        jLabel9.setText("Colgadera:");

        jLabel13.setText("Barrio:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Vendedor:");

        txtvendedor.setText(" ");

        jLabel3.setText("Forma De Pago:");

        jLabel16.setText("Codigo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttienda, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel10)))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbarrio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtformadepago, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttelefono)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(txtcolgadera))
                .addGap(185, 185, 185))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtformadepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnombre)
                            .addComponent(jLabel9)
                            .addComponent(txtcolgadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("SubTotal:");

        jLabel20.setText("Total:");

        tbdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));

        tbdet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sugerido", "Descripcion", "Precio", "Cantidad", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdet);

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1448923885_news.png"))); // NOI18N
        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        txtotrosarea.setColumns(20);
        txtotrosarea.setRows(5);
        jScrollPane3.setViewportView(txtotrosarea);

        jLabel7.setText("Otros:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 115, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 115, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel18)
                                .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 161, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 161, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439854_checked_checkbox.png"))); // NOI18N
        btnguardar.setText("Factura");
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/close.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Tasks.png"))); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439934_trash.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/useradd.png"))); // NOI18N
        btnclientes.setText("Cliente");
        btnclientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        btnproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search (2).png"))); // NOI18N
        btnproductos.setText("Productos");
        btnproductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnproductos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnproductos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncalcular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btncalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        centro.setText("DISTRIBUIDORA EL TEMPLO  DEL ASEO");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("John Jairo Narváez");

        datos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datos1.setText("Cra 1 A 14 No. 71- 108 - Tel: 4449230 - Cel: 3127131990");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Cali - Valle Del Cauca");

        jLabel17.setText("Nº:");

        jLabel12.setText("Fecha:");

        jLabel1.setText(" Régimen simplificado");

        jLabel6.setText("NIT:  16932293-9");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/LOGO.png"))); // NOI18N

        jLabel14.setText("FABRICAMOS Y DISTRIBUIMOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel14))
                                    .addComponent(centro))
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(datos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtfac, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(10, 10, 10)
                                .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(centro))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(datos1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1527, 1527, 1527))
        );

        setBounds(0, 0, 862, 667);
    }// </editor-fold>//GEN-END:initComponents
public String  fechaactual(){
    
    
Date fecha=new Date(); 
SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY"); 
return formatoFecha.format(fecha);
        
}


private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
// TODO add your handling code here:
    clientes cli = new clientes();
    ventanaadmin.jdpescritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);
    
  
    
    
}//GEN-LAST:event_btnclientesActionPerformed

private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
// TODO add your handling code here:
    try {
          Productos pro= new Productos();
    ventanaadmin.jdpescritorio.add(pro);
    pro.toFront();
    pro.setVisible(true);
        
    } catch (Exception e) {
    }
     
}//GEN-LAST:event_btnproductosActionPerformed

private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtnombreActionPerformed

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
// TODO add your handling code here:
    if(tbdet.getRowCount()<1)
    {
        JOptionPane.showMessageDialog(this, "Error, no ingreso ningun producto");
    }
 
}//GEN-LAST:event_btncalcularActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
 
    
    
    if((txttienda.getText().equals("")) || (txtsubtotal.getText().equals("") || (txtformadepago.getText().equals(""))))
  {
      JOptionPane.showMessageDialog(this, "No ingreso Cliente,Productos o Forma De Pago");
  }
  else
  {
        String capcod="",capcan="";
    for(int i=0;i<Factura1.tbdet.getRowCount();i++)
    {
        capcod=Factura1.tbdet.getValueAt(i, 0).toString();
        capcan=Factura1.tbdet.getValueAt(i, 3).toString();
        descontarstock(capcod, capcan);
        
    }
    factura();
    detallefactura();
    imprimir();
    
        txttienda.setText("");
        txtnombre.setText("");
        txtdir.setText("");
        txtcolgadera.setText(""); 
        txtsubtotal.setText("");
        txtbarrio.setText("");
        txttotal.setText("");
       
        DefaultTableModel modelo = (DefaultTableModel) tbdet.getModel();
        int a =tbdet.getRowCount()-1;
        int i;
        for(i=a;i>=0;i--)
        {
            modelo.removeRow(i);
        }
      
    numeros();
  }
      
    

}//GEN-LAST:event_btnguardarActionPerformed

private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

      int n= JOptionPane.showConfirmDialog(null, "Esta Seguro De Elimimnar EL Articulo","Animal Software Center",JOptionPane.OK_CANCEL_OPTION);
        
        if(n == JOptionPane.YES_OPTION){
          try {
              DefaultTableModel modelo = (DefaultTableModel) tbdet.getModel();
    int fila = tbdet.getSelectedRow();
    if(fila>=0)
    {
       modelo.removeRow(fila);
       Productos pro= new Productos();
       pro.calcular();
    }
    else
    {
        JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila");
    } 
          }
          catch(Exception e){
            System.out.println("Formulario.Factura.btneliminarActionPerformed()" + e);
          }
            
        }
       
        
        else{
       
        }
    
      
}//GEN-LAST:event_btneliminarActionPerformed

private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
imprimir();
}//GEN-LAST:event_btnimprimirActionPerformed

    private void txttiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttiendaActionPerformed

void imprimir(){
          try {
            // TODO add your handling code here:
                List<ProductoReport> listaProductosList = new ArrayList<ProductoReport>();
                int filas= tbdet.getRowCount();
                for (int i = 0; i < filas; i++)
                {
                    ProductoReport p = new  ProductoReport(tbdet.getValueAt(i, 0).toString(), tbdet.getValueAt(i, 1).toString(), tbdet.getValueAt(i, 2).toString(), tbdet.getValueAt(i, 3).toString(), tbdet.getValueAt(i, 4).toString());
                    listaProductosList.add(p);
                }

                JasperReport reporte = (JasperReport) JRLoader.loadObject("ImpFacEsp.jasper");
                Map parametros = new HashMap();
                parametros.put("tienda", centro.getText().toString()); 
                parametros.put("nunfac", txtfac.getText().toString());
                parametros.put("nomape", txtnombre.getText().toString());
                parametros.put("Tienda",txttienda.getText().toString()); 
                parametros.put("direccion",txtdir.getText().toString());
                parametros.put("Barrio",txtbarrio.getText().toString());
                parametros.put("fecha",txtfec.getText());
                parametros.put("subtotal",txtsubtotal.getText().toString()); 
                parametros.put("total",txttotal.getText().toString());
                parametros.put("otros",txtotrosarea.getText().toString()); 
                parametros.put("Vendedor",txtvendedor.getText().toString()); 
                parametros.put("colgadera",txtcolgadera.getText().toString()); 
                parametros.put("telefono",txttelefono.getText().toString()); 
                parametros.put("forma",txtformadepago.getText().toString()); 
     
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaProductosList));
                JasperViewer jviewer = new JasperViewer(jasperPrint,false);
                jviewer.setTitle("Factura");
                jviewer.setVisible(true);
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Factura N:"+txtfac.getText()+".pdf"));
                exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(Factura1.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel centro;
    private javax.swing.JLabel datos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbdet;
    private javax.swing.JTable tbdetalle;
    public static javax.swing.JTextField txtbarrio;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtcolgadera;
    public static javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtfac;
    private javax.swing.JTextField txtfec;
    private javax.swing.JTextField txtformadepago;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextArea txtotrosarea;
    public static javax.swing.JTextField txtsubtotal;
    public static javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txttienda;
    public static javax.swing.JTextField txttotal;
    public static javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables

   conectar cc=new conectar();
   Connection cn= cc.conexion();
   
           
}