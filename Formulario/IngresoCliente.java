
package Formulario;

import claseConectar.Conexion;
import claseConectar.conec;
import claseConectar.conectar;
import java.awt.HeadlessException;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zTGuilleTankerSz
 */
public class IngresoCliente extends javax.swing.JInternalFrame {
    DefaultTableModel model;
    DefaultComboBoxModel modeloCombo;
    
 
    /** Creates new form IngresoCliente */
    public IngresoCliente() {
        initComponents();
        bloquear();
        cargar("");
        //modeloCombo = new DefaultComboBoxModel(new String [] {});
 
                } 
    
    
//   private void llenaComboBox(){
// 
//try {
// 
///* Realizamos la consulta a la base de datos*/
// 
//String sql = "SELECT * FROM vendedor";
// 
///* Se prepara la consulta */
// 
////PreparedStatement vendedor = Conexion.prepareStatement(sql);
////ResultSet ver = vendedor.executeQuery();
// 
///* while recorremos el resultado generado por la consulta */
// 
//while(ver.next()){
// 
///* fijate como con nuestro modelo y su método addElement vamos a agregar cada resultado a nuestro ComboBox, en lo personal concatene el resultado */
// 
//modeloCombo.addElement(ver.getString(1)+"");
// 
//     }
// 
// } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
//    System.out.println("Formulario.IngresoCliente.llenaComboBox()"+ex);
// }
 
       
  
 //  }
   void bloquear(){
    txtcedula.setEnabled(false);   
    txtcod.setEnabled(false);
    txtnom.setEnabled(false);
    txtdir.setEnabled(false);
    txtemail.setEnabled(false);
    txtbarrio.setEnabled(false);
    btnguardar.setEnabled(false);
    btnnuevo.setEnabled(true);
    btncancelar.setEnabled(false);
    btnactualizar.setEnabled(false);
    txtexibidor.setEnabled(false);
    txtcolgadera.setEnabled(false);
    //txtvendedor.setEnabled(false);
    txtareaotros.setEnabled(false); 
    txtTienda.setEnabled(false);
    txttelefono.setEnabled(false);
    }
    void limpiar(){
    txtcod.setText("");
    txtnom.setText("");
    txtdir.setText("");
    txtbarrio.setText("");
    txtemail.setText("");
    txttelefono.setText("");
    txtTienda.setText("");
    txtexibidor.setText("");
    txtcolgadera.setText("");
    txtvendedor.setText("");
    txtareaotros.setText("");
    txtcedula.setText("");
    }
    void desbloquear(){
    txtcedula.setEnabled(true);
    txtcod.setEnabled(true);
     txtcod.setEditable(true);
    txtnom.setEnabled(true);
    txtdir.setEnabled(true);
    txtemail.setEnabled(true);
    txtbarrio.setEnabled(true);
    btnguardar.setEnabled(true);
    btnnuevo.setEnabled(false);
    btncancelar.setEnabled(true);
    btnactualizar.setEnabled(false);
    txtexibidor.setEnabled(true);
    txtcolgadera.setEnabled(true);
    txtvendedor.setEnabled(true);
    txtareaotros.setEnabled(true); 
    txtTienda.setEnabled(true);
    txttelefono.setEnabled(true);
    }
//    void cargarsugerencias (String buscar){
//        String mostrar="SELECT DISTINCT  * FROM sugerencia  where cliente_cod_cli LIKE '%"+buscar+"%'";
//     String []titulos={"idsugerencia","Exhibidor","Colgaderas","Otros"};
//    String []Registros=new String[9];
//    model= new DefaultTableModel(null,titulos);
//  
//        try {
//              Statement st = cn.createStatement();
//              ResultSet rs = st.executeQuery(mostrar);
//             
//              while(rs.next())
//              {
//                  Registros[0]= rs.getString("idsugerencia");
//                  Registros[1]= rs.getString("exhibidor");
//                  Registros[2]= rs.getString("colgaderas"); 
//                  Registros[3]= rs.getString("cliente_cod_cli");             
//                          
//                  model.addRow(Registros);
//                  
//              }
//              tbclientes.setModel(model); 
//              rs.close();
//             // System.out.println("Formulario.IngresoCliente.cargar()" + model.getColumnName(1));
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
//    
//  }
    
    
    void cargar(String valor){
    
    String mostrar="SELECT  * FROM cliente where nombre LIKE '%"+valor+"%'";
//    String mostrar="select * from cliente, sugerencia ";
    String []titulos={"Codigo","Nombre","Cedula","Tienda","Barrio","Telefono","direcion","Vendedor","Correo","Exhibidor","Colgaderas","Otros"};
    String []Registros= new String[12];
    model= new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
             
              while(rs.next())
              {
                 Registros[0]=rs.getString("cod_cli");  
                 Registros[1]=rs.getString("NOMBRE"); 
                 Registros[2]=rs.getString("cedula");   
                 Registros[3]=rs.getString("TIENDA");  
                 Registros[4]=rs.getString("BARRIO");  
                 Registros[5]=rs.getString("TELEFONO");  
                 Registros[6]=rs.getString("direccion");  
                 Registros[7]=rs.getString("vendedor_idvendedor");  
                 Registros[8]=rs.getString("correo");    
                 Registros[9]=rs.getString("exhibidor");                      
                 Registros[10]=rs.getString("colgadera");   
                 Registros[11]=rs.getString("otros");      
                          
                  model.addRow(Registros);
                   
              }
              tbclientes.setModel(model);
              rs.close();
             // System.out.println("Formulario.IngresoCliente.cargar()" + model.getColumnName(1));
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    
  }
    
