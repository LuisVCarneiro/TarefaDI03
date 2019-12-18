package relojTarea;


import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;


public class AlarmaPropertyEditor extends PropertyEditorSupport {
    private AlarmaPanel alarmaPanel = new AlarmaPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return alarmaPanel;
    }

    @Override
    public Object getValue() {
        return alarmaPanel.getSelectedValue();
    }

    @Override
    public String getJavaInitializationString() {//Inicializa con estos valores el bean
        Date horaAlarma = alarmaPanel.getSelectedValue().getHoraAlarma();
        boolean activa = alarmaPanel.getSelectedValue().isActiva();
        return "new relojTarea.Alarma(new java.util.Date (" + horaAlarma.getTime() + "l), " + activa + ")"; 
    }
    
    
}
