package proyecto_odontologia.Calendar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyecto_odontologia.Proyecto_Odontologia;

public class Calendario extends javax.swing.JPanel {
    Citas_del_dia cdd;
    ArrayList<Boton_de_Citas> citas;
    Boton_de_Citas btn;
    public static Date fecha;
    public static String fecha_sel_mod;
    public Calendario() {
        initComponents();
        this.setVisible(true);
        citas = new ArrayList<>();
        
        cdd = new Citas_del_dia();
        pnl_Citas.add(cdd);
        cdd.setBounds(0,0,545, 396);
        cdd.setVisible(true);
        
        
        cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                try {
                    jCalendar1PropertyChange(evt); // o el nombde de método que quiera para manejarlo
                } catch (ParseException ex) {
                    Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) throws ParseException {     
//        JOptionPane.showMessageDialog(null,cal.getDate().toLocaleString());
        fecha = cal.getDate();
        int tamano_panel = Citas_del_dia.Contenedor_Citas.getHeight();
        int btn_fila=0, btn_col=0, alto_boton=tamano_panel/5, ancho_boton=Citas_del_dia.Contenedor_Citas.getWidth()/3;
        int sep = alto_boton+1;
        
        citas.clear();
        Citas_del_dia.Contenedor_Citas.removeAll();
        Citas_del_dia.Contenedor_Citas.repaint();
        try {
            String cale = "SELECT * FROM calendario";
            PreparedStatement consulta = Proyecto_Odontologia.conexion.prepareStatement(cale );
            ResultSet resultado = consulta.executeQuery();
            String usu = "SELECT * FROM usuario";
            PreparedStatement con_usu = Proyecto_Odontologia.conexion.prepareStatement(usu );
            ResultSet res_usu = con_usu.executeQuery();
            while(resultado.next()){
                String fecha_seleccionada = cal.getDate().toLocaleString();// Guarda esto:   20/04/2021 04:04:05 PM
                String paciente = resultado.getString("paciente");
                String fecha_Mysql = resultado.getString("Fecha");
                String Hora_inicio_Mysql = resultado.getString("Hora_Inicio");
                String Hora_final_Mysql = resultado.getString("Hora_Final");
                String Descripcion = resultado.getString("Descripcion");
                String Motivo = resultado.getString("Motivo");
                String Tel ="FALTA BUSCARLO EN MYSQL";//= res_usu.getString("Telefono");
                String correo="FALTA BUSCARLO EN MYSQL";// = res_usu.getString("Correo");
                fecha_sel_mod = procesamiento_fecha(fecha_seleccionada);
                System.out.println(fecha_sel_mod+"    /*/ "+fecha_Mysql + "  /*/  ");
                
                if(fecha_Mysql.equals(fecha_sel_mod)){
                    if(tamano_panel<=btn_fila*sep){
                        btn_col++;
                        btn_fila=0;
                    }
                    try{
                        btn = new Boton_de_Citas(btn_col*ancho_boton, btn_fila*alto_boton, ancho_boton, alto_boton, paciente,Hora_inicio_Mysql,Hora_final_Mysql, Tel, correo, Descripcion, Motivo);
                        Citas_del_dia.Contenedor_Citas.add(btn);
                        btn.setVisible(true);
                        citas.add(btn);
                        btn_fila++;
                        Citas_del_dia.Contenedor_Citas.repaint();
                        //JOptionPane.showMessageDialog(null,"Se encontró con "+paciente);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Se encontró un error "+e);
                    }
                    
                }
            }
            System.out.print("\nTamano de citas: "+citas.size()+"\n");
            lbl_num_citas.setText(""+citas.size());
            Citas_del_dia.Contenedor_Citas.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(Proyecto_Odontologia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Se encontró un error  :( "+ex);
        }
        
    } 
    
    
    private String procesamiento_fecha(String fecha){ //Recibe:  20/04/2021 04:04:05 PM
        String[] sep  = fecha.split(" ");//Obtenemos [ 20/04/2021 ][ 04:04:05 ] [ PM ]
        String aux = sep[0];
        String[] sep2 = aux.split("/");//Obtenemos [20] [04] [2021]
        
        if(Integer.parseInt(sep2[0])<10){
            sep2[0]="0"+sep2[0];
        }
        return sep2[2]+"-"+sep2[1]+"-"+sep2[0]; //Regresa 2021-04-20
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        cal = new com.toedter.calendar.JCalendar();
        pnl_Citas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_num_citas = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);

        cal.setBackground(new java.awt.Color(255, 255, 255));
        cal.setForeground(new java.awt.Color(0, 0, 102));
        cal.setAlignmentX(0.0F);
        cal.setAlignmentY(0.0F);
        cal.setDecorationBackgroundColor(new java.awt.Color(20, 42, 72));
        cal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cal.setSundayForeground(new java.awt.Color(204, 0, 0));
        cal.setWeekdayForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pnl_Citas.setBackground(new java.awt.Color(0, 51, 51));
        pnl_Citas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        pnl_Citas.setAlignmentX(0.0F);
        pnl_Citas.setAlignmentY(0.0F);
        pnl_Citas.setPreferredSize(new java.awt.Dimension(545, 396));

        javax.swing.GroupLayout pnl_CitasLayout = new javax.swing.GroupLayout(pnl_Citas);
        pnl_Citas.setLayout(pnl_CitasLayout);
        pnl_CitasLayout.setHorizontalGroup(
            pnl_CitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        pnl_CitasLayout.setVerticalGroup(
            pnl_CitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jPanel3.setBackground(new java.awt.Color(193, 213, 232));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 409));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Citas de Hoy");

        lbl_num_citas.setFont(new java.awt.Font("Verdana", 0, 100)); // NOI18N
        lbl_num_citas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_num_citas.setText("115");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_num_citas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_num_citas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setPreferredSize(new java.awt.Dimension(356, 409));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 409));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnl_Citas, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Citas, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.toedter.calendar.JCalendar cal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_num_citas;
    private javax.swing.JPanel pnl_Citas;
    // End of variables declaration//GEN-END:variables
}