    void mostrarclientes(String valor)
    {
        String []titulos={"Codigo","Nombre","Cedula","Tienda","Barrio","Telefono","direcion","Vendedor","Correo","Exhibidor","Colgaderas","Otros"};
    String []Registros= new String[12];
        model=new DefaultTableModel(null,titulos);
        String Sql="SELECT * FROM cliente where nombre LIKE '%"+valor+"%'";
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                 Registros[0]=rs.getString("cod_cli");  
                 Registros[1]=rs.getString("NOMBRE");  
                 Registros[2]=rs.getString("TIENDA");  
                 Registros[3]=rs.getString("BARRIO");  
                 Registros[4]=rs.getString("TELEFONO");  
                 Registros[5]=rs.getString("direccion");  
                 Registros[6]=rs.getString("vendedor_idvendedor");  
                 Registros[7]=rs.getString("correo");  
                 Registros[8]=rs.getString("cedula");    
                 Registros[9]=rs.getString("colgadera");    
                 Registros[10]=rs.getString("exhibidor");    
                 Registros[11]=rs.getString("otros");      
                 model.addRow(Registros);
             } 
             tbclientes.setModel(model);
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
    void buscar(String valor){
        
        String[]titulos={"Codigo","Nombre","Cedula","Tienda","Barrio","Telefono","direcion","Codigo Vendedor","Correo","Exhibidor","Colgaderas","Otros" } ;  
        String []Registros= new String[12];
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
                 Registros[2]=rs.getString("Tienda");  
                 Registros[3]=rs.getString("Barrio");  
                 Registros[4]=rs.getString("Telefono");  
                 Registros[5]=rs.getString("Direccion");  
                 Registros[6]=rs.getString("Vendedor_idVendedor");  
                 Registros[7]=rs.getString("Correo");  
                 Registros[8]=rs.getString("Cedula");  
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
    
    
    
    void ingresosugerencias(String valor){
        
        
         String cod,colgadera,exibidor,otros;
            String sql="";
            cod=txtcod.getText();
            colgadera=txtcolgadera.getText();
            exibidor=txtexibidor.getText();
            otros=txtareaotros.getText();
            
            sql="INSERT INTO sugerencia (EXHIBIDOR,COLGADERAS,OTROS,CLIENTE_COD_CLI) VALUES (?,?,?,?)";
        try {
    
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, colgadera);
            pst.setString(2, exibidor);
            pst.setString(3, otros);
            pst.setString(4, cod);
            
            int n=pst.executeUpdate();
            
            if(n>0){
           
            System.out.println(pst);
            System.out.println("Registro Guardado con Exito");
          }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    void sugerenciasmodificar(){
         try {
        PreparedStatement pst = cn.prepareStatement("UPDATE sugerencia SET exhibidor='"
                +txtexibidor.getText()+ "',colgaderas='"
                +txtcolgadera.getText()+ "',otros='" 
                +txtareaotros.getText()+ "' WHERE cliente_cod_cli='"+txtcod.getText()+"'");
         pst.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//void eliminarsugerencia(){
//    int fila= tbclientes.getSelectedRow();
//    String cod="";
//    cod=tbclientes.getValueAt(fila, 0).toString();
//    if(fila>=0)
//    {
//        try {
//            PreparedStatement pst = cn.prepareStatement("DELETE FROM sugerencia WHERE cliente_cod_cli='"+cod+"'");
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(rootPane, "Eliminado Correctamente");
//            cargar("");
//        } catch (SQLException ex) {
//            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    else
//    {
//        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
//    }
//}            
   void codigosclientes(){
     int j;
        int cont=1;
        String num="";
        String c="";
         String SQL="select max(cod_cli) from cliente";
       // String SQL="select count(*) from factura";
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
                txtcod.setText("");
            }
            else{
            char r1=c.charAt(2);
            char r2=c.charAt(3);
            char r3=c.charAt(4);
            char r4=c.charAt(5);
            String r="";
            r=""+r1+r2+r3+r4;
            
                 j=Integer.parseInt(r);
                 GenerarCodigos gen= new GenerarCodigos();
                 gen.generar(j);
                 txtcod.setText("CC"+gen.serie());
                
            
            }
       
          
                  
           
           
         
        } catch (SQLException ex) {
           Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtbarrio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtexibidor = new javax.swing.JTextField();
        txtcolgadera = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaotros = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtvendedor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/userr.png"))); // NOI18N
        jLabel9.setText("FORMULARIO DE CLIENTES - TIENDA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Principales"));

        jLabel1.setText("Codigo:");

        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });

        jLabel2.setText("Cliente:");

        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });

        jLabel4.setText("Barrio:");

        txtbarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarrioActionPerformed(evt);
            }
        });
        txtbarrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbarrioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbarrioKeyTyped(evt);
            }
        });

        jLabel5.setText("Tienda:");

        jLabel7.setText("Email:");

        jLabel8.setText("Direccion:");

        jLabel11.setText("Exibidor:");

        jLabel12.setText("Colgadera:");

        jLabel13.setText("Otros:");

        txtareaotros.setColumns(20);
        txtareaotros.setRows(5);
        jScrollPane1.setViewportView(txtareaotros);

        jLabel3.setText("Telefono:");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Vendedor:");

        txtvendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvendedorKeyTyped(evt);
            }
        });

        jLabel14.setText("Cedula:");

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtexibidor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtbarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 417, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtnom)
                                                    .addComponent(txtTienda))
                                                .addGap(64, 64, 64)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel14)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtcedula, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtcolgadera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtcolgadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtbarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtexibidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439571_new.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439854_checked_checkbox.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439727_magazine.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/1444439515_close_window.png"))); // NOI18N
        btncancelar.setText("Cancelar ");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/close.png"))); // NOI18N
        btnsalir.setText("Salir      ");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tbclientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jScrollPane2.setViewportView(tbclientes);

        txtbuscar.setText(" ");
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel10.setText("Buscar:");

        jButton1.setText("Mostrar Todos");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
