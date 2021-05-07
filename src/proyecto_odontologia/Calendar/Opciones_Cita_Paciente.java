package proyecto_odontologia.Calendar;

import ConexionMySQL.Conectar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Opciones_Cita_Paciente extends javax.swing.JFrame {
    public JFrame des=new JFrame();
    String Descripcion="No hay Descripcion", Motivo;
    JTextArea ta;
    public Opciones_Cita_Paciente(String nombre, String telefono, String inicio, String fin, String correo, String Descripcion, String Motivo) {
        initComponents();
        btn_sel_usu.setVisible(false);
        btn_agregar.setVisible(false);
        txf_tel.setText(telefono);
        txf_nombre.setText(nombre);
        txf_inicio.setText(inicio);
        txf_final.setText(fin);
        txf_mot.setText(Motivo);
        txf_correo.setText(correo);
        this.Descripcion = Descripcion;
        this.Motivo = Motivo;
        this.setLocationRelativeTo(null);
    }
    public Opciones_Cita_Paciente(){
        initComponents();
        btn_sel_usu.setVisible(false);
        btn_agregar.setVisible(false);
        btn_Des.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txf_tel = new javax.swing.JTextField();
        txf_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txf_inicio = new javax.swing.JTextField();
        txf_final = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txf_correo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txf_mot = new javax.swing.JTextField();
        btn_Des = new javax.swing.JButton();
        btn_sel_usu = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 245, 250));

        txf_tel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txf_nombre.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setBackground(java.awt.SystemColor.window);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\josec\\OneDrive\\Imágenes\\Saved Pictures\\usuarios.png")); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setText("Inicio de la Consulta");

        txf_inicio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_inicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txf_final.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_final.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setText("Fin de la Consulta");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Correo electronico:");

        txf_correo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setText("Motivo:");

        txf_mot.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txf_mot.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_Des.setText("Descripcion");
        btn_Des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DesActionPerformed(evt);
            }
        });

        btn_sel_usu.setText("Sel. Paciente");
        btn_sel_usu.setPreferredSize(new java.awt.Dimension(130, 40));
        btn_sel_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sel_usuActionPerformed(evt);
            }
        });

        btn_agregar.setText("Agregar Cita");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txf_nombre)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sel_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txf_tel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txf_correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txf_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txf_mot, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txf_final, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_Des, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))))
                            .addComponent(jLabel7))
                        .addContainerGap(145, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(242, 242, 242))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(btn_sel_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txf_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txf_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Des)
                            .addComponent(txf_mot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(txf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(txf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DesActionPerformed
        JPanel p=new JPanel();
        ta = new JTextArea(15,30);
        JScrollPane jScrollPane1 = new JScrollPane(ta);

        String Verdana="Verdana";
        ta.setFont(new Font(Verdana, Font.PLAIN, 16));
        ta.setLocation(0, 35);
        p.setBackground(Color.gray);
        p.setVisible(true);
        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(0,350,60,30);
        des.setLocationRelativeTo(null);
        des.setSize(new Dimension(600,350));
        des.setPreferredSize(new Dimension(600,350));
        des.setResizable(false);
        des.setTitle("Descripcion de "+txf_nombre.getText());
        p.setSize(200,200);
        p.add(jScrollPane1);
        des.add(p);
        des.setLocationRelativeTo(null);
//        ta.setBounds(0,45,150,150);
        p.add(aceptar);     
        ta.setVisible(true);
        aceptar.setVisible(true);
        des.setVisible(true);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Descripcion = ta.getText();
                des.dispose();
            }
        });
        if(btn_sel_usu.isVisible()==false){
            String sql="SELECT * FROM `calendario` WHERE `paciente` = "+txf_nombre.getText();
            try {
//                 JOptionPane.showMessageDialog(null,"EEENNNTTTRRRAAA");
                Connection          cn = Conectar.obtener();
                PreparedStatement   ps = cn.prepareStatement(sql);
                ResultSet           rs = ps.executeQuery();
                ta.setText(rs.getString("Descripcion"));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
//                Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,ex);
//                Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_btn_DesActionPerformed

    private void btn_sel_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sel_usuActionPerformed
        String sql="SELECT * FROM usuario";
        try {
            
            JFrame usuarios=new JFrame();
            JPanel p=new JPanel();
            p.setBounds(0,0,usuarios.getSize().width,usuarios.getSize().height);
            p.setBackground(Color.gray);
            usuarios.setPreferredSize(new Dimension(600,300));
            usuarios.setSize(new Dimension(600,300));
            usuarios.add(p);
            
//            usuarios.setResizable(false);
            ArrayList<JButton> btn_usu = new ArrayList<>();
            int contador=0;
            Connection cn = Conectar.obtener();
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            final int tamx=200,tamy=30, sep=2;
            int fila=0, col=0;
            int cory=col*tamx+sep;
            int corx=fila*tamy+sep;
            usuarios.setVisible(true);
            
            while(rs.next()){
                contador++;
                JButton n= new JButton(rs.getString("id")+".- "+rs.getString("Nombre"));
                n.setName(rs.getString("id"));
                n.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                            JOptionPane.showMessageDialog(null, n.getText());
                            String sep[]= n.getText().split(".- ");
                            txf_nombre.setText(sep[1]);
//                            btn_Des.enable();
                            btn_Des.setVisible(true);

                            usuarios.dispose();
                            
                    }
                });
                
                n.setBounds(corx, cory, tamx, tamy);
                fila++;
                n.setVisible(true);

                p.add(n);
                corx=col*tamx+sep;
                cory=fila*tamy+sep;
                p.repaint();
            }
            rs = ps.executeQuery();

            
