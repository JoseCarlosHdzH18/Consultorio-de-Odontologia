package proyecto_odontologia.Calendar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Boton_de_Citas extends JButton implements ActionListener{
    String Inicio="00:00:00", Final="00:00:00", paciente="Desconocido", correo="No se encuentra", tel="No se encuentra";
    Boton_de_Citas(int x, int y, int ancho, int alto, String paciente, String Inicio, String Final, String tel, String correo){
        this.correo=correo;
        this.tel = tel;
        this.Inicio = Inicio;
        this.Final = Final;
        this.paciente = paciente;
        this.setBounds(x,y,ancho,alto);
        this.setText(paciente);
        this.setName("VA ID");
        this.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Opciones_Cita_Paciente p = new Opciones_Cita_Paciente(paciente,tel,Inicio, Final,correo);
        p.setVisible(true);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