// TODO add your handling code here:
    try {
        PreparedStatement pst = cn.prepareStatement(
                "UPDATE cliente SET nombre='"+txtnom.getText()
                + "',Tienda='" +txtTienda.getText()
                + "',Barrio='" +txtbarrio.getText()
                + "',Telefono='" +txttelefono.getText()
                + "',direccion='" +txtdir.getText()
                + "',vendedor_idvendedor='" +txtvendedor.getText()
                + "',correo='" +txtemail.getText()
                + "',cedula='" +txtcedula.getText()
                + "',exhibidor='" +txtexibidor.getText()
                + "',otros='" +txtareaotros.getText()
                + "',colgadera='" +txtcolgadera.getText() 
                + "' WHERE cod_cli='"+txtcod.getText()+"'");
         
        pst.executeUpdate();
        JOptionPane.showMessageDialog(rootPane, "Registro Actualizado");
        cargar("");
        limpiar();
          bloquear();
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }
    
}//GEN-LAST:event_btnactualizarActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
// TODO add your handling code here:
     desbloquear();
     limpiar();
     codigosclientes();
     txtcod.requestFocus();
}//GEN-LAST:event_btnnuevoActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
// TODO add your handling code here:
    limpiar();
    bloquear();
}//GEN-LAST:event_btncancelarActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
// TODO add your handling code here:
    //nombre apellidos , seco y cedula campos obligatorios
    if (txtnom.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese El Nombre");
    }  if (txtTienda.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese La Tienda");
    }  if (txtdir.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese La Direccion Del Domicilio");
    }  if (txttelefono.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese El Telefono De Contacto");
    }  if (txtnom.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese El Barrio");
      
        } if (txtcedula.getText().length()==0){
        JOptionPane.showMessageDialog(rootPane, "Ingrese Una Cedula");
    }  


    String cod,dir,nom,barrio,tel,tiend,vendedorid,correo,otros,colgadera,exhibidor,cedula,vendedor,exibidor;
            String sql="";
            cod=txtcod.getText();
            dir=txtdir.getText();
            nom=txtnom.getText();
            barrio=txtbarrio.getText();
            tel=txttelefono.getText();
            tiend=txtTienda.getText();
            correo=txtemail.getText();
            otros=txtareaotros.getText();
            colgadera=txtcolgadera.getText();
            exibidor=txtexibidor.getText();
            vendedorid=txtvendedor.getText();
            cedula=txtcedula.getText(); 
            
            sql="INSERT INTO cliente (cod_cli,nombre,tienda,barrio,telefono,direccion,correo,cedula,vendedor_idvendedor,colgadera,exhibidor,otros) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
    
      
            
            PreparedStatement pst  = cn.prepareStatement(sql);
            pst.setString(1, cod);
            pst.setString(2, nom);
            pst.setString(3, tiend);
            pst.setString(4, barrio);
            pst.setString(5, tel);
            pst.setString(6, dir);
            pst.setString(7, correo);
            pst.setString(8, cedula);
            pst.setString(9, vendedorid); 
            pst.setString(10, colgadera);
            pst.setString(11, exibidor);
            pst.setString(12, otros);
            
            int n=pst.executeUpdate();
            
            if(n>0){
            JOptionPane.showMessageDialog(null, "Registro Guardado con Exito");
             String Id = txtcod.getText();
           
            limpiar();
            bloquear();
            }
            cargar("");
        } catch (SQLException ex) {
            Logger.getLogger(IngresoProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
            System.out.println("Formulario.IngresoCliente.btnguardarActionPerformed()"+ e );
        }
}//GEN-LAST:event_btnguardarActionPerformed

