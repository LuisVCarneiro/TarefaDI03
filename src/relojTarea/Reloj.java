package relojTarea;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
    
public class Reloj extends JLabel implements Serializable{
    private boolean formato24;
    private SimpleDateFormat sdf24 = new SimpleDateFormat ("HH:mm:ss");
    private SimpleDateFormat sdf12 = new SimpleDateFormat ("hh:mm:ss");
    private Alarma alarma;
    
    public Reloj (){
        Timer time = new Timer();
        time.schedule(new TimerTask(){
            @Override
            public void run(){
                Date hora = new Date();
                if (formato24){
                    setText(sdf24.format(hora));
                }
                else {
                    setText(sdf12.format(hora));
                }
                if (alarma != null){
                    if (alarma.isActiva() && suenaAlarma(hora,alarma.getHoraAlarma())){
                        mensajeAlarma();
                    }
                }
            }
        },0,1000);
    }
    
    public boolean isFormato24(){
        return formato24;
    }
    
    public void setFormato24(boolean formato24){
        this.formato24 = formato24;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    public void mensajeAlarma(){
        JOptionPane.showMessageDialog(this, "¡¡¡¡Ha sonado la alarma!!!!");
    }
    
    public boolean suenaAlarma(Date hora, Date horaAlarma){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hora);
        int horas,minutos,segundos,horasAlarma,minutosAlarma,segundosAlarma;
        horas = calendar.get(Calendar.HOUR);
        minutos = calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND);
        calendar.setTime(horaAlarma);
        horasAlarma = calendar.get(Calendar.HOUR);
        minutosAlarma = calendar.get(Calendar.MINUTE);
        segundosAlarma = calendar.get(Calendar.SECOND);
        if (horas == horasAlarma && minutos == minutosAlarma && segundos == segundosAlarma) return true;
        return false;
    }
        
}
