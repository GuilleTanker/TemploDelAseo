/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import claseConectar.conectar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class Clientes_Factura extends javax.swing.JInternalFrame {
    DefaultTableModel model;

    /**
     * Creates new form Clientes_Factura
     */
    public Clientes_Factura() {
        initComponents();
    }
void buscar(String valor){
        
        String[]titulos={"Codigo","Nombre","Cedula","Tienda","Barrio","Telefono","direcion","Codigo Vendedor","Correo","Exhibidor","Colgaderas","Otros" } ;  
        String []Registros= new String[13];
        model=new DefaultTableModel(null,titulos);
        //String Sql="SELECT cliente.cod_cli,cliente.nombre,cliente.Tienda,cliente.Barrio,cliente.Telefono,cliente.Direccion,cliente.Vendedor_idVendedor,cliente.Correo FROM cliente, cliente.Cedula,sugerencia.EXHIBIDOR, sugerencia.COLGADERAS,sugerencia.otros from sugerencia,cliente  WHERE cod_cli LIKE '%"+valor+"%'";
       // String Sql="SELECT * FROM cliente,sugerencia WHERE CONCAT(cliente.cod_cli,  cliente.nombre,   cliente.tienda,cliente.barrio,cliente.telefono,sugerencia.exhibidor,sugerencia.colgaderas,sugerencia.otros) LIKE '%"+valor+"%'";
       String Sql="SELECT DISTINCT  * FROM Cliente INNER JOIN sugerencia ON cliente.cod_cli = sugerencia.cliente_cod_cli where  Nombre LIKE '%"+valor+"%'"; 
       try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                 Registros[0]=rs.getString("Cod_cli");  
                 Registros[1]=rs.getString("Nombre");  
                 Registros[2]=rs.getString("Cedula");  
                 Registros[3]=rs.getString("Tienda");  
                 Registros[4]=rs.getString("Barrio");  
                 Registros[5]=rs.getString("Telefono");  
                 Registros[6]=rs.getString("Direccion");  
                 Registros[7]=rs.getString("Vendedor_idVendedor");  
                 Registros[8]=rs.getString("Correo");   
                 Registros[9]=rs.getString("EXHIBIDOR");  
                 Registros[10]=rs.getString("COLGADERAS");  
                 Registros[11]=rs.getString("Otros");  
                 model.addRow(Registros);
             } 
             tbclientes.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    void mostrarclientes(String valor) {
        String mostrar="SELECT DISTINCT  * FROM cliente,sugerencia WHERE CONCAT(cliente.cod_cli,  cliente.nombre,   cliente.tienda,cliente.barrio,cliente.telefono,sugerencia.exhibidor,sugerencia.colgaderas,sugerencia.otros) LIKE '%"+valor+"%'";
//    String mostrar="select * from cliente, sugerencia ";
    String []titulos={"Codigo","Nombre","Cedula","Tienda","Barrio","Telefono","direcion","Codigo Vendedor","Correo","Exhibidor","Colgaderas","Otros"};
    String []Registros=new String[12];
    model= new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
             
              while(rs.next())
              {
                  Registros[0]= rs.getString("cod_cli");
                  Registros[1]= rs.getString("nombre");
                  Registros[2]= rs.getString("cedula"); 
                  Registros[3]= rs.getString("tienda");
                  Registros[4]= rs.getString("barrio");
                  Registros[5]= rs.getString("telefono");
                  Registros[6]= rs.getString("direccion");
                  Registros[7]= rs.getString("vendedor_idvendedor");
                  Registros[8]= rs.getString("correo");         
                  Registros[9]= rs.getString("Exhibidor");         
                  Registros[10]= rs.getString("Colgaderas");         
                  Registros[11]= rs.getString("Otros");         
                          
                  model.addRow(Registros);
                   
              }
              tbclientes.setModel(model); 
        } catch (SQLException ex) {
            Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        ENVIAR = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbus = new javax.swing.JButton();
        txtbus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        Btnregistrar = new javax.swing.JButton();

        ENVIAR.setText("Enviar");
        ENVIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENVIARActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ENVIAR);

        jLabel1.setText("Buscar Cliente:");

        btnbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search.png"))); // NOI18N
        btnbus.setText("Mostrar Todo");
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });

        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });
        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbclientes);

        Btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/clients.png"))); // NOI18N
        Btnregistrar.setText("Registrar Clientes");
        Btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnregistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnregistrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbus)
                    .addComponent(Btnregistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
        // TODO add your handling code here:
        mostrarclientes(" ");
    }//GEN-LAST:event_btnbusActionPerformed

    private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtbusActionPerformed

    private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
        // TODO add your handling code here:
       buscar(txtbus.getText());
    }//GEN-LAST:event_txtbusKeyReleased

    private void BtnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnregistrarActionPerformed
        // TODO add your handling code here:
        try {
            IngresoCliente ingcli= new IngresoCliente();
            ventanaadmin.jdpescritorio.add(ingcli);
            ingcli.toFront();
            ingcli.setVisible(true);
            this.dispose();

        } catch (Exception e) {
        }

    }//GEN-LAST:event_BtnregistrarActionPerformed

    private void ENVIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENVIARActionPerformed
        // TODO add your handling code here:
         String cod="",nom="",barrio="",colgadera="",tienda="",direccion="",exhibidor="",vendedor="",otros="";
    int fila = tbclientes.getSelectedRow();
    try {
        if(fila==-1)
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");
                  
        }
        else
        {
         cod =  (String)tbclientes.getValueAt(fila, 0);
         nom =  (String)tbclientes.getValueAt(fila, 1);
         tienda =  (String)tbclientes.getValueAt(fila, 3);
         barrio =  (String)tbclientes.getValueAt(fila, 4);
         direccion=  (String)tbclientes.getValueAt(fila, 6);
         vendedor=  (String)tbclientes.getValueAt(fila, 7);
         colgadera =  (String)tbclientes.getValueAt(fila, 9);
         exhibidor=  (String)tbclientes.getValueAt(fila, 10);
         otros=  (String)tbclientes.getValueAt(fila, 11);
         
         
         Factura.txtcod_cli.setDisabledTextColor(Color.blue);
         Factura.txtcod_cli.setText(cod);         
         Factura.txtbarrio.setDisabledTextColor(Color.blue);
         Factura.txtbarrio.setText(barrio);
         Factura.txtcolgadera.setDisabledTextColor(Color.blue);
         Factura.txtcolgadera.setText(colgadera);
         Factura.txtcod.setDisabledTextColor(Color.blue);
         Factura.txtcod.setText(tienda);
         Factura.txtdir.setDisabledTextColor(Color.blue);
         Factura.txtdir.setText(direccion);
         Factura.txtexhibidor.setDisabledTextColor(Color.blue);
         Factura.txtexhibidor.setText(exhibidor);
         Factura.txtvendedor.setDisabledTextColor(Color.blue);
         Factura.txtvendedor.setText(vendedor);
         Factura.txtotrosarea.setDisabledTextColor(Color.blue);
         Factura.txtotrosarea.setText(otros);
         
         this.dispose();
         
        }
    } catch (Exception e) {
        System.out.println("Formulario.clientes.mnenviarActionPerformed()"+e );
    }                                      
 
    }//GEN-LAST:event_ENVIARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnregistrar;
    private javax.swing.JMenuItem ENVIAR;
    private javax.swing.JButton btnbus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables
    conectar cc= new conectar();
    Connection cn = cc.conexion();
}
