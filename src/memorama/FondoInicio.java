/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class FondoInicio extends JLayeredPane{
   
    JLabel Iniciar;
     JLabel Imagen;

    public FondoInicio(){
        
   
    setBorder(BorderFactory.createLineBorder(Color.black, 6));
    Color Color = new Color(0, 204, 249);
        
    this.setLayout(null);
    
      Inicio();
      add(Iniciar,2,0);
     
    
    }
   


    public void Inicio(){
    Font Fondo = new Font("Serief", Font.BOLD, 40);
    Iniciar=new JLabel("Empezar Juego");
    Iniciar.setBounds(160,300,300, 100);
    Iniciar.setForeground(Color.WHITE);
    Iniciar.setFont(Fondo);
    
     ImageIcon foto = new ImageIcon("3.png");
                
 
    Imagen=new JLabel();
    Imagen.setBounds(195,60,250, 300);
   Imagen.setIcon(new ImageIcon(foto.getImage().getScaledInstance(Imagen.getWidth(),Imagen.getHeight(), Image.SCALE_SMOOTH)));
    
    
    }
    
}
