/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Autor zTGuilleTankerSz
 */
package Formulario;

import claseConectar.conectar;

import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Boleta extends javax.swing.JInternalFrame {

    /** Creates new form Boleta */
    public Boleta() {
        initComponents();
        this.setLocation(15,15 );
        txtfecha.setDisabledTextColor(Color.blue);
        txtfecha.setText(fechaact());
        txtnumbol.setDisabledTextColor(Color.red);
        txtcod.setDisabledTextColor(Color.blue);
        txtdire.setDisabledTextColor(Color.blue);
        txtdni.setDisabledTextColor(Color.blue);
        txtnomape.setDisabledTextColor(Color.blue);
        
        numeros();
    }
          void descontarstock(String codi,String can)
    {
       int des = Integer.parseInt(can);
       String cap="";
       int desfinal;
       String consul="SELECT * FROM producto WHERE  cod_pro='"+codi+"'";
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                cap= rs.getString(4);
            }
            
            
        } catch (Exception e) {
        }
        desfinal=Integer.parseInt(cap)-des;
        String modi="UPDATE producto SET Stock='"+desfinal+"' WHERE cod_pro = '"+codi+"'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }
        
       
         
    }
    void numeros()
    {
        
        
        String c="";
        String SQL="select max(num_bol) from boleta";
        //String SQL="select count(*) from boleta";
    //String SQL="SELECT MAX(cod_emp) AS cod_emp FROM empleado";
     //String SQL="SELECT @@identity AS ID";
        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 c=rs.getString(1);
            }
            if(c==null){
                txtnumbol.setText("00000001");
            }
            else{
            int j=Integer.parseInt(c);
            GenerarNumero gen= new GenerarNumero();
            gen.generar(j);
             txtnumbol.setText(gen.serie());
            }
            
           
      
         
                  
           
           
         
        } catch (SQLException ex) {
           Logger.getLogger(Boleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void calcular()
    {
        String pre;
        String can;
        double igv=0;
        double total=0;
        double subtotal=0;
        double precio;
        int cantidad;
        double imp=0.0;
        
            /*can=Integer.parseInt(cant);
            imp=pre*can;
            dato[4]=Float.toString(imp);*/
        
        for(int i=0;i<tbdetbol.getRowCount();i++)
        {
            pre=tbdetbol.getValueAt(i, 2).toString();
            can=tbdetbol.getValueAt(i, 3).toString();
            precio=Double.parseDouble(pre);
            cantidad=Integer.parseInt(can);
            imp=precio*cantidad;
            subtotal=subtotal+imp;
            
            tbdetbol.setValueAt(Math.rint(imp*100)/100, i, 4);
            
        }
       
        txttotal.setText(""+Math.rint(subtotal*100)/100);
        
            
    }
    void boleta(){
       String InsertarSQL="INSERT INTO boleta(num_bol,cod_cli,pre_tot,fecha) VALUES (?,?,?,?)";
    String numbol=txtnumbol.getText();
    String codcli=txtcod.getText();
    
    String total=txttotal.getText();
    String fecha=txtfecha.getText();
    try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1,numbol);
            pst.setString(2,codcli);
            pst.setString(3,total);
            pst.setString(4,fecha);
           
            int n= pst.executeUpdate();
            if(n>0)
            {
                JOptionPane.showMessageDialog(null,"Los datos se guardaron correctamente");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void detalleboleta(){
        for(int i=0;i<tbdetbol.getRowCount();i++)
        {
        String InsertarSQL="INSERT INTO detalleboleta(num_bol,cod_pro,des_pro,cant_pro,pre_unit,pre_venta) VALUES (?,?,?,?,?,?)";
        String numbol=txtnumbol.getText();
        String codpro=tbdetbol.getValueAt(i, 0).toString();
        String despro=tbdetbol.getValueAt(i, 1).toString();
        String cantpro=tbdetbol.getValueAt(i, 3).toString();
        String preunit=tbdetbol.getValueAt(i, 2).toString();
        String importe=tbdetbol.getValueAt(i, 4).toString();
    
        try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1,numbol);
            pst.setString(2,codpro);
            pst.setString(3,despro);
            pst.setString(4,cantpro);
            pst.setString(5,preunit);
            pst.setString(6,importe);
          
             pst.executeUpdate();
          
           
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
public static String fechaact(){
    Date fecha= new Date();
    SimpleDateFormat formatofecha= new SimpleDateFormat("dd/mm/yyyy");
    return formatofecha.format(fecha);
    


}    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdetbol = new javax.swing.JTable();
        btncalcular = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        btneli = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnumbol = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtnomape = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtdire = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnproductos = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnclientes = new javax.swing.JButton();

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
        setIconifiable(true);
        setResizable(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439375_dog.png"))); // NOI18N
        jLabel17.setText("Centro Veterinario San Miguel");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Centro Veterinario San Miguel");

        jLabel3.setText("Cesar Zapata");

        jLabel5.setText("Telf: 481804");

        jLabel4.setText("Calle 11 ");

        jLabel16.setText("Jamundi - Valle Del Cauca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16)))
                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbdetbol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "PRECIO UNITARIO", "CANTIDAD", "PRECIO VENTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdetbol);

        btncalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Tasks.png"))); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439854_checked_checkbox.png"))); // NOI18N
        btnven.setText("Venta");
        btnven.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });

        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439934_trash.png"))); // NOI18N
        btneli.setText("Eliminar");
        btneli.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/close.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel20.setText("Total:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NIT: 75072636-5");

        jLabel6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("    Venta");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));

        jLabel8.setText("Nº");

        txtnumbol.setEnabled(false);

        txtfecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Señor(es):");

        txtnomape.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnomape.setEnabled(false);

        txtdni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdni.setEnabled(false);
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });

        jLabel10.setText("DNI:");

        jLabel11.setText("Cod.Cliente");

        txtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcod.setEnabled(false);

        txtdire.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdire.setEnabled(false);
        txtdire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireActionPerformed(evt);
            }
        });

        jLabel13.setText("Direccion:");

        jLabel14.setText("Productos:");

        btnproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search (2).png"))); // NOI18N
        btnproductos.setText("BUSCAR");
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnproductos))
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(btnproductos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Fecha:");

        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/useradd.png"))); // NOI18N
        btnclientes.setText("Cliente");
        btnclientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtnumbol)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(btnven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnclientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtnumbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnven)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalir)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtfechaActionPerformed

