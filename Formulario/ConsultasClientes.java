/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Formulario;

import claseConectar.conectar;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author zTGuilleTankerSz
 */
public class ConsultasClientes extends javax.swing.JInternalFrame {
 
    public ConsultasClientes() {
        initComponents();
        txtdni.setEnabled(false);
        Cargarlistaclientes();
        this.jButton2.setVisible(false);
    }
    void Cargarlistaclientes()          
    {
       DefaultTableModel modelo= new DefaultTableModel();
       String []titulos={"Codigo","Nombres","tienda","barrio", "Telefono","direcion","Vendedor","Correo","cedula","Colgaderas","Exhibidor","Otros"};
       modelo.setColumnIdentifiers(titulos);
       
       this.tbclientes.setModel(modelo); 
        try {
            
            String ConsultaSQL="SELECT * FROM cliente";
        
            String []registros= new String[12];
           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(ConsultaSQL);
            while(rs.next())
            {
                registros[0]=rs.getString("cod_cli");  
                 registros[1]=rs.getString("NOMBRE");  
                 registros[2]=rs.getString("TIENDA");  
                 registros[3]=rs.getString("BARRIO");  
                 registros[4]=rs.getString("TELEFONO");  
                 registros[5]=rs.getString("direccion");  
                 registros[6]=rs.getString("vendedor_idvendedor");  
                 registros[7]=rs.getString("correo");  
                 registros[8]=rs.getString("cedula");    
                 registros[9]=rs.getString("colgadera");    
                 registros[10]=rs.getString("exhibidor");    
                 registros[11]=rs.getString("otros"); 
                modelo.addRow(registros);
                                
            }
            tbclientes.setModel(modelo);
            txtcant.setText(""+tbclientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JRadioButton();
        txttodos = new javax.swing.JRadioButton();
        txtdni = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        buttonGroup1.add(txtnombre);
        txtnombre.setText("Buscar Cliente Por Nombre");
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(txttodos);
        txttodos.setText("Mostrar todos los clientes");
        txttodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttodosActionPerformed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search (2).png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre)
                        .addGap(24, 24, 24)
                        .addComponent(txtdni, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txttodos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addComponent(btnbuscar)
                .addGap(245, 245, 245))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttodos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(tbclientes);

        jLabel1.setText("Cantidad de Registros");

        txtcant.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1448923885_news.png"))); // NOI18N
        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(391, 391, 391)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
// TODO add your handling code here:
    
   String dni=txtdni.getText();
    
   
   if(txtnombre.isSelected()==true)
   {
       
       DefaultTableModel modelo= new DefaultTableModel();
       String []titulos={"Codigo","Nombres","tienda","barrio","Barrio","Telefono","direcion","Vendedor","Correo","cedula","Colgaderas","Exhibidor","Otros"};
       modelo.setColumnIdentifiers(titulos);
       
       this.tbclientes.setModel(modelo); 
       try {
            
           String Sql="SELECT * FROM cliente where nombre LIKE '%"+dni+"%'";
        
            String []registros= new String[12];
           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while(rs.next())
            {
                
                 registros[0]=rs.getString("cod_cli");  
                 registros[1]=rs.getString("NOMBRE");  
                 registros[2]=rs.getString("TIENDA");  
                 registros[3]=rs.getString("BARRIO");  
                 registros[4]=rs.getString("TELEFONO");  
                 registros[5]=rs.getString("direccion");  
                 registros[6]=rs.getString("vendedor_idvendedor");  
                 registros[7]=rs.getString("correo");  
                 registros[8]=rs.getString("cedula");    
                 registros[9]=rs.getString("colgadera");    
                 registros[10]=rs.getString("exhibidor");    
                 registros[11]=rs.getString("otros");  
                modelo.addRow(registros);
                                
            }
            tbclientes.setModel(modelo);
            txtcant.setText(""+tbclientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   }
   if(txttodos.isSelected()==true)
   {
       Cargarlistaclientes();
   }
   
}//GEN-LAST:event_btnbuscarActionPerformed

private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
// TODO add your handling code here:
    if(txtnombre.isSelected()==true)
    { 
        txtdni.setEnabled(true);
        txtdni.requestFocus();
    }
}//GEN-LAST:event_txtnombreActionPerformed

private void txttodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttodosActionPerformed
// TODO add your handling code here:
    Cargarlistaclientes();
    txtdni.setText("");
    txtdni.setEnabled(false);
}//GEN-LAST:event_txttodosActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    List lista = new ArrayList();
    for(int i=0;i<tbclientes.getRowCount();i++)
    {
        listaclientes clientes= new listaclientes( 
                tbclientes.getValueAt(i, 0).toString(), 
                tbclientes.getValueAt(i, 1).toString(), 
                tbclientes.getValueAt(i, 3).toString(), 
                tbclientes.getValueAt(i, 4).toString(), 
                tbclientes.getValueAt(i, 5).toString());
        lista.add(clientes);
    }
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("reportesClientes.jasper");
            Map parametro = new HashMap(); 
            
            JasperPrint jprint= JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(jprint,false);
        } catch (JRException ex) {
            Logger.getLogger(ConsultasClientes.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("Formulario.ConsultasClientes.jButton2ActionPerformed()"+e);
        }
    
    
}//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtdni;
    private javax.swing.JRadioButton txtnombre;
    private javax.swing.JRadioButton txttodos;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();


}