//            JOptionPane.showMessageDialog(null,"El total es: "+contador);
            
        } catch (SQLException ex) {
            Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sel_usuActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
//        Descripcion=null;
//        JOptionPane.showMessageDialog(null,"/*/**/");
        String fecha,nombre,inicio,fin,motivo,desc;
        boolean correcto=true;
        PreparedStatement ps;
        ResultSet rs;
        
        
        fecha = Calendario.fecha_sel_mod;
        setTitle("Cita dia: "+fecha);
        String sep[] = txf_inicio.getText().split(":");
        if(sep.length!=3){
            correcto=false;
            JOptionPane.showMessageDialog(null,"Hora de Inicio Incorrecta, ejemplo: 15:30:00");
        }
        String sep2[]= txf_final.getText().split(":");
        if(sep2.length!=3){
            correcto=false;
            JOptionPane.showMessageDialog(null,"Hora Final Incorrecta, ejemplo: 15:30:00");
        }
        
        nombre = txf_nombre.getText();
        inicio = txf_inicio.getText();
        fin = txf_final.getText();
        motivo = txf_mot.getText();
        desc = Descripcion;
        if("".equals(fecha)||"".equals(nombre)||"".equals(inicio)||"".equals(fin)||"".equals(motivo)){
            JOptionPane.showMessageDialog(null,"Se requiere que todos los campos sean llenados");
            correcto=false;
        }
        
        
        String sql="INSERT INTO `bd_dentista`.`calendario` (`Fecha` ,`Hora_inicio`,`Hora_Final`,`Motivo`,`Descripcion`,`paciente`) "
                                                + "VALUES ('"+fecha+"','"+inicio+"','"+fin+"','"+motivo+"','"+desc+"','"+nombre+"')";                                                
        if(correcto){
            try {
                Connection cn = Conectar.obtener();
                ps = cn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,sql);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
//                Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,ex);
//                Logger.getLogger(Citas_del_dia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btn_agregarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Opciones_Cita_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opciones_Cita_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opciones_Cita_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones_Cita_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Opciones_Cita_Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Des;
    public javax.swing.JButton btn_agregar;
    public javax.swing.JButton btn_sel_usu;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txf_correo;
    public javax.swing.JTextField txf_final;
    public javax.swing.JTextField txf_inicio;
    public javax.swing.JTextField txf_mot;
    public javax.swing.JTextField txf_nombre;
    public javax.swing.JTextField txf_tel;
    // End of variables declaration//GEN-END:variables
}