private void txtdireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtdireActionPerformed

private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtdniActionPerformed

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
// TODO add your handling code here:
    if(tbdetbol.getRowCount()<1)
    {
        JOptionPane.showMessageDialog(this, "ingrese algun producto");
    }
    else
    {
        calcular();
    }
    
}//GEN-LAST:event_btncalcularActionPerformed

private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
// TODO add your handling code here:
     ClientesB cli = new ClientesB();
    ventanaadmin.jdpescritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);
}//GEN-LAST:event_btnclientesActionPerformed

private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
// TODO add your handling code here:
      try {
          ProductosB pro= new ProductosB();
    ventanaadmin.jdpescritorio.add(pro);
    pro.toFront();
    pro.setVisible(true);
        
    } catch (Exception e) {
    }
}//GEN-LAST:event_btnproductosActionPerformed

private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
// TODO add your handling code here:
    if((txtcod.getText().equals(""))||(txttotal.getText().equals(""))){
        JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
    }
    else{
         String capcod="",capcan="";
    for(int i=0;i<Boleta.tbdetbol.getRowCount();i++)
    {
        capcod=Boleta.tbdetbol.getValueAt(i, 0).toString();
        capcan=Boleta.tbdetbol.getValueAt(i, 3).toString();
        descontarstock(capcod, capcan);
        
    }
    boleta();
    detalleboleta();
    txtcod.setText("");
        txtnomape.setText("");
       
        txtdni.setText("");
        txtdire.setText("");
      
        
        
        txttotal.setText("");
       
        DefaultTableModel modelo = (DefaultTableModel) tbdetbol.getModel();
        int a =tbdetbol.getRowCount()-1;
        int i;
        for(i=a;i>=0;i--)
        {
            modelo.removeRow(i);
        }
        numeros();
    }
    
}//GEN-LAST:event_btnvenActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
// TODO add your handling code here:
    DefaultTableModel model = (DefaultTableModel) tbdetbol.getModel();
    int fila = tbdetbol.getSelectedRow();
    if(fila>=0)
    {
        model.removeRow(fila);
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Tabla vacia o no seleccione ninguna fila");
    }
    
}//GEN-LAST:event_btneliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnven;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbdetbol;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtdire;
    public static javax.swing.JTextField txtdni;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtnomape;
    private javax.swing.JTextField txtnumbol;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();
}
