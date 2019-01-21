/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zTGuilleTankerSz
 */
package Formulario;


import claseConectar.conectar;
import java.awt.Color; 
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
import java.sql.Connection; 
import java.sql.SQLException; 
import java.util.HashMap;  
import net.sf.jasperreports.engine.JRException;  
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport;  
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter; 
import net.sf.jasperreports.engine.export.JRPdfExporter; 
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Administrador
 */
public class FacturaC extends javax.swing.JInternalFrame {

    /** Creates new form Factura */
    public FacturaC() {
        initComponents();
        this.setLocation(25,15 ); 
        txtfec.setDisabledTextColor(Color.green);
        txtfec.setText(fechaactual());
        numeros();
       
      
        
    }
       void descontarstock(String codi,String can) {
       int des = Integer.parseInt(can);
       String cap="";
       int desfinal;
       String consul="SELECT * FROM producto WHERE  cod_pro='"+codi+"'";
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next()) {
                cap= rs.getString(4);
            }
        } catch (Exception e) {
            System.out.println("Formulario.FacturaC.descontarstock()"+e);
        }
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE producto SET Stock='"+desfinal+"' WHERE cod_pro = '"+codi+"'";
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
         String SQL="select max(num_fac) from factura";
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
           Logger.getLogger(FacturaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  
    void factura(){
       String InsertarSQL="INSERT INTO factura (num_fac,subtotal,total,fec_fac,Cliente_cod_cli,vendedor) VALUES (?,?,?,?,?,?)";
    String numfac=txtfac.getText();
    String codcli=txtcod_cli.getText();
    String barcli=txtbarrio.getText();
    String subtotal=txtsubtotal.getText(); 
    String total=txttotal.getText();
    String fecha=txtfec.getText();
    try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1,numfac);
            pst.setString(2,subtotal);
            pst.setString(3,total);
            pst.setString(4,fecha);
            pst.setString(5,codcli);
            pst.setString(6,barcli);
            //pst.setString(5,igv);
            int n= pst.executeUpdate();
            if(n>0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se guardaron correctamente");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(FacturaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void detallefactura(){
        for(int i=0;i<tbdet.getRowCount();i++)
        {
        String InsertarSQL="INSERT INTO detallefactura(des_pro,cant_pro,pre_unit,pre_tot,producto_cod_pro,Factura_num_fac) VALUES (?,?,?,?,?,?)";
        String numfac=txtfac.getText();
        String codpro=tbdet.getValueAt(i, 0).toString();
        String despro=tbdet.getValueAt(i, 1).toString();
        String cantpro=tbdet.getValueAt(i, 3).toString();
        String preunit=tbdet.getValueAt(i, 2).toString();
        String importe=tbdet.getValueAt(i, 5).toString();
    
        try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
            pst.setString(1,despro);
            pst.setString(2,cantpro);
            pst.setString(3,preunit);
            pst.setString(4,importe);
            pst.setString(5,codpro);
            pst.setString(6,numfac);
          
            pst.executeUpdate();
          
           
        } catch (SQLException ex) {
            Logger.getLogger(FacturaC.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel1 = new javax.swing.JPanel();
        txtfec = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtfac = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        centro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datos = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtcod_cli = new javax.swing.JTextField();
        txtbarrio = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcolgadera = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtexhibidor = new javax.swing.JTextField();
        txtvendedor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        tbdetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdet = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtotrosarea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btncalcular = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        btnproductos = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();

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

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Fecha:");

        jLabel17.setText("Nº:");

        centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        centro.setText("DISTRIBUIDORA EL TEMPLO  DEL ASEO");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("John Jairo Narváez");

        datos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datos.setText("Cra 1 A 14 No. 71- 108 - Tel: 4449230 - Cel: 3127131990");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cali - Valle Del Cauca");

        jLabel6.setText("NIT:  16932293-9");

        jLabel1.setText(" Régimen simplificado");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/LOGO.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(centro, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtfac, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(centro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(datos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Cliente:");

        txtcod_cli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcod_cli.setForeground(new java.awt.Color(0, 51, 204));
        txtcod_cli.setEnabled(false);
        txtcod_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcod_cliActionPerformed(evt);
            }
        });

        txtbarrio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtbarrio.setEnabled(false);

        txtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcod.setEnabled(false);

        jLabel11.setText("Tienda:");

        txtdir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdir.setEnabled(false);

        jLabel10.setText("Direccion:");

        jLabel13.setText("Barrio:");

        jLabel5.setText("Vendedor:");

        txtcolgadera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcolgadera.setEnabled(false);

        jLabel7.setText("Colgadera:");

        jLabel9.setText("Exhibidor: ");

        txtexhibidor.setEditable(false);
        txtexhibidor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtexhibidor.setEnabled(false);

        txtvendedor.setEditable(false);
        txtvendedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtvendedor.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtvendedor))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcod_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtbarrio, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(txtdir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcolgadera, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txtexhibidor))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcod_cli)
                    .addComponent(txtbarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtcolgadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txtexhibidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
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
                "Codigo", "Descripcion", "Precio", "Cantidad", "Sugerido", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdet);

        jLabel14.setText("Otros:");

        txtotrosarea.setColumns(20);
        txtotrosarea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtotrosarea.setRows(5);
        txtotrosarea.setEnabled(false);
        jScrollPane3.setViewportView(txtotrosarea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 85, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 85, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 93, Short.MAX_VALUE)
                    .addComponent(tbdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 93, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439854_checked_checkbox.png"))); // NOI18N
        btnguardar.setText("Venta    ");
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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
                    .addComponent(btnproductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btncalcular)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1448923885_news.png"))); // NOI18N
        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        setBounds(0, 0, 811, 653);
    }// </editor-fold>//GEN-END:initComponents
