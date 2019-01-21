/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import static Formulario.ventanaadmin.jdpescritorio;
import claseConectar.conectar;
import java.awt.HeadlessException;
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
public class ProductoEspecial_Agregar extends javax.swing.JInternalFrame {

       DefaultTableModel tabla;
    /**
     * Creates new form ProductoEspecial_Agregar
     */
    public ProductoEspecial_Agregar() {
        initComponents();
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
        Enviar = new javax.swing.JMenuItem();
        txtprod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod = new javax.swing.JTable();
        btnmostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Enviar);

        setClosable(true);
        setIconifiable(true);

        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar Productos");

        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbprod);

        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search.png"))); // NOI18N
        btnmostrar.setText("Mostrar todo");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnmostrar)
                        .addGap(113, 113, 113)
                        .addComponent(jButton1)
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnmostrar)
                        .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void calcular()
    {
        String sug="";
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
        
        for(int i=0;i<FacturaC.tbdet.getRowCount();i++)
        {
            pre=FacturaC.tbdet.getValueAt(i, 2).toString();
            can=FacturaC.tbdet.getValueAt(i, 3).toString();
            precio=Double.parseDouble(pre);
            cantidad=Integer.parseInt(can);
            imp=precio*cantidad;
            subtotal=subtotal+imp;
            //igv=subtotal*0.18;
            total=subtotal+igv;
            // txtcod.setText(""+Math.rint(c*100)/100)
            FacturaC.tbdet.setValueAt(Math.rint(imp*100)/100, i, 5);
            
        }
        FacturaC.txtsubtotal.setText(Double.toString(subtotal));
//        Factura.txtigv.setText(""+Math.rint(igv*100)/100);
        FacturaC.txttotal.setText(""+Math.rint(total*100)/100);
        
            
    }
     String comparar(String cod)
    {
        String cant="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productoespecial WHERE idproductoespecial='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(5);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
        
    }
     
    void cargarlistaproductos(String dato){
        String [] Titulo = {"Codigo","Precio","codigo","Descripcion","Stock","sugerido","Codigo Cliente"};
        tabla=new DefaultTableModel(null,Titulo);
    String []Registro= new String[7];
    String mostrar="SELECT * FROM productoespecial WHERE producto_des LIKE '%"+dato+"%'"; 
    Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs =st.executeQuery(mostrar);
            while(rs.next())
            {
                Registro[0]=rs.getString("idproductoespecial");
                Registro[1]=rs.getString("Precio");
                Registro[2]=rs.getString("producto_cod");
                Registro[3]=rs.getString("producto_des");
                Registro[4]=rs.getString("Stock");
                Registro[5]=rs.getString("sugerido");
                Registro[6]=rs.getString("clientecod");
                tabla.addRow(Registro);
                
            }
            tbprod.setModel(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }

    private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
        // TODO add your handling code here:
        cargarlistaproductos(txtprod.getText());
    }//GEN-LAST:event_txtprodKeyReleased

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        // TODO add your handling code here:
        cargarlistaproductos("");
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          ProductosEspeciales fac = new ProductosEspeciales();
    jdpescritorio.add(fac);
    fac.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        // TODO add your handling code here:
        //String [] Titulo = {"Codigo","Precio","codigo","Descripcion","Stock","sugerido","Codigo Cliente"};
  try {
        
         DefaultTableModel tabladet = (DefaultTableModel) FacturaC.tbdet.getModel();
         String[]  dato=new String[5];
   
         int  fila = tbprod.getSelectedRow();
       
         if(fila==-1)
         {
             JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
         }
         
         else
          {
          String codins=tbprod.getValueAt(fila, 0).toString();
          String desins=tbprod.getValueAt(fila, 3).toString();
          String preins=tbprod.getValueAt(fila, 1).toString();
          String precioins=tbprod.getValueAt(fila, 1).toString();
          String sugins=tbprod.getValueAt(fila, 5).toString();
          int c=0;
          int j=0;
           String  cant=JOptionPane.showInputDialog("ingrese cantidad");
         if((cant.equals("")) || (cant.equals("0")))
         {
             JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
         }
         else
         {
             
             int canting=Integer.parseInt(cant);
             int comp=Integer.parseInt(comparar(codins));
             if(canting>comp)
             {
                 JOptionPane.showMessageDialog(this,"Ud. no cuenta con el stock apropiado");
             }
             else
             {
                      for(int i=0;i<FacturaC.tbdet.getRowCount();i++)
          {
            Object com=FacturaC.tbdet.getValueAt(i,0);
            if(codins.equals(com))
            {
                j=i;
                FacturaC.tbdet.setValueAt(cant, i, 4);
                c=c+1;
       
            }
   
          }
          if(c==0)
          { 
            
      
            dato[0]=codins;
            dato[1]=desins;
            dato[2]=preins;
            dato[3]=cant;
            dato[4]=sugins;
            
            tabladet.addRow(dato);
        
            FacturaC.tbdet.setModel(tabladet);
            //calcular();
            //fac.calcular();
            
        }
             }
            //  fac.calcular();
         }
        
    }
      
    
    } catch (Exception e) {
        
    }
  
    }//GEN-LAST:event_EnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Enviar;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbprod;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();
}