package practic;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

class Progress implements Runnable//creamos clase llamada avanzando que implementa la interfaz runeable
{
    JProgressBar bar;//Creamos variable de tipo jprogressbar
    JLabel cont;
    ImageIcon image;
    JLabel message;
    
    public Progress(JProgressBar bar,JLabel cont, ImageIcon image, JLabel message) {
        this.bar = bar;
        this.cont = cont;
        this.image = image;
        this.message = message;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++)
        {      
            try 
            {
                Thread.sleep(100);//pusa de 100 milisegundos para que se pause
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Progress.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.getBar().setValue(i);//para saber que metodo se esta ejecutando y se escribe i para que se incremente
            message.setText("Procesando: " + i + "%");
            
            if (this.getBar().getValue() == 100)
            {
                cont.setIcon(image);// "i"para saber que jprogressbar termino

            }                        
        }        
        
    }
    
    
//creacion de metodos getter y setter
    public void setBar(JProgressBar bar)
    {
        this.bar = bar;
    }
    
    public JProgressBar getBar()
    {
        return bar;
    }
  
        

   
}