private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
// TODO add your handling code here:
   // buscar(txtbuscar.getText());
}//GEN-LAST:event_txtbuscarActionPerformed

private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
// TODO add your handling code here:
//    try {
//        buscar(txtbuscar.getText());
//    } catch (Exception e) {
//        System.out.println("Formulario.IngresoCliente.txtbuscarKeyReleased()"+e);
//    }
mostrarclientes(txtbuscar.getText());
 
}//GEN-LAST:event_txtbuscarKeyReleased

private void txtbarrioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarrioKeyPressed
// TODO add your handling code here:

}//GEN-LAST:event_txtbarrioKeyPressed

private void txtbarrioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarrioKeyTyped
// TODO add your handling code here:
//    char car = evt.getKeyChar();
//    if(txtdni.getText().length()>=8) 
//    evt.consume();
//    if((car<'0' || car>'9')) 
//    evt.consume();
}//GEN-LAST:event_txtbarrioKeyTyped

private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
// TODO add your handling code here:
char car = evt.getKeyChar();    
if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE))
{
   evt.consume();
}
}//GEN-LAST:event_txtnomKeyTyped

private void txtbarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarrioActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtbarrioActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:
    int fila= tbclientes.getSelectedRow();
    String cod="";
    cod=tbclientes.getValueAt(fila, 0).toString();
    if(fila>=0)
    { 
        try {
            PreparedStatement pst = cn.prepareStatement("DELETE FROM cliente WHERE cod_cli='"+cod+"'");
            pst.executeUpdate();
            cargar("");
        } catch (SQLException ex) {
            Logger.getLogger(IngresoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }
        
}//GEN-LAST:event_mneliminarActionPerformed

private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed
// TODO add your handling code here:
     desbloquear();
     btnactualizar.setEnabled(true);
    int filamodificar = 0;
    int cedula;
    cedula= Integer.parseInt(tbclientes.getValueAt(filamodificar, 2).toString());
//    int email;
//    email=Integer.parseInt(tbclientes.getValueAt(filamodificar, 8).toString());
    
    try {
        
   
        filamodificar = tbclientes.getSelectedRow();
            if (filamodificar != -1){
               // JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
        txtcod.setText(tbclientes.getValueAt(filamodificar, 0).toString());
        txtnom.setText(tbclientes.getValueAt(filamodificar, 1).toString());
        txtcedula.setText( tbclientes.getValueAt(filamodificar, 2).toString());
        txtTienda.setText(tbclientes.getValueAt(filamodificar, 3).toString());
        txtbarrio.setText(tbclientes.getValueAt(filamodificar, 4).toString());
        txttelefono.setText(tbclientes.getValueAt(filamodificar, 5).toString());
        txtdir.setText(tbclientes.getValueAt(filamodificar, 6).toString());
        txtvendedor.setText(tbclientes.getValueAt(filamodificar, 7).toString());
        txtemail.setText(tbclientes.getValueAt(filamodificar, 8).toString());
        txtexibidor.setText(tbclientes.getValueAt(filamodificar, 9).toString());
        txtcolgadera.setText(tbclientes.getValueAt(filamodificar, 10).toString());
        txtareaotros.setText(tbclientes.getValueAt(filamodificar, 11).toString());
                } else {
    
                System.err.println("Error");
            }
    }catch (HeadlessException e) {
        System.out.println("Formulario.IngresoCliente.mnmodificarActionPerformed()"+e );
    } 
       
       

          
    
    
}//GEN-LAST:event_mnmodificarActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
//        char car = evt.getKeyChar();
//    if(txttelefono.getText().length()>=8) 
//    evt.consume();
//    if((car<'0' || car>'9')) 
//    evt.consume();
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
    char car = evt.getKeyChar();
    if(txtbarrio.getText().length()>=8) 
    evt.consume();
    if((car<'0' || car>'9')) 
    evt.consume();
    }//GEN-LAST:event_txtcodKeyTyped

    private void txtvendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvendedorKeyTyped
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txtvendedorKeyTyped

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
    char car = evt.getKeyChar();
    if(txtcedula.getText().length()>=13) 
    evt.consume();
    if((car<'0' || car>'9')) 
    evt.consume();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
 cargar(txtbuscar.getText());        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtTienda;
    private javax.swing.JTextArea txtareaotros;
    private javax.swing.JTextField txtbarrio;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcedula;
    public static javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcolgadera;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtexibidor;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}