package proyecto_odontologia.Calendar.Lista_Pacientes;

import ConexionMySQL.Conectar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Listar_Pacientes extends javax.swing.JPanel {
    int seleccion=0;
    String nom, tel, correo, dir, enf;
    public Listar_Pacientes() {
        initComponents();
        actualizar();
    }
    
    public void actualizar(){
        try{
            ArrayList<ArrayList<String>> datos= new ArrayList<>();
            String sql = "SELECT * FROM paciente";
            Connection cn = Conectar.obtener();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new ArrayList<>());
                datos.get(datos.size()-1).add(rs.getInt("id")+"");
                datos.get(datos.size()-1).add(rs.getString("Nombre"));
                datos.get(datos.size()-1).add(rs.getString("Telefono"));
                datos.get(datos.size()-1).add(rs.getString("Correo"));
                datos.get(datos.size()-1).add(rs.getString("Direccion"));
                datos.get(datos.size()-1).add(rs.getString("Enfermedades"));
            }
            datos.add(new ArrayList<>());
            datos.get(datos.size()-1).add((datos.size()-1)+"");
            datos.get(datos.size()-1).add("");
            datos.get(datos.size()-1).add("");
            datos.get(datos.size()-1).add("");
            datos.get(datos.size()-1).add("");
            datos.get(datos.size()-1).add("");
            
            String[][] datosparatabla = new String[datos.size()][6];
            for (int i = 0; i < datos.size(); i++) {
                for (int j = 0; j < 6; j++) {
                    datosparatabla[i][j] = datos.get(i).get(j);
                }
            }
            tabla.setModel(new javax.swing.table.DefaultTableModel(
                datosparatabla,
                new String [] {
                    "ID", "NOMBRE", "TELEFONO", "CORREO", "DIRECCION", "ENFERMEDADES"
                }
                ) {
                    boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "LISTA PACIENTE  "+ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        p_contenedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_Editar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_historial = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        p_contenedor.setBackground(new java.awt.Color(102, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Pacientes del Consultorio");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "TELEFONO", "CORREO", "DIRECCION", "ENFERMEDADES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(30);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout pnl_tablaLayout = new javax.swing.GroupLayout(pnl_tabla);
        pnl_tabla.setLayout(pnl_tablaLayout);
        pnl_tablaLayout.setHorizontalGroup(
            pnl_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnl_tablaLayout.setVerticalGroup(
            pnl_tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        btn_Editar.setText("EDITAR");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_borrar.setText("BORRAR");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_historial.setText("VER HISTORIAL");

        btn_Agregar.setText("AGREGAR");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_contenedorLayout = new javax.swing.GroupLayout(p_contenedor);
        p_contenedor.setLayout(p_contenedorLayout);
        p_contenedorLayout.setHorizontalGroup(
            p_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_contenedorLayout.createSequentialGroup()
                        .addComponent(pnl_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(p_contenedorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Editar)
                        .addGap(37, 37, 37)
                        .addComponent(btn_borrar)
                        .addGap(39, 39, 39)
                        .addComponent(btn_Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btn_historial)
                        .addGap(39, 39, 39))))
        );
        p_contenedorLayout.setVerticalGroup(
            p_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_Editar)
                    .addComponent(btn_borrar)
                    .addComponent(btn_historial)
                    .addComponent(btn_Agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_tabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public boolean Confirmacion(){
        String botones[] = {"Modificar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "Esta seguro que desea modificr la información\nSolo se puede moficicar 1 Fila a la vez","Confirmación",0,0,null,botones,this);
        switch (eleccion) {
            case JOptionPane.YES_OPTION:
                return true;
            case JOptionPane.NO_OPTION:
                return false;
            default:
                return false;
        }
    }
    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        boolean con=Confirmacion();
        if(con){
            try{
                String sql="UPDATE `bd_dentista` . `paciente` SET Nombre='"+
                        tabla.getValueAt(seleccion, 1)+
                        "',Telefono='"+
                        tabla.getValueAt(seleccion, 2)+
                        "',Correo='"+
                        tabla.getValueAt(seleccion, 3)+
                        "',Direccion='"+
                        tabla.getValueAt(seleccion, 4)+
                        "',Enfermedades='"+
                        tabla.getValueAt(seleccion, 5)+
                        "' WHERE id="+tabla.getValueAt(seleccion, 0);

                Connection cn = Conectar.obtener();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "EDITADO CORRECTAMENTE");
                tabla.clearSelection();
                actualizar();

            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "EDITAR PACIENTE: "+ex);
            }
        }else{
            tabla.clearSelection();
            actualizar();
        }   
        
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        seleccion  = tabla.getSelectedRow();
        nom = (String) tabla.getValueAt(seleccion, 1);
        tel = (String) tabla.getValueAt(seleccion, 2);
        correo = (String) tabla.getValueAt(seleccion, 3);
        dir = (String) tabla.getValueAt(seleccion, 4);
        enf = (String) tabla.getValueAt(seleccion, 5);
        
    }//GEN-LAST:event_tablaMouseClicked

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        try {
            String sql="DELETE FROM `bd_dentista` . `paciente` WHERE id = '"+tabla.getValueAt(seleccion, 0)+"';";
            Connection cn = Conectar.obtener();
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
            actualizar();
        } catch (SQLException ex) {
            Logger.getLogger(Listar_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Listar_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch(HeadlessException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "ELIMINAR PACIENTE: "+ex);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        if(seleccion+1 == tabla.getRowCount()){
            try {
                String id = (String) tabla.getValueAt(seleccion, 0);
                nom = (String) tabla.getValueAt(seleccion, 1);
                tel = (String) tabla.getValueAt(seleccion, 2);
                correo = (String) tabla.getValueAt(seleccion, 3);
                dir = (String) tabla.getValueAt(seleccion, 4);
                enf = (String) tabla.getValueAt(seleccion, 5);
                if(!nom.equals("")){
                    String sql="INSERT INTO `bd_dentista`.`paciente` (`id`, `Nombre`, `Telefono`, `Correo`, `Direccion`, `Enfermedades`) VALUES ('"+id+"','"+nom+"','"+tel+"','"+correo+"','"+dir+"','"+enf+"')";                                      
                    Connection cn = Conectar.obtener();
                    PreparedStatement ps=cn.prepareStatement(sql);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "AGREGADO CORRECTAMENTE");
                    actualizar();
                }else{
                    JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO ALGUN NOMBRE");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Listar_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listar_Pacientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "AGREGAR PACIENTE: "+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SE AGREGA LA INF EN LA ULTIMA FILA: "+(seleccion+1)+" , "+tabla.getRowCount());
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_historial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_contenedor;
    private javax.swing.JPanel pnl_tabla;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