public static String fechaactual(){
    Date fecha= new Date();
    SimpleDateFormat formatofecha= new SimpleDateFormat("dd/mm/yyyy");
    return formatofecha.format(fecha);
    


}

private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
// TODO add your handling code here:
    clientes cli = new clientes();
    ventanaadmin.jdpescritorio.add(cli);
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

private void txtcod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcod_cliActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtcod_cliActionPerformed

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
// TODO add your handling code here:
    if(tbdet.getRowCount()<1)
    {
        JOptionPane.showMessageDialog(this, "Error, no ingreso ningun producto");
    } else{
         Productos pro= new Productos();
        pro.calcular();
    }
        
 
}//GEN-LAST:event_btncalcularActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
  if((txtcod.getText().equals("")) || (txtsubtotal.getText().equals("")))
  {
      JOptionPane.showMessageDialog(this, "No ingreso cliente,productos o realice operacion");
  }
  else
  {
        String capcod="",capcan="";
    for(int i=0;i<FacturaC.tbdet.getRowCount();i++)
    {
        capcod=FacturaC.tbdet.getValueAt(i, 0).toString();
        capcan=FacturaC.tbdet.getValueAt(i, 3).toString(); 
        
    }
    factura();
    detallefactura();
    //imprimir();
    
        txtcod.setText("");
        txtcod_cli.setText("");
        txtdir.setText("");
        txtsubtotal.setText("");
        txtbarrio.setText("");
        txttotal.setText("");
        txtotrosarea.setText("");
        txtvendedor.setText("");
        txtcolgadera.setText("");
        txtexhibidor.setText("");
       
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
}//GEN-LAST:event_btneliminarActionPerformed

private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
//imprimir();
}//GEN-LAST:event_btnimprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel centro;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtcod_cli;
    public static javax.swing.JTextField txtcolgadera;
    public static javax.swing.JTextField txtdir;
    public static javax.swing.JTextField txtexhibidor;
    private javax.swing.JTextField txtfac;
    private javax.swing.JTextField txtfec;
    public static javax.swing.JTextArea txtotrosarea;
    public static javax.swing.JTextField txtsubtotal;
    public static javax.swing.JTextField txttotal;
    public static javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables

   conectar cc=new conectar();
   Connection cn= cc.conexion();
   
//   public void imprimir(){
//       try {
//                List<ProductoReport> listaProductos = new ArrayList<ProductoReport>();
//                int filas= tbdet.getRowCount();
//                for (int i = 0; i < filas; i++)
//                {
//                    ProductoReport p = new  ProductoReport(tbdet.getValueAt(i, 0).toString(),tbdet.getValueAt(i, 1).toString(),tbdet.getValueAt(i, 2).toString(),tbdet.getValueAt(i, 3).toString(),tbdet.getValueAt(i, 4).toString());
//                    listaProductos.add(p);
//                }  
//                  JasperReport reporte = (JasperReport) JRLoader.loadObject("ImpFacEsp.jaspe");
//                
//               Map parametros = new HashMap();
//
//                parametros.put("tienda", centro.getText().toString());
//                parametros.put("datos",datos.getText().toString());
//                parametros.put("nunfac", txtfac.getText().toString());
//                parametros.put("nomape", txtcod_cli.getText().toString());
//                parametros.put("codigo",txtcod.getText().toString()); 
//                parametros.put("direccion",txtdir.getText().toString());
//                parametros.put("ruc",txtbarrio.getText().toString());
//                parametros.put("fecha",txtfec.getText());
//                parametros.put("subtotal",txtsubtotal.getText().toString()); 
//                parametros.put("total",txttotal.getText().toString());
//                parametros.put("Otros",txtotrosarea.getText().toString());
//     
//          JasperPrint print=JasperFillManager.fillReport(reporte, parametros,cc.conexion());
//          JasperViewer.viewReport(print,false);
//                            JRExporter exporter = new JRPdfExporter();
//                exporter.setParameter(JRExporterParameter.JASPER_PRINT, reporte);
//                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportesproductos.pdf"));
//                exporter.exportReport();
//
//        } catch (JRException ex) {
//            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//   }
           
}